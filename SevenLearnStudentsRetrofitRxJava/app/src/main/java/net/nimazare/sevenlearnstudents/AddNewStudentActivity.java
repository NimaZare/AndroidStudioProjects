package net.nimazare.sevenlearnstudents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AddNewStudentActivity extends AppCompatActivity {

    private static final String TAG = "AddNewStudentActivity";
    private ApiService apiService;
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_student);
        apiService = new ApiService();
        Toolbar toolbar = findViewById(R.id.toolbar_addNewStudent);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back_white_24dp);
        TextInputEditText etFirstName = findViewById(R.id.et_addNewStudent_firstName);
        TextInputEditText etLastName = findViewById(R.id.et_addNewStudent_lastName);
        TextInputEditText etCourse = findViewById(R.id.et_addNewStudent_course);
        TextInputEditText etScore = findViewById(R.id.et_addNewStudent_score);
        View btnSave = findViewById(R.id.fab_addNewStudent_save);
        btnSave.setOnClickListener(view -> {
            if (etFirstName.length() > 0 && etLastName.length() > 0
                    && etCourse.length() > 0 && etScore.length() > 0) {
                apiService.saveStudent(etFirstName.getText().toString(), etLastName.getText().toString(),
                                etCourse.getText().toString(), Integer.parseInt(etScore.getText().toString()))
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new SingleObserver<Student>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                AddNewStudentActivity.this.disposable = d;
                            }

                            @Override
                            public void onSuccess(Student student) {
                                Intent intent = new Intent();
                                intent.putExtra("student", student);
                                setResult(Activity.RESULT_OK, intent);
                                finish();
                            }

                            @Override
                            public void onError(Throwable e) {
                                Toast.makeText(AddNewStudentActivity.this, "Unknown Error!", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (disposable != null) disposable.dispose();
    }
}