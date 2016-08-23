package info.arimateia.androidmvm.injection;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import info.arimateia.androidmvm.business.PeopleModel;

/**
 * Created by felipets on 8/23/16.
 */

@Module
public class BusinessModule {

    @Provides
    public PeopleModel providePeopleModel() {
        return new PeopleModel();
    }

}
