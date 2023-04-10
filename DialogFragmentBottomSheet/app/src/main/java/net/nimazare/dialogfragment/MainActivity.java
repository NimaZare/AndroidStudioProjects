package net.nimazare.dialogfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainDialog.MyDialogEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnShowDialog = findViewById(R.id.btn_main_showDialog);
        btnShowDialog.setOnClickListener(view -> {
            MainDialog mainDialog = new MainDialog();
            mainDialog.setCancelable(false);
            mainDialog.show(getSupportFragmentManager(), null);
        });
    }

    @Override
    public void onOkButtonClicked(String data) {
        TextView tvMain = findViewById(R.id.tv_main_showText);
        tvMain.setText(data);
    }

    @Override
    public void onCancelButtonClicked() {
        Toast.makeText(this, "Cancel Button Clicked.", Toast.LENGTH_SHORT).show();
    }
}