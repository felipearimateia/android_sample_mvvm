package info.arimateia.androidmvm.business;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import info.arimateia.androidmvm.model.Person;
import info.arimateia.androidmvm.repository.PeopleRepository;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by felipets on 8/23/16.
 */

public class PeopleModel {

    PeopleRepository repository;

    @Inject
    public PeopleModel(PeopleRepository repository) {
        this.repository = repository;
    }

    public Observable<List<Person>> getPeople() {
        return repository.getPeople()
                .subscribeOn(Schedulers.io())
                .map(peopleResults -> peopleResults.getResults());
    }

    public Observable<Person> getPerson(@NonNull String url) {
        return repository.getPerson(url)
                .subscribeOn(Schedulers.io());
    }
}
