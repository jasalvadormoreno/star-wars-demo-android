package es.jasalvador.starwarsdemo.domain.features.test;

import java.util.concurrent.TimeUnit;

import es.jasalvador.starwarsdemo.domain.common.ObservableUseCaseWithParams;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableTransformer;

public class TestUseCase extends ObservableUseCaseWithParams<String, String> {

    public TestUseCase(ObservableTransformer<String, String> transformer) {
        super(transformer);
    }

    @Override
    protected Observable<String> createObservable(String s) {
        return Observable.timer(3, TimeUnit.SECONDS).map(aLong -> "Test: " + s);
    }
}
