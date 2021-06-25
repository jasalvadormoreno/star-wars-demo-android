package es.jasalvador.starwarsdemo.domain.common;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableTransformer;

public abstract class CompletableUseCaseWithParams<Params> {

    private final CompletableTransformer transformer;

    public CompletableUseCaseWithParams(CompletableTransformer transformer) {
        this.transformer = transformer;
    }

    protected abstract Completable createCompletable(Params params);

    public Completable completable(Params params) {
        return createCompletable(params).compose(transformer);
    }
}
