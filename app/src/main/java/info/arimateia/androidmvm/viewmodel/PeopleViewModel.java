package info.arimateia.androidmvm.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import info.arimateia.androidmvm.model.Person;
import info.arimateia.androidmvm.model.repository.PeopleRepository;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by felipets on 8/22/16.
 */

public class PeopleViewModel extends BaseObservable {

    @Bindable
    public ObservableArrayList<PersonViewModel> people;

    private PeopleRepository repository;
    private static final String TAG = PeopleViewModel.class.getSimpleName();

    public PeopleViewModel() {
        this.people = new ObservableArrayList<>();
        this.repository = new PeopleRepository();
    }

    private void addPerson(Person person) {
        this.people.add(new PersonViewModel(person));
    }

    public void loadPeople() {
        repository.getPeople()
                .observeOn(AndroidSchedulers.mainThread())
                . subscribe(person -> addPerson(person),
                        error -> Log.d(TAG, error.getMessage(), error),
                        ()-> {

                        });
    }

}
