package net.nimazare.sevenlearnstudentsmvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    private MutableLiveData<String> error = new MutableLiveData<>();
    private StudentRepository repository;
    private Disposable disposable;

    public MainViewModel(StudentRepository repository) {
        this.repository = repository;
        repository.refreshStudents().subscribeOn(Schedulers.io()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                disposable = d;
            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onError(@NonNull Throwable e) {
                error.postValue("[MainViewModel]: Unknown Error!");
            }
        });
    }

    public LiveData<List<Student>> getStudents() {
        return repository.getStudents();
    }

    public LiveData<String> getError() {
        return error;
    }

    @Override
    protected void onCleared() {
        disposable.dispose();
        super.onCleared();
    }
}
