package net.nimazare.sevenlearnstudents;

import android.content.Context;

import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static final String TAG = "ApiService";
    private static final String BASE_REQUEST_URL = "http://expertdevelopers.ir/api/v1/";
    private RetrofitApiService retrofitApiService;

    public ApiService() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request oldRequest = chain.request();
                        Request.Builder newRequest = oldRequest.newBuilder();
                        newRequest.addHeader("Accept", "application/json");
                        // newRequest.addHeader("Authorization", "YOUR TOKEN HERE");
                        return chain.proceed(newRequest.build());
                    }
                }).build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://expertdevelopers.ir/api/v1/")
                .client(okHttpClient)
                .build();
        retrofitApiService = retrofit.create(RetrofitApiService.class);
    }

    public void saveStudent(String firstName, String lastName, String course, int score, SaveStudentCallback callback) {

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("first_name", firstName);
        jsonObject.addProperty("last_name", lastName);
        jsonObject.addProperty("course", course);
        jsonObject.addProperty("score", score);

        retrofitApiService.saveStudent(jsonObject).enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {
                callback.onError(new Exception(t));
            }
        });
    }

    public void getStudents(StudentListCallback callback) {

        retrofitApiService.getStudents().enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                callback.onError(new Exception(t));
            }
        });
    }

    public void cancelRequests() {

    }

    public interface SaveStudentCallback {
        void onSuccess(Student student);

        void onError(Exception error);
    }

    public interface StudentListCallback {
        void onSuccess(List<Student> students);

        void onError(Exception error);
    }
}
