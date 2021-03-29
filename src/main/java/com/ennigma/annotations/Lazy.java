package com.ennigma.annotations;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target(value={TYPE,METHOD,CONSTRUCTOR,PARAMETER,FIELD})
@Retention(value=RUNTIME)
public @interface Lazy {

}
