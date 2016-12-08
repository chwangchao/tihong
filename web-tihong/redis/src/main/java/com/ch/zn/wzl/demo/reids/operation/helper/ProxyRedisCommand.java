package com.ch.zn.wzl.demo.reids.operation.helper;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import redis.clients.jedis.ScanResult;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.Tuple;
import redis.clients.jedis.BinaryClient.LIST_POSITION;

public interface ProxyRedisCommand {

	String set(Integer dbIndex, String key, String value);

	String set(Integer dbIndex, String key, String value, String nxxx, String expx, long time);

	String get(Integer dbIndex, String key);

	Boolean exists(Integer dbIndex, String key);

	Long persist(Integer dbIndex, String key);

	String type(Integer dbIndex, String key);

	Long expire(Integer dbIndex, String key, int seconds);

	int hashCode();

	Long pexpire(Integer dbIndex, String key, long milliseconds);

	Long expireAt(Integer dbIndex, String key, long unixTime);

	Long pexpireAt(Integer dbIndex, String key, long millisecondsTimestamp);

	Long ttl(Integer dbIndex, String key);

	Boolean setbit(Integer dbIndex, String key, long offset, boolean value);

	Boolean setbit(Integer dbIndex, String key, long offset, String value);

	Boolean getbit(Integer dbIndex, String key, long offset);

	Long setrange(Integer dbIndex, String key, long offset, String value);

	String getrange(Integer dbIndex, String key, long startOffset, long endOffset);

	String getSet(Integer dbIndex, String key, String value);

	Long setnx(Integer dbIndex, String key, String value);

	boolean equals(Object obj);

	String setex(Integer dbIndex, String key, int seconds, String value);

	Long decrBy(Integer dbIndex, String key, long integer);

	Long decr(Integer dbIndex, String key);

	Long incrBy(Integer dbIndex, String key, long integer);

	Double incrByFloat(Integer dbIndex, String key, double value);

	Long incr(Integer dbIndex, String key);

	Long append(Integer dbIndex, String key, String value);

	String substr(Integer dbIndex, String key, int start, int end);

	Long hset(Integer dbIndex, String key, String field, String value);

	String hget(Integer dbIndex, String key, String field);

	Long hsetnx(Integer dbIndex, String key, String field, String value);

	String hmset(Integer dbIndex, String key, Map<String, String> hash);

	List<String> hmget(Integer dbIndex, String key, String... fields);

	Long hincrBy(Integer dbIndex, String key, String field, long value);

	Boolean hexists(Integer dbIndex, String key, String field);

	Long hdel(Integer dbIndex, String key, String... field);

	Long hlen(Integer dbIndex, String key);

	Set<String> hkeys(Integer dbIndex, String key);

	List<String> hvals(Integer dbIndex, String key);

	Map<String, String> hgetAll(Integer dbIndex, String key);

	Long rpush(Integer dbIndex, String key, String... string);

	Long lpush(Integer dbIndex, String key, String... string);

	Long llen(Integer dbIndex, String key);

	List<String> lrange(Integer dbIndex, String key, long start, long end);

	String ltrim(Integer dbIndex, String key, long start, long end);

	String lindex(Integer dbIndex, String key, long index);

	String lset(Integer dbIndex, String key, long index, String value);

	Long lrem(Integer dbIndex, String key, long count, String value);

	String lpop(Integer dbIndex, String key);

	String rpop(Integer dbIndex, String key);

	Long sadd(Integer dbIndex, String key, String... member);

	Set<String> smembers(Integer dbIndex, String key);

	Long srem(Integer dbIndex, String key, String... member);

	String spop(Integer dbIndex, String key);

	Set<String> spop(Integer dbIndex, String key, long count);

	String toString();

	Long scard(Integer dbIndex, String key);

	Boolean sismember(Integer dbIndex, String key, String member);

	String srandmember(Integer dbIndex, String key);

	List<String> srandmember(Integer dbIndex, String key, int count);

	Long strlen(Integer dbIndex, String key);

	Long zadd(Integer dbIndex, String key, double score, String member);

	Long zadd(Integer dbIndex, String key, Map<String, Double> scoreMembers);

	Set<String> zrange(Integer dbIndex, String key, long start, long end);

	Long zrem(Integer dbIndex, String key, String... member);

	Double zincrby(Integer dbIndex, String key, double score, String member);

	Long zrank(Integer dbIndex, String key, String member);

	Long zrevrank(Integer dbIndex, String key, String member);

