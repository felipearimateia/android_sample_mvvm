package info.arimateia.androidmvm.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import info.arimateia.androidmvm.AppContext;
import info.arimateia.androidmvm.business.PeopleModel;
import info.arimateia.androidmvm.model.Person;


/**
 * Created by felipets on 8/22/16.
 */

public class PeopleViewModel extends BaseObservable {

    private static final String TAG = PeopleViewModel.class.getSimpleName();

    public final ObservableArrayList<PersonViewModel> people = new ObservableArrayList<>();

    @Inject
    PeopleModel peopleModel;


    public PeopleViewModel() {
        AppContext.component().inject(this);
    }

    private void addPerson(List<Person> people) {

        List<PersonViewModel> items = new ArrayList<>();

        for (Person person: people) {
            items.add(new PersonViewModel(person));
        }

        this.people.addAll(items);
    }

    public void fetchData() {

        peopleModel.getPeople()
                . subscribe(person -> addPerson(person),
                        error -> Log.d(TAG, error.getMessage(), error),
                        ()-> {

                        });
    }

}
