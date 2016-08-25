package info.arimateia.androidmvm.repository.remote;

import info.arimateia.androidmvm.model.PeopleResults;
import info.arimateia.androidmvm.model.Person;
import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by felipets on 8/22/16.
 */

public interface PeopleApi {

    @GET("people")
    Observable<PeopleResults> people();

    @GET
    Observable<Person> getPerson(@Url String url);
}
