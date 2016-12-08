package com.ch.zn.wzl.demo.reids.operation.helper;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ch.zn.wzl.demo.reids.operation.target.ShardedRedisOperaction;

import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.Tuple;

@Component
public class ShardedProxyRedisCommand implements ProxyReidsCommand {

	@Autowired
	ShardedRedisOperaction shardedRedisOperaction;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#set(java.lang
	 * .Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public String set(Integer dbIndex, String key, String value) {
		return shardedRedisOperaction.set(null, dbIndex, key, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#set(java.lang
	 * .Integer, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, long)
	 */
	@Override
	public String set(Integer dbIndex, String key, String value, String nxxx, String expx, long time) {
		return shardedRedisOperaction.set(null, dbIndex, key, value, nxxx, expx, time);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#get(java.lang
	 * .Integer, java.lang.String)
	 */
	@Override
	public String get(Integer dbIndex, String key) {
		return shardedRedisOperaction.get(null, dbIndex, key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#exists(java.
	 * lang.Integer, java.lang.String)
	 */
	@Override
	public Boolean exists(Integer dbIndex, String key) {
		return shardedRedisOperaction.exists(null, dbIndex, key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#persist(java.
	 * lang.Integer, java.lang.String)
	 */
	@Override
	public Long persist(Integer dbIndex, String key) {
		return shardedRedisOperaction.persist(null, dbIndex, key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#type(java.
	 * lang.Integer, java.lang.String)
	 */
	@Override
	public String type(Integer dbIndex, String key) {
		return shardedRedisOperaction.type(null, dbIndex, key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#expire(java.
	 * lang.Integer, java.lang.String, int)
	 */
	@Override
	public Long expire(Integer dbIndex, String key, int seconds) {
		return shardedRedisOperaction.expire(null, dbIndex, key, seconds);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#hashCode()
	 */
	@Override
	public int hashCode() {
		return shardedRedisOperaction.hashCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#pexpire(java.
	 * lang.Integer, java.lang.String, long)
	 */
	@Override
	public Long pexpire(Integer dbIndex, String key, long milliseconds) {
		return shardedRedisOperaction.pexpire(null, dbIndex, key, milliseconds);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#expireAt(java
	 * .lang.Integer, java.lang.String, long)
	 */
	@Override
	public Long expireAt(Integer dbIndex, String key, long unixTime) {
		return shardedRedisOperaction.expireAt(null, dbIndex, key, unixTime);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#pexpireAt(
	 * java.lang.Integer, java.lang.String, long)
	 */
	@Override
	public Long pexpireAt(Integer dbIndex, String key, long millisecondsTimestamp) {
		return shardedRedisOperaction.pexpireAt(null, dbIndex, key, millisecondsTimestamp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#ttl(java.lang
	 * .Integer, java.lang.String)
	 */
	@Override
	public Long ttl(Integer dbIndex, String key) {
		return shardedRedisOperaction.ttl(null, dbIndex, key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#setbit(java.
	 * lang.Integer, java.lang.String, long, boolean)
	 */
	@Override
	public Boolean setbit(Integer dbIndex, String key, long offset, boolean value) {
		return shardedRedisOperaction.setbit(null, dbIndex, key, offset, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#setbit(java.
	 * lang.Integer, java.lang.String, long, java.lang.String)
	 */
	@Override
	public Boolean setbit(Integer dbIndex, String key, long offset, String value) {
		return shardedRedisOperaction.setbit(null, dbIndex, key, offset, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#getbit(java.
	 * lang.Integer, java.lang.String, long)
	 */
	@Override
	public Boolean getbit(Integer dbIndex, String key, long offset) {
		return shardedRedisOperaction.getbit(null, dbIndex, key, offset);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#setrange(java
	 * .lang.Integer, java.lang.String, long, java.lang.String)
	 */
	@Override
	public Long setrange(Integer dbIndex, String key, long offset, String value) {
		return shardedRedisOperaction.setrange(null, dbIndex, key, offset, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#getrange(java
	 * .lang.Integer, java.lang.String, long, long)
	 */
	@Override
	public String getrange(Integer dbIndex, String key, long startOffset, long endOffset) {
		return shardedRedisOperaction.getrange(null, dbIndex, key, startOffset, endOffset);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#getSet(java.
	 * lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public String getSet(Integer dbIndex, String key, String value) {
		return shardedRedisOperaction.getSet(null, dbIndex, key, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#setnx(java.
	 * lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public Long setnx(Integer dbIndex, String key, String value) {
		return shardedRedisOperaction.setnx(null, dbIndex, key, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#equals(java.
	 * lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return shardedRedisOperaction.equals(obj);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#setex(java.
	 * lang.Integer, java.lang.String, int, java.lang.String)
	 */
	@Override
	public String setex(Integer dbIndex, String key, int seconds, String value) {
		return shardedRedisOperaction.setex(null, dbIndex, key, seconds, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#decrBy(java.
	 * lang.Integer, java.lang.String, long)
	 */
	@Override
	public Long decrBy(Integer dbIndex, String key, long integer) {
		return shardedRedisOperaction.decrBy(null, dbIndex, key, integer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#decr(java.
	 * lang.Integer, java.lang.String)
	 */
	@Override
	public Long decr(Integer dbIndex, String key) {
		return shardedRedisOperaction.decr(null, dbIndex, key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#incrBy(java.
	 * lang.Integer, java.lang.String, long)
	 */
	@Override
	public Long incrBy(Integer dbIndex, String key, long integer) {
		return shardedRedisOperaction.incrBy(null, dbIndex, key, integer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#incrByFloat(
	 * java.lang.Integer, java.lang.String, double)
	 */
	@Override
	public Double incrByFloat(Integer dbIndex, String key, double value) {
		return shardedRedisOperaction.incrByFloat(null, dbIndex, key, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#incr(java.
	 * lang.Integer, java.lang.String)
	 */
	@Override
	public Long incr(Integer dbIndex, String key) {
		return shardedRedisOperaction.incr(null, dbIndex, key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#append(java.
	 * lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public Long append(Integer dbIndex, String key, String value) {
		return shardedRedisOperaction.append(null, dbIndex, key, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#substr(java.
	 * lang.Integer, java.lang.String, int, int)
	 */
	@Override
	public String substr(Integer dbIndex, String key, int start, int end) {
		return shardedRedisOperaction.substr(null, dbIndex, key, start, end);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#hset(java.
	 * lang.Integer, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Long hset(Integer dbIndex, String key, String field, String value) {
		return shardedRedisOperaction.hset(null, dbIndex, key, field, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#hget(java.
	 * lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public String hget(Integer dbIndex, String key, String field) {
		return shardedRedisOperaction.hget(null, dbIndex, key, field);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#hsetnx(java.
	 * lang.Integer, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Long hsetnx(Integer dbIndex, String key, String field, String value) {
		return shardedRedisOperaction.hsetnx(null, dbIndex, key, field, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#hmset(java.
	 * lang.Integer, java.lang.String, java.util.Map)
	 */
	@Override
	public String hmset(Integer dbIndex, String key, Map<String, String> hash) {
		return shardedRedisOperaction.hmset(null, dbIndex, key, hash);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#hmget(java.
	 * lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public List<String> hmget(Integer dbIndex, String key, String... fields) {
		return shardedRedisOperaction.hmget(null, dbIndex, key, fields);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#hincrBy(java.
	 * lang.Integer, java.lang.String, java.lang.String, long)
	 */
	@Override
	public Long hincrBy(Integer dbIndex, String key, String field, long value) {
		return shardedRedisOperaction.hincrBy(null, dbIndex, key, field, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#hexists(java.
	 * lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public Boolean hexists(Integer dbIndex, String key, String field) {
		return shardedRedisOperaction.hexists(null, dbIndex, key, field);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#hdel(java.
	 * lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public Long hdel(Integer dbIndex, String key, String... field) {
		return shardedRedisOperaction.hdel(null, dbIndex, key, field);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#hlen(java.
	 * lang.Integer, java.lang.String)
	 */
	@Override
	public Long hlen(Integer dbIndex, String key) {
		return shardedRedisOperaction.hlen(null, dbIndex, key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#hkeys(java.
	 * lang.Integer, java.lang.String)
	 */
	@Override
	public Set<String> hkeys(Integer dbIndex, String key) {
		return shardedRedisOperaction.hkeys(null, dbIndex, key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#hvals(java.
	 * lang.Integer, java.lang.String)
	 */
	@Override
	public List<String> hvals(Integer dbIndex, String key) {
		return shardedRedisOperaction.hvals(null, dbIndex, key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#hgetAll(java.
	 * lang.Integer, java.lang.String)
	 */
	@Override
	public Map<String, String> hgetAll(Integer dbIndex, String key) {
		return shardedRedisOperaction.hgetAll(null, dbIndex, key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#rpush(java.
	 * lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public Long rpush(Integer dbIndex, String key, String... string) {
		return shardedRedisOperaction.rpush(null, dbIndex, key, string);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#lpush(java.
	 * lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public Long lpush(Integer dbIndex, String key, String... string) {
		return shardedRedisOperaction.lpush(null, dbIndex, key, string);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#llen(java.
	 * lang.Integer, java.lang.String)
	 */
	@Override
	public Long llen(Integer dbIndex, String key) {
		return shardedRedisOperaction.llen(null, dbIndex, key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#lrange(java.
	 * lang.Integer, java.lang.String, long, long)
	 */
	@Override
	public List<String> lrange(Integer dbIndex, String key, long start, long end) {
		return shardedRedisOperaction.lrange(null, dbIndex, key, start, end);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#ltrim(java.
	 * lang.Integer, java.lang.String, long, long)
	 */
	@Override
	public String ltrim(Integer dbIndex, String key, long start, long end) {
		return shardedRedisOperaction.ltrim(null, dbIndex, key, start, end);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#lindex(java.
	 * lang.Integer, java.lang.String, long)
	 */
	@Override
	public String lindex(Integer dbIndex, String key, long index) {
		return shardedRedisOperaction.lindex(null, dbIndex, key, index);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#lset(java.
	 * lang.Integer, java.lang.String, long, java.lang.String)
	 */
	@Override
	public String lset(Integer dbIndex, String key, long index, String value) {
		return shardedRedisOperaction.lset(null, dbIndex, key, index, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#lrem(java.
	 * lang.Integer, java.lang.String, long, java.lang.String)
	 */
	@Override
	public Long lrem(Integer dbIndex, String key, long count, String value) {
		return shardedRedisOperaction.lrem(null, dbIndex, key, count, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#lpop(java.
	 * lang.Integer, java.lang.String)
	 */
	@Override
	public String lpop(Integer dbIndex, String key) {
		return shardedRedisOperaction.lpop(null, dbIndex, key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#rpop(java.
	 * lang.Integer, java.lang.String)
	 */
	@Override
	public String rpop(Integer dbIndex, String key) {
		return shardedRedisOperaction.rpop(null, dbIndex, key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#sadd(java.
	 * lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public Long sadd(Integer dbIndex, String key, String... member) {
		return shardedRedisOperaction.sadd(null, dbIndex, key, member);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#smembers(java
	 * .lang.Integer, java.lang.String)
	 */
	@Override
	public Set<String> smembers(Integer dbIndex, String key) {
		return shardedRedisOperaction.smembers(null, dbIndex, key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#srem(java.
	 * lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public Long srem(Integer dbIndex, String key, String... member) {
		return shardedRedisOperaction.srem(null, dbIndex, key, member);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#spop(java.
	 * lang.Integer, java.lang.String)
	 */
	@Override
	public String spop(Integer dbIndex, String key) {
		return shardedRedisOperaction.spop(null, dbIndex, key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#spop(java.
	 * lang.Integer, java.lang.String, long)
	 */
	@Override
	public Set<String> spop(Integer dbIndex, String key, long count) {
		return shardedRedisOperaction.spop(null, dbIndex, key, count);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#toString()
	 */
	@Override
	public String toString() {
		return shardedRedisOperaction.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#scard(java.
	 * lang.Integer, java.lang.String)
	 */
	@Override
	public Long scard(Integer dbIndex, String key) {
		return shardedRedisOperaction.scard(null, dbIndex, key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#sismember(
	 * java.lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public Boolean sismember(Integer dbIndex, String key, String member) {
		return shardedRedisOperaction.sismember(null, dbIndex, key, member);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#srandmember(
	 * java.lang.Integer, java.lang.String)
	 */
	@Override
	public String srandmember(Integer dbIndex, String key) {
		return shardedRedisOperaction.srandmember(null, dbIndex, key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#srandmember(
	 * java.lang.Integer, java.lang.String, int)
	 */
	@Override
	public List<String> srandmember(Integer dbIndex, String key, int count) {
		return shardedRedisOperaction.srandmember(null, dbIndex, key, count);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#strlen(java.
	 * lang.Integer, java.lang.String)
	 */
	@Override
	public Long strlen(Integer dbIndex, String key) {
		return shardedRedisOperaction.strlen(null, dbIndex, key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#zadd(java.
	 * lang.Integer, java.lang.String, double, java.lang.String)
	 */
	@Override
	public Long zadd(Integer dbIndex, String key, double score, String member) {
		return shardedRedisOperaction.zadd(null, dbIndex, key, score, member);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#zadd(java.
	 * lang.Integer, java.lang.String, java.util.Map)
	 */
	@Override
	public Long zadd(Integer dbIndex, String key, Map<String, Double> scoreMembers) {
		return shardedRedisOperaction.zadd(null, dbIndex, key, scoreMembers);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#zrange(java.
	 * lang.Integer, java.lang.String, long, long)
	 */
	@Override
	public Set<String> zrange(Integer dbIndex, String key, long start, long end) {
		return shardedRedisOperaction.zrange(null, dbIndex, key, start, end);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#zrem(java.
	 * lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public Long zrem(Integer dbIndex, String key, String... member) {
		return shardedRedisOperaction.zrem(null, dbIndex, key, member);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#zincrby(java.
	 * lang.Integer, java.lang.String, double, java.lang.String)
	 */
	@Override
	public Double zincrby(Integer dbIndex, String key, double score, String member) {
		return shardedRedisOperaction.zincrby(null, dbIndex, key, score, member);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#zrank(java.
	 * lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public Long zrank(Integer dbIndex, String key, String member) {
		return shardedRedisOperaction.zrank(null, dbIndex, key, member);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#zrevrank(java
	 * .lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public Long zrevrank(Integer dbIndex, String key, String member) {
		return shardedRedisOperaction.zrevrank(null, dbIndex, key, member);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#zrevrange(
	 * java.lang.Integer, java.lang.String, long, long)
	 */
	@Override
	public Set<String> zrevrange(Integer dbIndex, String key, long start, long end) {
		return shardedRedisOperaction.zrevrange(null, dbIndex, key, start, end);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#
	 * zrangeWithScores(java.lang.Integer, java.lang.String, long, long)
	 */
	@Override
	public Set<Tuple> zrangeWithScores(Integer dbIndex, String key, long start, long end) {
		return shardedRedisOperaction.zrangeWithScores(null, dbIndex, key, start, end);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#
	 * zrevrangeWithScores(java.lang.Integer, java.lang.String, long, long)
	 */
	@Override
	public Set<Tuple> zrevrangeWithScores(Integer dbIndex, String key, long start, long end) {
		return shardedRedisOperaction.zrevrangeWithScores(null, dbIndex, key, start, end);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#zcard(java.
	 * lang.Integer, java.lang.String)
	 */
	@Override
	public Long zcard(Integer dbIndex, String key) {
		return shardedRedisOperaction.zcard(null, dbIndex, key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#zscore(java.
	 * lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public Double zscore(Integer dbIndex, String key, String member) {
		return shardedRedisOperaction.zscore(null, dbIndex, key, member);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#sort(java.
	 * lang.Integer, java.lang.String)
	 */
	@Override
	public List<String> sort(Integer dbIndex, String key) {
		return shardedRedisOperaction.sort(null, dbIndex, key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#sort(java.
	 * lang.Integer, java.lang.String, redis.clients.jedis.SortingParams)
	 */
	@Override
	public List<String> sort(Integer dbIndex, String key, SortingParams sortingParameters) {
		return shardedRedisOperaction.sort(null, dbIndex, key, sortingParameters);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#zcount(java.
	 * lang.Integer, java.lang.String, double, double)
	 */
	@Override
	public Long zcount(Integer dbIndex, String key, double min, double max) {
		return shardedRedisOperaction.zcount(null, dbIndex, key, min, max);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#zcount(java.
	 * lang.Integer, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Long zcount(Integer dbIndex, String key, String min, String max) {
		return shardedRedisOperaction.zcount(null, dbIndex, key, min, max);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#zrangeByScore
	 * (java.lang.Integer, java.lang.String, double, double)
	 */
	@Override
	public Set<String> zrangeByScore(Integer dbIndex, String key, double min, double max) {
		return shardedRedisOperaction.zrangeByScore(null, dbIndex, key, min, max);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#zrangeByScore
	 * (java.lang.Integer, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Set<String> zrangeByScore(Integer dbIndex, String key, String min, String max) {
		return shardedRedisOperaction.zrangeByScore(null, dbIndex, key, min, max);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#
	 * zrevrangeByScore(java.lang.Integer, java.lang.String, double, double)
	 */
	@Override
	public Set<String> zrevrangeByScore(Integer dbIndex, String key, double max, double min) {
		return shardedRedisOperaction.zrevrangeByScore(null, dbIndex, key, max, min);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#zrangeByScore
	 * (java.lang.Integer, java.lang.String, double, double, int, int)
	 */
	@Override
	public Set<String> zrangeByScore(Integer dbIndex, String key, double min, double max, int offset, int count) {
		return shardedRedisOperaction.zrangeByScore(null, dbIndex, key, min, max, offset, count);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#
	 * zrevrangeByScore(java.lang.Integer, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Set<String> zrevrangeByScore(Integer dbIndex, String key, String max, String min) {
		return shardedRedisOperaction.zrevrangeByScore(null, dbIndex, key, max, min);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#zrangeByScore
	 * (java.lang.Integer, java.lang.String, java.lang.String, java.lang.String,
	 * int, int)
	 */
	@Override
	public Set<String> zrangeByScore(Integer dbIndex, String key, String min, String max, int offset, int count) {
		return shardedRedisOperaction.zrangeByScore(null, dbIndex, key, min, max, offset, count);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#
	 * zrevrangeByScore(java.lang.Integer, java.lang.String, double, double,
	 * int, int)
	 */
	@Override
	public Set<String> zrevrangeByScore(Integer dbIndex, String key, double max, double min, int offset, int count) {
		return shardedRedisOperaction.zrevrangeByScore(null, dbIndex, key, max, min, offset, count);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#
	 * zrangeByScoreWithScores(java.lang.Integer, java.lang.String, double,
	 * double)
	 */
	@Override
	public Set<Tuple> zrangeByScoreWithScores(Integer dbIndex, String key, double min, double max) {
		return shardedRedisOperaction.zrangeByScoreWithScores(null, dbIndex, key, min, max);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#
	 * zrevrangeByScoreWithScores(java.lang.Integer, java.lang.String, double,
	 * double)
	 */
	@Override
	public Set<Tuple> zrevrangeByScoreWithScores(Integer dbIndex, String key, double max, double min) {
		return shardedRedisOperaction.zrevrangeByScoreWithScores(null, dbIndex, key, max, min);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#
	 * zrangeByScoreWithScores(java.lang.Integer, java.lang.String, double,
	 * double, int, int)
	 */
	@Override
	public Set<Tuple> zrangeByScoreWithScores(Integer dbIndex, String key, double min, double max, int offset,
			int count) {
		return shardedRedisOperaction.zrangeByScoreWithScores(null, dbIndex, key, min, max, offset, count);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#
	 * zrevrangeByScore(java.lang.Integer, java.lang.String, java.lang.String,
	 * java.lang.String, int, int)
	 */
	@Override
	public Set<String> zrevrangeByScore(Integer dbIndex, String key, String max, String min, int offset, int count) {
		return shardedRedisOperaction.zrevrangeByScore(null, dbIndex, key, max, min, offset, count);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#
	 * zrangeByScoreWithScores(java.lang.Integer, java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public Set<Tuple> zrangeByScoreWithScores(Integer dbIndex, String key, String min, String max) {
		return shardedRedisOperaction.zrangeByScoreWithScores(null, dbIndex, key, min, max);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#
	 * zrevrangeByScoreWithScores(java.lang.Integer, java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public Set<Tuple> zrevrangeByScoreWithScores(Integer dbIndex, String key, String max, String min) {
		return shardedRedisOperaction.zrevrangeByScoreWithScores(null, dbIndex, key, max, min);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#
	 * zrangeByScoreWithScores(java.lang.Integer, java.lang.String,
	 * java.lang.String, java.lang.String, int, int)
	 */
	@Override
	public Set<Tuple> zrangeByScoreWithScores(Integer dbIndex, String key, String min, String max, int offset,
			int count) {
		return shardedRedisOperaction.zrangeByScoreWithScores(null, dbIndex, key, min, max, offset, count);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#
	 * zrevrangeByScoreWithScores(java.lang.Integer, java.lang.String, double,
	 * double, int, int)
	 */
	@Override
	public Set<Tuple> zrevrangeByScoreWithScores(Integer dbIndex, String key, double max, double min, int offset,
			int count) {
		return shardedRedisOperaction.zrevrangeByScoreWithScores(null, dbIndex, key, max, min, offset, count);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#
	 * zrevrangeByScoreWithScores(java.lang.Integer, java.lang.String,
	 * java.lang.String, java.lang.String, int, int)
	 */
	@Override
	public Set<Tuple> zrevrangeByScoreWithScores(Integer dbIndex, String key, String max, String min, int offset,
			int count) {
		return shardedRedisOperaction.zrevrangeByScoreWithScores(null, dbIndex, key, max, min, offset, count);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#
	 * zremrangeByRank(java.lang.Integer, java.lang.String, long, long)
	 */
	@Override
	public Long zremrangeByRank(Integer dbIndex, String key, long start, long end) {
		return shardedRedisOperaction.zremrangeByRank(null, dbIndex, key, start, end);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#
	 * zremrangeByScore(java.lang.Integer, java.lang.String, double, double)
	 */
	@Override
	public Long zremrangeByScore(Integer dbIndex, String key, double start, double end) {
		return shardedRedisOperaction.zremrangeByScore(null, dbIndex, key, start, end);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#
	 * zremrangeByScore(java.lang.Integer, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Long zremrangeByScore(Integer dbIndex, String key, String start, String end) {
		return shardedRedisOperaction.zremrangeByScore(null, dbIndex, key, start, end);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#zlexcount(
	 * java.lang.Integer, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Long zlexcount(Integer dbIndex, String key, String min, String max) {
		return shardedRedisOperaction.zlexcount(null, dbIndex, key, min, max);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#zrangeByLex(
	 * java.lang.Integer, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Set<String> zrangeByLex(Integer dbIndex, String key, String min, String max) {
		return shardedRedisOperaction.zrangeByLex(null, dbIndex, key, min, max);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#zrangeByLex(
	 * java.lang.Integer, java.lang.String, java.lang.String, java.lang.String,
	 * int, int)
	 */
	@Override
	public Set<String> zrangeByLex(Integer dbIndex, String key, String min, String max, int offset, int count) {
		return shardedRedisOperaction.zrangeByLex(null, dbIndex, key, min, max, offset, count);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#
	 * zrevrangeByLex(java.lang.Integer, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Set<String> zrevrangeByLex(Integer dbIndex, String key, String max, String min) {
		return shardedRedisOperaction.zrevrangeByLex(null, dbIndex, key, max, min);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#
	 * zrevrangeByLex(java.lang.Integer, java.lang.String, java.lang.String,
	 * java.lang.String, int, int)
	 */
	@Override
	public Set<String> zrevrangeByLex(Integer dbIndex, String key, String max, String min, int offset, int count) {
		return shardedRedisOperaction.zrevrangeByLex(null, dbIndex, key, max, min, offset, count);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#
	 * zremrangeByLex(java.lang.Integer, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Long zremrangeByLex(Integer dbIndex, String key, String min, String max) {
		return shardedRedisOperaction.zremrangeByLex(null, dbIndex, key, min, max);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#linsert(java.
	 * lang.Integer, java.lang.String,
	 * redis.clients.jedis.BinaryClient.LIST_POSITION, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Long linsert(Integer dbIndex, String key, LIST_POSITION where, String pivot, String value) {
		return shardedRedisOperaction.linsert(null, dbIndex, key, where, pivot, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#lpushx(java.
	 * lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public Long lpushx(Integer dbIndex, String key, String... string) {
		return shardedRedisOperaction.lpushx(null, dbIndex, key, string);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#rpushx(java.
	 * lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public Long rpushx(Integer dbIndex, String key, String... string) {
		return shardedRedisOperaction.rpushx(null, dbIndex, key, string);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#blpop(java.
	 * lang.Integer, java.lang.String)
	 */
	@Override
	public List<String> blpop(Integer dbIndex, String arg) {
		return shardedRedisOperaction.blpop(null, dbIndex, arg);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#blpop(java.
	 * lang.Integer, int, java.lang.String)
	 */
	@Override
	public List<String> blpop(Integer dbIndex, int timeout, String key) {
		return shardedRedisOperaction.blpop(null, dbIndex, timeout, key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#brpop(java.
	 * lang.Integer, java.lang.String)
	 */
	@Override
	public List<String> brpop(Integer dbIndex, String arg) {
		return shardedRedisOperaction.brpop(null, dbIndex, arg);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#brpop(java.
	 * lang.Integer, int, java.lang.String)
	 */
	@Override
	public List<String> brpop(Integer dbIndex, int timeout, String key) {
		return shardedRedisOperaction.brpop(null, dbIndex, timeout, key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#del(java.lang
	 * .Integer, java.lang.String)
	 */
	@Override
	public Long del(Integer dbIndex, String key) {
		return shardedRedisOperaction.del(null, dbIndex, key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#echo(java.
	 * lang.Integer, java.lang.String)
	 */
	@Override
	public String echo(Integer dbIndex, String string) {
		return shardedRedisOperaction.echo(null, dbIndex, string);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#move(java.
	 * lang.Integer, java.lang.String, int)
	 */
	@Override
	public Long move(Integer dbIndex, String key, int targetIndex) {
		return shardedRedisOperaction.move(null, dbIndex, key, targetIndex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#bitcount(java
	 * .lang.Integer, java.lang.String)
	 */
	@Override
	public Long bitcount(Integer dbIndex, String key) {
		return shardedRedisOperaction.bitcount(null, dbIndex, key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#bitcount(java
	 * .lang.Integer, java.lang.String, long, long)
	 */
	@Override
	public Long bitcount(Integer dbIndex, String key, long start, long end) {
		return shardedRedisOperaction.bitcount(null, dbIndex, key, start, end);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#hscan(java.
	 * lang.Integer, java.lang.String, int)
	 */
	@Override
	public ScanResult<Entry<String, String>> hscan(Integer dbIndex, String key, int cursor) {
		return shardedRedisOperaction.hscan(null, dbIndex, key, cursor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#sscan(java.
	 * lang.Integer, java.lang.String, int)
	 */
	@Override
	public ScanResult<String> sscan(Integer dbIndex, String key, int cursor) {
		return shardedRedisOperaction.sscan(null, dbIndex, key, cursor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#zscan(java.
	 * lang.Integer, java.lang.String, int)
	 */
	@Override
	public ScanResult<Tuple> zscan(Integer dbIndex, String key, int cursor) {
		return shardedRedisOperaction.zscan(null, dbIndex, key, cursor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#hscan(java.
	 * lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public ScanResult<Entry<String, String>> hscan(Integer dbIndex, String key, String cursor) {
		return shardedRedisOperaction.hscan(null, dbIndex, key, cursor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#sscan(java.
	 * lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public ScanResult<String> sscan(Integer dbIndex, String key, String cursor) {
		return shardedRedisOperaction.sscan(null, dbIndex, key, cursor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#zscan(java.
	 * lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public ScanResult<Tuple> zscan(Integer dbIndex, String key, String cursor) {
		return shardedRedisOperaction.zscan(null, dbIndex, key, cursor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#pfadd(java.
	 * lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public Long pfadd(Integer dbIndex, String key, String... elements) {
		return shardedRedisOperaction.pfadd(null, dbIndex, key, elements);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ch.zn.wzl.demo.reids.operation.helper.ProxyReidsCommand#pfcount(java.
	 * lang.Integer, java.lang.String)
	 */
	@Override
	public long pfcount(Integer dbIndex, String key) {
		return shardedRedisOperaction.pfcount(null, dbIndex, key);
	}

}
