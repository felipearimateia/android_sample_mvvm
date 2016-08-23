package info.arimateia.androidmvm.repository;


import javax.inject.Inject;

import info.arimateia.androidmvm.AppContext;
import info.arimateia.androidmvm.model.PeopleResults;
import info.arimateia.androidmvm.repository.remote.PeopleApi;
import rx.Observable;

/**
 * Created by felipets on 8/22/16.
 */

public class PeopleRepository {

    @Inject
    PeopleApi api;

    public PeopleRepository() {
        AppContext.component().inject(this);
    }

    public Observable<PeopleResults> getPeople() {
        return api.people();
    }
}
