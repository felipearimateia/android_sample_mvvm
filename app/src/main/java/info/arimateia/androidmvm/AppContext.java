package info.arimateia.androidmvm;


import info.arimateia.androidmvm.injection.AppComponent;

public class AppContext {

    private static AppComponent component;

    public static void setComponent(AppComponent comp){
        component = comp;
    }

    public static AppComponent component(){
        return component;
    }

}