	Set<String> zrevrange(Integer dbIndex, String key, long start, long end);

	Set<Tuple> zrangeWithScores(Integer dbIndex, String key, long start, long end);

	Set<Tuple> zrevrangeWithScores(Integer dbIndex, String key, long start, long end);

	Long zcard(Integer dbIndex, String key);

	Double zscore(Integer dbIndex, String key, String member);

	List<String> sort(Integer dbIndex, String key);

	List<String> sort(Integer dbIndex, String key, SortingParams sortingParameters);

	Long zcount(Integer dbIndex, String key, double min, double max);

	Long zcount(Integer dbIndex, String key, String min, String max);

	Set<String> zrangeByScore(Integer dbIndex, String key, double min, double max);

	Set<String> zrangeByScore(Integer dbIndex, String key, String min, String max);

	Set<String> zrevrangeByScore(Integer dbIndex, String key, double max, double min);

	Set<String> zrangeByScore(Integer dbIndex, String key, double min, double max, int offset, int count);

	Set<String> zrevrangeByScore(Integer dbIndex, String key, String max, String min);

	Set<String> zrangeByScore(Integer dbIndex, String key, String min, String max, int offset, int count);

	Set<String> zrevrangeByScore(Integer dbIndex, String key, double max, double min, int offset, int count);

	Set<Tuple> zrangeByScoreWithScores(Integer dbIndex, String key, double min, double max);

	Set<Tuple> zrevrangeByScoreWithScores(Integer dbIndex, String key, double max, double min);

	Set<Tuple> zrangeByScoreWithScores(Integer dbIndex, String key, double min, double max, int offset, int count);

	Set<String> zrevrangeByScore(Integer dbIndex, String key, String max, String min, int offset, int count);

	Set<Tuple> zrangeByScoreWithScores(Integer dbIndex, String key, String min, String max);

	Set<Tuple> zrevrangeByScoreWithScores(Integer dbIndex, String key, String max, String min);

	Set<Tuple> zrangeByScoreWithScores(Integer dbIndex, String key, String min, String max, int offset, int count);

	Set<Tuple> zrevrangeByScoreWithScores(Integer dbIndex, String key, double max, double min, int offset, int count);

	Set<Tuple> zrevrangeByScoreWithScores(Integer dbIndex, String key, String max, String min, int offset, int count);

	Long zremrangeByRank(Integer dbIndex, String key, long start, long end);

	Long zremrangeByScore(Integer dbIndex, String key, double start, double end);

	Long zremrangeByScore(Integer dbIndex, String key, String start, String end);

	Long zlexcount(Integer dbIndex, String key, String min, String max);

	Set<String> zrangeByLex(Integer dbIndex, String key, String min, String max);

	Set<String> zrangeByLex(Integer dbIndex, String key, String min, String max, int offset, int count);

	Set<String> zrevrangeByLex(Integer dbIndex, String key, String max, String min);

	Set<String> zrevrangeByLex(Integer dbIndex, String key, String max, String min, int offset, int count);

	Long zremrangeByLex(Integer dbIndex, String key, String min, String max);

	Long linsert(Integer dbIndex, String key, LIST_POSITION where, String pivot, String value);

	Long lpushx(Integer dbIndex, String key, String... string);

	Long rpushx(Integer dbIndex, String key, String... string);

	List<String> blpop(Integer dbIndex, String arg);

	List<String> blpop(Integer dbIndex, int timeout, String key);

	List<String> brpop(Integer dbIndex, String arg);

	List<String> brpop(Integer dbIndex, int timeout, String key);

	Long del(Integer dbIndex, String key);

	String echo(Integer dbIndex, String string);

	Long move(Integer dbIndex, String key, int targetIndex);

	Long bitcount(Integer dbIndex, String key);

	Long bitcount(Integer dbIndex, String key, long start, long end);

	ScanResult<Entry<String, String>> hscan(Integer dbIndex, String key, int cursor);

	ScanResult<String> sscan(Integer dbIndex, String key, int cursor);

	ScanResult<Tuple> zscan(Integer dbIndex, String key, int cursor);

	ScanResult<Entry<String, String>> hscan(Integer dbIndex, String key, String cursor);

	ScanResult<String> sscan(Integer dbIndex, String key, String cursor);

	ScanResult<Tuple> zscan(Integer dbIndex, String key, String cursor);

	Long pfadd(Integer dbIndex, String key, String... elements);

	long pfcount(Integer dbIndex, String key);

}