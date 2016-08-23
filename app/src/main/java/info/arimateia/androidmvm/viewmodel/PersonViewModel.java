package info.arimateia.androidmvm.viewmodel;

import android.databinding.BaseObservable;

import info.arimateia.androidmvm.model.Person;

/**
 * Created by felipets on 8/22/16.
 */

public class PersonViewModel extends BaseObservable {

    private final Person person;

    public PersonViewModel(Person person) {
        this.person = person;
    }

    public String getName() {
        return person.getName();
    }

    public String getGender() {
        return person.getGender();
    }
}
