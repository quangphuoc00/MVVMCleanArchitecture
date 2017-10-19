package com.peterdang.domain;


import io.reactivex.Observable;
import io.reactivex.Scheduler;

/**
 * Abstraction for single unit of work from business logic standpoint. Purpose of this use case
 * is to query for data.
 *
 * @param <DataReturn> Data returned to the observer.
 * @param <Params> Parameters needed to perform the unit of work.
 */
public abstract class QueryUseCase<DataReturn, Params> {

    private final Scheduler mWorkScheduler;
    private final Scheduler mObserveScheduler;

    protected QueryUseCase(Scheduler workScheduler, Scheduler observeScheduler) {
        this.mWorkScheduler = workScheduler;
        this.mObserveScheduler = observeScheduler;
    }

    public Observable<DataReturn> run(Params params) {
        final Observable<DataReturn> observable = this.buildUseCaseObservable(params)
                .subscribeOn(mWorkScheduler)
                .observeOn(mObserveScheduler);
        return observable;
    }

    protected abstract Observable<DataReturn> buildUseCaseObservable(final Params params);


}
