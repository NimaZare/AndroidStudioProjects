package net.nimazare.todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<Task> tasks = new ArrayList<>();
    private static TaskItemEventListener eventListener;


    public TaskAdapter(TaskItemEventListener eventListener) {
        this.eventListener = eventListener;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TaskViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.bindTask(tasks.get(position));
    }

    public void addItem(Task task) {
        tasks.add(0, task);
        notifyItemInserted(0);
    }

    public void addItems(List<Task> tasks) {
        this.tasks.addAll(tasks);
        notifyDataSetChanged();
    }

    public void changeTasks(List<Task> tasks) {
        this.tasks = tasks;
        notifyDataSetChanged();
    }

    public void updateItem(Task task) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == task.getId()) {
                tasks.set(i, task);
                notifyItemChanged(i);
            }
        }
    }

    public void deleteItem(Task task) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == task.getId()) {
                tasks.remove(i);
                notifyItemRemoved(i);
                break;
            }
        }
    }

    public void deleteAllItems() {
        this.tasks.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {

        private CheckBox checkBox;
        private View btnDelete;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.checkBox_task);
            btnDelete = itemView.findViewById(R.id.btn_task_delete);
        }

        public void bindTask(Task task) {
            checkBox.setOnCheckedChangeListener(null);
            checkBox.setChecked(task.isCompleted());
            checkBox.setText(task.getTitle());
            btnDelete.setOnClickListener(view -> eventListener.onDeleteButtonClicked(task));
            itemView.setOnLongClickListener(view -> {
                eventListener.onItemLongPress(task);
                return false;
            });
            checkBox.setOnCheckedChangeListener((compoundButton, b) -> {
                task.setCompleted(b);
                eventListener.onItemCheckedChange(task);
            });
        }
    }

    public interface TaskItemEventListener {
        void onDeleteButtonClicked(Task task);
        void onItemLongPress(Task task);
        void onItemCheckedChange(Task task);
    }
}
