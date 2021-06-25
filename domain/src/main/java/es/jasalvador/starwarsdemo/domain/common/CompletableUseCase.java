package es.jasalvador.starwarsdemo.domain.common;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableTransformer;

public abstract class CompletableUseCase {

    private final CompletableTransformer transformer;

    public CompletableUseCase(CompletableTransformer transformer) {
        this.transformer = transformer;
    }

    protected abstract Completable createCompletable();

    public Completable completable() {
        return createCompletable().compose(transformer);
    }
}
