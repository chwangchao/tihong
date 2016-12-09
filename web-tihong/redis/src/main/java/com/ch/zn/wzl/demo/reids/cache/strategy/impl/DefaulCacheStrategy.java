package com.ch.zn.wzl.demo.reids.cache.strategy.impl;

import com.ch.zn.wzl.demo.reids.cache.strategy.abs.AbstractDefaultCacheStrategy;

public class DefaulCacheStrategy extends AbstractDefaultCacheStrategy {

	public static final String DefaulCacheStrategy = "DefaulCacheStrategy";

	@Override
	public String getStrategy() {
		return DefaulCacheStrategy;
	}

}
