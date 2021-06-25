package es.jasalvador.starwarsdemo.ui.main;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import es.jasalvador.starwarsdemo.domain.features.test.TestUseCase;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class MainViewModel extends ViewModel {

    private final CompositeDisposable sCompositeDisposable = new CompositeDisposable();

    private final TestUseCase testUseCase;

    private final MutableLiveData<String> _result = new MutableLiveData<>();
    public LiveData<String> result = _result;

    public MainViewModel(TestUseCase testUseCase) {
        this.testUseCase = testUseCase;

        Log.d("MainActivity", "Starting");
        sCompositeDisposable.add(testUseCase.observable("Prueba de coso!!").subscribe(_result::setValue));
    }

    @Override
    protected void onCleared() {
        sCompositeDisposable.clear();
        super.onCleared();
    }
}
