package es.jasalvador.starwarsdemo.domain.features.sync;

import es.jasalvador.starwarsdemo.domain.common.CompletableUseCase;
import es.jasalvador.starwarsdemo.domain.repositories.IPeopleRepository;
import es.jasalvador.starwarsdemo.domain.repositories.IStarshipsRepository;
import es.jasalvador.starwarsdemo.domain.repositories.IVehiclesRepository;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableTransformer;

public class SyncDataUseCase extends CompletableUseCase {

    public SyncDataUseCase(
            CompletableTransformer transformer,
            IPeopleRepository peopleRepository,
            IStarshipsRepository starshipsRepository,
            IVehiclesRepository vehiclesRepository
    ) {
        super(transformer);
    }

    @Override
    protected Completable createCompletable() {

        return null;
    }
}
