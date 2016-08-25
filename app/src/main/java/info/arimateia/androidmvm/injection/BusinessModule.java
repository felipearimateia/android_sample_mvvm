package info.arimateia.androidmvm.injection;

import dagger.Module;
import dagger.Provides;
import info.arimateia.androidmvm.business.PeopleModel;
import info.arimateia.androidmvm.repository.PeopleRepository;

/**
 * Created by felipets on 8/23/16.
 */

@Module
public class BusinessModule {

    @Provides
    public PeopleModel providePeopleModel(PeopleRepository repository) {
        return new PeopleModel(repository);
    }

}
