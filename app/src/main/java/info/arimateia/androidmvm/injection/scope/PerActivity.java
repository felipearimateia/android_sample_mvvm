package info.arimateia.androidmvm.injection.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;


/**
 * Created by felipets on 8/25/16.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {}
