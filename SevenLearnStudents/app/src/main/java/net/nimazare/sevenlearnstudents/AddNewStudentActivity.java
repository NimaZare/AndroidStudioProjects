package net.nimazare.sevenlearnstudents;

import androidx.activity.result.ActivityResult;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class AddNewStudentActivity extends AppCompatActivity {

    private static final String TAG = "AddNewStudentActivity";
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_student);
        apiService = new ApiService(this, TAG);
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
                        etCourse.getText().toString(), Integer.parseInt(etScore.getText().toString()),
                        new ApiService.SaveStudentCallback() {
                            @Override
                            public void onSuccess(Student student) {
                                Intent intent = new Intent();
                                intent.putExtra("student", student);
                                setResult(Activity.RESULT_OK, intent);
                                finish();
                            }

                            @Override
                            public void onError(VolleyError error) {
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
        apiService.cancelRequests();
    }
}