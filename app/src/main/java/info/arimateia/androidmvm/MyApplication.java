package info.arimateia.androidmvm;

import android.app.Application;

import info.arimateia.androidmvm.injection.AppComponent;
import info.arimateia.androidmvm.injection.BusinessModule;
import info.arimateia.androidmvm.injection.DaggerAppComponent;
import info.arimateia.androidmvm.injection.RemoteModule;
import info.arimateia.androidmvm.injection.RepositoryModule;

/**
 * Created by felipets on 8/23/16.
 */

public class MyApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .businessModule(new BusinessModule())
                .remoteModule(new RemoteModule())
                .repositoryModule(new RepositoryModule())
                .build();

        AppContext.setComponent(appComponent);
        AppContext.component().inject(this);
    }
}
