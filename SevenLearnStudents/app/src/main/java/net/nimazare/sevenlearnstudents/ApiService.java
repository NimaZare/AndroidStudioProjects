package net.nimazare.sevenlearnstudents;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ApiService {

    private static RequestQueue requestQueue;
    private static final String TAG = "ApiService";
    private static final String BASE_REQUEST_URL = "http://expertdevelopers.ir/api/v1/";
    private String requestTag;
    private Gson gson;

    public ApiService(Context context, String requestTag) {
        this.requestTag = requestTag;
        this.gson = new Gson();
        if (requestQueue == null)
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public void saveStudent(String firstName, String lastName, String course, int score, SaveStudentCallback callback) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("first_name", firstName);
            jsonObject.put("last_name", lastName);
            jsonObject.put("course", course);
            jsonObject.put("score", score);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST,
                BASE_REQUEST_URL + "experts/student", jsonObject, response -> {
            Student student = gson.fromJson(response.toString(), Student.class);
            callback.onSuccess(student);
        }, error -> {
            callback.onError(error);
        });
        request.setTag(requestTag);
        requestQueue.add(request);
    }

    public void getStudents(StudentListCallback callback) {
        StringRequest request = new StringRequest(Request.Method.GET,
                BASE_REQUEST_URL + "experts/student", response -> {
            List<Student> students = gson.fromJson(response, new TypeToken<List<Student>>() {
            }.getType());
            callback.onSuccess(students);
        }, error -> callback.onError(error));

        request.setTag(requestTag);
        requestQueue.add(request);
    }

    public void cancelRequests() {
        requestQueue.cancelAll(requestTag);
    }

    public interface SaveStudentCallback {
        void onSuccess(Student student);

        void onError(VolleyError error);
    }

    public interface StudentListCallback {
        void onSuccess(List<Student> students);

        void onError(VolleyError error);
    }
}
