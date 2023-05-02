package net.nimazare.sevenlearnstudentsmvvm;

import androidx.lifecycle.LiveData;

import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;

public class StudentRepository {
    private ApiService apiService;
    private StudentDao studentDao;

    public StudentRepository(ApiService apiService, StudentDao studentDao) {
        this.apiService = apiService;
        this.studentDao = studentDao;
    }

    public @NonNull Completable refreshStudents() {
        return apiService.getStudents().doOnSuccess(students -> studentDao.addStudents(students)).ignoreElement();
    }

    public LiveData<List<Student>> getStudents() {
        return studentDao.getStudents();
    }
}
