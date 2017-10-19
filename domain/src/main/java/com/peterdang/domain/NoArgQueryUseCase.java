package com.peterdang.domain;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

/**
 * Created by phuoc on 2017-10-17.
 */

public abstract class NoArgQueryUseCase<R> {
    private final Scheduler mWorkScheduler;
    private final Scheduler mObserveScheduler;

    public NoArgQueryUseCase(Scheduler workScheduler, Scheduler observeScheduler) {
        this.mWorkScheduler = workScheduler;
        this.mObserveScheduler = observeScheduler;
    }

    public Observable<R> run() {
        final Observable<R> observable = this.buildUseCaseObservable()
                .subscribeOn(mWorkScheduler)
                .observeOn(mObserveScheduler);
        return observable;
    }

    protected abstract Observable<R> buildUseCaseObservable();

}

