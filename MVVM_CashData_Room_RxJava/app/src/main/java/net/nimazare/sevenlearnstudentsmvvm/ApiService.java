package net.nimazare.sevenlearnstudentsmvvm;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface ApiService {
    @GET("experts/student")
    Single<List<Student>> getStudents();
}
