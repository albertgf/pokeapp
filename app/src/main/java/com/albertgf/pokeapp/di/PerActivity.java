package com.albertgf.pokeapp.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by albertgf on 4/11/17.
 */


@Scope
@Retention (RUNTIME)
public @interface PerActivity {}
