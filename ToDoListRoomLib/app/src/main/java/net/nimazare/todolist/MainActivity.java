package net.nimazare.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AddTaskDialog.AddNewTaskCallback, TaskAdapter.TaskItemEventListener, EditTaskDialog.EditTaskCallback {

    private TaskDao taskDao;
    private TaskAdapter taskAdapter = new TaskAdapter(this);
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        taskDao = DatabaseManager.getDatabaseManager(this).getTaskDao();
        RecyclerView recyclerView = findViewById(R.id.rv_main_tasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(taskAdapter);
        List<Task> tasks = taskDao.getAll();
        taskAdapter.addItems(tasks);
        View addNewTaskFab = findViewById(R.id.fab_main_addNewTask);
        addNewTaskFab.setOnClickListener(v -> {
            AddTaskDialog dialog = new AddTaskDialog();
            dialog.show(getSupportFragmentManager(), null);
        });
        View btnDeleteAllTasks = findViewById(R.id.iv_main_deleteAllTasks);
        btnDeleteAllTasks.setOnClickListener(view -> {
            taskDao.deleteAll();
            taskAdapter.deleteAllItems();
        });
        EditText etSearch = findViewById(R.id.et_main_search);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    List<Task> searchedTasks = taskDao.search(charSequence.toString());
                    taskAdapter.changeTasks(searchedTasks);
                } else {
                    List<Task> oldTasks = taskDao.getAll();
                    taskAdapter.changeTasks(oldTasks);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void onNewTask(Task task) {
        long taskId = taskDao.add(task);
        if (taskId != -1) {
            task.setId(taskId);
            taskAdapter.addItem(task);
        } else {
            Log.e(TAG, "onNewTask: item did not inserted !");
        }
    }

    @Override
    public void onDeleteButtonClicked(Task task) {
        int result = taskDao.delete(task);
        if (result > 0){
            taskAdapter.deleteItem(task);
        }
    }

    @Override
    public void onItemLongPress(Task task) {
        EditTaskDialog editTaskDialog = new EditTaskDialog();
        Bundle bundle = new Bundle();
        bundle.putParcelable("task", task);
        editTaskDialog.setArguments(bundle);
        editTaskDialog.show(getSupportFragmentManager(), null);
    }

    @Override
    public void onItemCheckedChange(Task task) {
        taskDao.update(task);
    }

    @Override
    public void onEditTask(Task task) {
        int result = taskDao.update(task);
        if (result > 0) {
            taskAdapter.updateItem(task);
        }
    }
}
