package net.nimazare.sevenlearnstudentsmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainViewModel viewModel = new ViewModelProvider(this, new MainViewModelFactory(new StudentRepository(ApiServiceProvider.getApiService(),
                AppDatabase.getInstance(getApplicationContext()).studentDao())))
                .get(MainViewModel.class);
        viewModel.getStudents().observe(this, students -> {
            Log.i("MainActivity", "Students :  " + students);
        });
        viewModel.getError().observe(this, error -> {
            Log.i("MainActivity", "Error : " + error);
        });
    }
}