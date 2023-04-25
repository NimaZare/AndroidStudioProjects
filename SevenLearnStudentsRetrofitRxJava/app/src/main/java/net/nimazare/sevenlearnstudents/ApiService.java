package net.nimazare.sevenlearnstudents;

import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.List;

import io.reactivex.Single;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
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
                .baseUrl("http://expertdevelopers.ir/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        retrofitApiService = retrofit.create(RetrofitApiService.class);
    }

    public Single<Student> saveStudent(String firstName, String lastName, String course, int score) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("first_name", firstName);
        jsonObject.addProperty("last_name", lastName);
        jsonObject.addProperty("course", course);
        jsonObject.addProperty("score", score);
        return retrofitApiService.saveStudent(jsonObject);
    }

    public Single<List<Student>> getStudents() {
        return retrofitApiService.getStudents();
    }
}
