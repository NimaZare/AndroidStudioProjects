package net.nimazare.dialogfragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class MainDialog extends BottomSheetDialogFragment {
    private MyDialogEventListener eventListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        eventListener = (MyDialogEventListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_main_showtext, null, false);
        Button btnOk = view.findViewById(R.id.btn_dialog_ok);
        Button btnCancel = view.findViewById(R.id.btn_dialog_cancel);
        EditText etInput = view.findViewById(R.id.et_dialog_input);
        btnOk.setOnClickListener(view1 -> {
            if (etInput.length() > 0){
                eventListener.onOkButtonClicked(etInput.getText().toString());
                dismiss();
            }
        });
        btnCancel.setOnClickListener(view1 -> {
            eventListener.onCancelButtonClicked();
            dismiss();
        });
        return view;
    }

    public interface MyDialogEventListener{
        void onOkButtonClicked(String data);
        void onCancelButtonClicked();
    }
}
