package net.nimazare.fragmenttransaction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frame_main_fragmentContainer, new FragmentA());
        fragmentTransaction.commit();

        Button btnRemoveTransaction = findViewById(R.id.btn_main_removeFragment);
        btnRemoveTransaction.setOnClickListener(view -> {
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frame_main_fragmentContainer);
            if (fragment != null){
                FragmentTransaction removeTransaction = getSupportFragmentManager().beginTransaction();
                removeTransaction.remove(fragment);
                removeTransaction.commit();
            }
        });
    }
}