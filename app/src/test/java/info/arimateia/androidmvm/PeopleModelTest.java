package info.arimateia.androidmvm;

import com.google.common.collect.Lists;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import info.arimateia.androidmvm.business.PeopleModel;
import info.arimateia.androidmvm.model.Person;
import info.arimateia.androidmvm.repository.PeopleRepository;
import info.arimateia.androidmvm.repository.remote.PeopleApi;
import info.arimateia.androidmvm.repository.remote.SwapiService;
import rx.Observable;
import rx.observers.TestSubscriber;

import static org.junit.Assert.*;

/**
 * Created by felipearimateia on 8/25/16.
 */

public class PeopleModelTest {

    @Test
    public void getPeople() throws Exception {

        PeopleApi api = SwapiService.createService(PeopleApi.class);
        PeopleModel model = new PeopleModel(new PeopleRepository(api));

        TestSubscriber<Integer> testSubscriber = new TestSubscriber<>();

        model.getPeople()
                .map(people -> people.size())
                .toBlocking()
                .subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        testSubscriber.assertValue(10);
    }

    @Test
    public void getLuke() throws Exception {

        PeopleApi api = new SwapiService().createService(PeopleApi.class);
        PeopleModel model = new PeopleModel(new PeopleRepository(api));

        Person person = new Person();
        person.setUrl("http://swapi.co/api/people/1/");

        TestSubscriber<Person> testSubscriber = new TestSubscriber<>();
        model.getPerson("http://swapi.co/api/people/1/")
                .toBlocking()
                .subscribe(testSubscriber);

        testSubscriber.assertValue(person);
        testSubscriber.assertNoErrors();
    }
}
