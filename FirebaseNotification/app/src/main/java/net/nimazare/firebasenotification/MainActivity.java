package net.nimazare.firebasenotification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnHelloWorld = findViewById(R.id.btnHello);
        btnHelloWorld.setOnClickListener(view -> {
            FirebaseMessaging.getInstance().subscribeToTopic("Esteghlal")
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful())
                            Toast.makeText(MainActivity.this, "Subscribe to topic successfully.", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity.this, "Subscribe to topic Error!", Toast.LENGTH_SHORT).show();
                    });
        });
    }
}