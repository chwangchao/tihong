package com.ch.zn.wzl.demo.reids.cache.strategy.impl;

import com.ch.zn.wzl.demo.reids.cache.strategy.abs.AbstractMapCacheStrategy;

public class DefaulCacheStrategy extends AbstractMapCacheStrategy {

	public static final String DefaulCacheStrategy = "DefaulCacheStrategy";

	@Override
	public String getStrategy() {
		return DefaulCacheStrategy;
	}

}
