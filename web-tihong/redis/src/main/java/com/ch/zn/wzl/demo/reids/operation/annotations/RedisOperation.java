package com.ch.zn.wzl.demo.reids.operation.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface RedisOperation {
	int ShardedJedisIndex() default 0;

	int dbIndexIndex() default 1;
}
