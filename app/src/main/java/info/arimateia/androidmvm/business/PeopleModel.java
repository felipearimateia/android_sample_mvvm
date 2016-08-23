package info.arimateia.androidmvm.business;

import java.util.List;

import javax.inject.Inject;

import info.arimateia.androidmvm.AppContext;
import info.arimateia.androidmvm.model.Person;
import info.arimateia.androidmvm.repository.PeopleRepository;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by felipets on 8/23/16.
 */

public class PeopleModel {

    @Inject
    PeopleRepository repository;

    public PeopleModel() {
        AppContext.component().inject(this);
    }

    public Observable<List<Person>> getPeople() {
        return repository.getPeople()
                .subscribeOn(Schedulers.io())
                .map(peopleResults -> peopleResults.getResults());
    }
}
