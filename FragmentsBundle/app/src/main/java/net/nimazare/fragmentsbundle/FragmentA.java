package net.nimazare.fragmentsbundle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FragmentA extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnGoToB = view.findViewById(R.id.btn_a_done);
        btnGoToB.setOnClickListener(view1 -> {
            EditText etInput = view.findViewById(R.id.et_a_text);
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame_main_fragmentContainer, FragmentB.newInstance(etInput.getText().toString()));
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });
    }
}
