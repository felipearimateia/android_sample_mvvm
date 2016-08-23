package info.arimateia.androidmvm.injection;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import info.arimateia.androidmvm.business.PeopleModel;
import info.arimateia.androidmvm.repository.PeopleRepository;
import info.arimateia.androidmvm.viewmodel.PeopleViewModel;

/**
 * Created by felipets on 8/23/16.
 */

@Singleton
@Component(modules = {AppModule.class, BusinessModule.class,
        RemoteModule.class, RepositoryModule.class})
public interface AppComponent {

    //Application
    void inject(Application application);

    //ViewModel
    void inject(PeopleViewModel peopleViewModel);

    //Repository
    void inject(PeopleRepository peopleRepository);

    //Business
    void inject(PeopleModel peopleModel);
}
