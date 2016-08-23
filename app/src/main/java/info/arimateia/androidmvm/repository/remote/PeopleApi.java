package info.arimateia.androidmvm.repository.remote;

import com.google.gson.JsonObject;

import info.arimateia.androidmvm.model.PeopleResults;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by felipets on 8/22/16.
 */

public interface PeopleApi {

    @GET("people")
    Observable<PeopleResults> people();
}
