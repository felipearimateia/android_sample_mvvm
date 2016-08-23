package info.arimateia.androidmvm.model.repository;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import info.arimateia.androidmvm.model.Person;
import info.arimateia.androidmvm.model.repository.remote.PeopleApi;
import info.arimateia.androidmvm.model.repository.remote.SwapiService;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by felipets on 8/22/16.
 */

public class PeopleRepository {

    private final PeopleApi api;

    public PeopleRepository() {
         api = SwapiService.createService(PeopleApi.class);
    }

    public Observable<Person> getPeople() {
        return api.people()
                .subscribeOn(Schedulers.io())
                .map(jsonObject ->parseResults(jsonObject))
                .flatMap(people -> Observable.from(people));
    }

    private List<Person> parseResults(JsonObject jsonObject) {

        JsonArray array = jsonObject.getAsJsonArray("results");
        Gson gson = new Gson();
        List<Person> people = gson.fromJson(array,
                new TypeToken<List<Person>>(){}.getType());
        return people;
    }
}
