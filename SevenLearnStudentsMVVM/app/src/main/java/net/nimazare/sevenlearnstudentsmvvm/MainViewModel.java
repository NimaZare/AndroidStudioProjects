package net.nimazare.sevenlearnstudentsmvvm;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    private ApiService apiService;
    private MutableLiveData<List<Student>> students = new MutableLiveData<>();
    private MutableLiveData<String> error = new MutableLiveData<>();

    public MainViewModel(ApiService apiService) {
        this.apiService = apiService;
        this.apiService.getStudents().enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(@NonNull Call<List<Student>> call, @NonNull Response<List<Student>> response) {
                students.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<Student>> call, @NonNull Throwable t) {
                error.setValue(t.getMessage());
            }
        });
    }

    public LiveData<List<Student>> getStudents() {
        return students;
    }

    public LiveData<String> getError() {
        return error;
    }
}
