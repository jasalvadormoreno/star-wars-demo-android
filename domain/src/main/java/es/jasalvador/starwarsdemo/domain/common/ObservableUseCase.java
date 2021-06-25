package es.jasalvador.starwarsdemo.domain.common;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableTransformer;

public abstract class ObservableUseCase<T> {

    private final ObservableTransformer<T, T> transformer;

    public ObservableUseCase(ObservableTransformer<T, T> transformer) {
        this.transformer = transformer;
    }

    protected abstract Observable<T> createObservable();

    public Observable<T> observable() {
        return createObservable().compose(transformer);
    }
}
