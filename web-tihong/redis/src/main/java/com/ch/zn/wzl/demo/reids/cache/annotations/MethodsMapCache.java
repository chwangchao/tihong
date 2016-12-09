package com.ch.zn.wzl.demo.reids.cache.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.ch.zn.wzl.demo.reids.cache.strategy.impl.DefaulCacheStrategy;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface MethodsMapCache {

	/**
	 * 根节点 默认没有
	 */
	String key() default "";

	/**
	 * 有效参数 默认全部
	 */
	String[] targetArgs() default {};

	/**
	 * 缓存策略 默认的缓存策略
	 */
	String cacheStrategy() default DefaulCacheStrategy.DefaulCacheStrategy;

	/**
	 * 缓存时间 根据不同的策略可以设置自己的默认时间
	 */
	int cacheTime() default 0;

	/***
	 * 缓存库 默认 0
	 */
	int cacheDb() default 0;

	/**
	 * 返回值解析的类型 暂时只有list有效,如果扩展,可以选填optoins 字段
	 */
	Class<?> rsClass() default String.class;

	/**
	 * 额外扩展参数
	 */
	String optoins() default "{}";
}
