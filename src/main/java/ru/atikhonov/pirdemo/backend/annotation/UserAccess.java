package ru.atikhonov.pirdemo.backend.annotation;

import ru.atikhonov.pirdemo.backend.access.ResourceId;
import ru.atikhonov.pirdemo.backend.access.ActionId;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface UserAccess {
        ActionId action();
        ResourceId resource();
}
