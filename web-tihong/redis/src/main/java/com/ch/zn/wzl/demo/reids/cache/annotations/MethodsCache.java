package com.ch.zn.wzl.demo.reids.cache.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface MethodsCache {

	String keyStrategy();

	String cacheStrategy();

	int cacheTime() default 0;

	String optoins() default "{}";
}
