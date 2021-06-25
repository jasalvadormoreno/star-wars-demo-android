package es.jasalvador.starwarsdemo.domain.common;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableTransformer;

public abstract class ObservableUseCaseWithParams<Params, T> {

    private final ObservableTransformer<T, T> transformer;

    public ObservableUseCaseWithParams(ObservableTransformer<T, T> transformer) {
        this.transformer = transformer;
    }

    protected abstract Observable<T> createObservable(Params params);

    public Observable<T> observable(Params params) {
        return createObservable(params).compose(transformer);
    }
}
