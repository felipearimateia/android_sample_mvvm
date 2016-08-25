package info.arimateia.androidmvm.repository;


import javax.inject.Inject;

import info.arimateia.androidmvm.model.PeopleResults;
import info.arimateia.androidmvm.model.Person;
import info.arimateia.androidmvm.repository.remote.PeopleApi;
import rx.Observable;

/**
 * Created by felipets on 8/22/16.
 */

public class PeopleRepository {

    PeopleApi api;

    @Inject
    public PeopleRepository(PeopleApi api) {
        this.api = api;
    }

    public Observable<PeopleResults> getPeople() {
        return api.people();
    }

    public Observable<Person> getPerson(String url) {
        return api.getPerson(url);
    }
}
