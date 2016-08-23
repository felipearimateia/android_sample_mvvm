package info.arimateia.androidmvm.model.repository.remote;

import com.google.gson.JsonObject;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by felipets on 8/22/16.
 */

public interface PeopleApi {

    @GET("people")
    Observable<JsonObject> people();
}
