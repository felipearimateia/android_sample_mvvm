package info.arimateia.androidmvm.injection;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import info.arimateia.androidmvm.repository.PeopleRepository;
import info.arimateia.androidmvm.repository.remote.PeopleApi;

/**
 * Created by felipets on 8/23/16.
 */

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    public PeopleRepository providerPeopleRepository(PeopleApi api) {
        return new PeopleRepository(api);
    }
}
