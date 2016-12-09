package com.ch.zn.wzl.demo.reids.cache.strategy.impl;

import com.ch.zn.wzl.demo.reids.cache.strategy.abs.AbstractMapCacheStrategy;

public class DefaultAbstractMapCacheStrategy extends AbstractMapCacheStrategy {

	public static final String DefaultAbstractMapCacheStrategy = "DefaultAbstractMapCacheStrategy";

	@Override
	public String getStrategy() {
		return DefaultAbstractMapCacheStrategy;
	}


}
