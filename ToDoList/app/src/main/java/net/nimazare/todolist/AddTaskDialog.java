package net.nimazare.todolist;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class AddTaskDialog extends DialogFragment {

    private AddNewTaskCallback callback;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        callback = (AddNewTaskCallback) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_add_task, null, false);
        TextInputEditText etTitle = view.findViewById(R.id.et_dialog_title);
        TextInputLayout inputLayout = view.findViewById(R.id.etl_dialog_title);
        View btnSave = view.findViewById(R.id.btn_dialog_save);
        btnSave.setOnClickListener(view1 -> {
            if (etTitle.length() > 0) {
                Task task = new Task();
                task.setTitle(etTitle.getText().toString());
                task.setCompleted(false);
                callback.onNewTask(task);
                dismiss();
            } else {
                inputLayout.setError("عنوان نباید خالی باشد!");
            }
        });
        builder.setView(view);
        return builder.create();
    }

    public interface AddNewTaskCallback {
        void onNewTask(Task task);
    }
}
