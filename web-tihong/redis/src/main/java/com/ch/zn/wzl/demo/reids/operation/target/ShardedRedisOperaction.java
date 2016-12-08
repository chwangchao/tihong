package com.ch.zn.wzl.demo.reids.operation.target;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ch.zn.wzl.demo.reids.operation.annotations.RedisOperation;

import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.JedisCommands;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.Tuple;

@Component
public class ShardedRedisOperaction {

	@RedisOperation
	public Long append(JedisCommands jedisCommands, Integer dbIndex, String key, String value) {
		return jedisCommands.append(key, value);
	}

	@RedisOperation
	public Long bitcount(JedisCommands jedisCommands, Integer dbIndex, String key) {
		return jedisCommands.bitcount(key);
	}

	@RedisOperation
	public Long bitcount(JedisCommands jedisCommands, Integer dbIndex, String key, long start, long end) {
		return jedisCommands.bitcount(key, start, end);
	}

	@RedisOperation
	public List<String> blpop(JedisCommands jedisCommands, Integer dbIndex, int timeout, String key) {
		return jedisCommands.blpop(timeout, key);
	}

	@RedisOperation
	public List<String> blpop(JedisCommands jedisCommands, Integer dbIndex, String arg) {
		return jedisCommands.blpop(arg);
	}

	@RedisOperation
	public List<String> brpop(JedisCommands jedisCommands, Integer dbIndex, int timeout, String key) {
		return jedisCommands.brpop(timeout, key);
	}

	@RedisOperation
	public List<String> brpop(JedisCommands jedisCommands, Integer dbIndex, String arg) {
		return jedisCommands.brpop(arg);
	}

	@RedisOperation
	public Long decr(JedisCommands jedisCommands, Integer dbIndex, String key) {
		return jedisCommands.decr(key);
	}

	@RedisOperation
	public Long decrBy(JedisCommands jedisCommands, Integer dbIndex, String key, long integer) {
		return jedisCommands.decrBy(key, integer);
	}

	@RedisOperation
	public Long del(JedisCommands jedisCommands, Integer dbIndex, String key) {
		return jedisCommands.del(key);
	}

	@RedisOperation
	public String echo(JedisCommands jedisCommands, Integer dbIndex, String string) {
		return jedisCommands.echo(string);
	}

	@RedisOperation
	public Boolean exists(JedisCommands jedisCommands, Integer dbIndex, String key) {
		return jedisCommands.exists(key);
	}

	@RedisOperation
	public Long expire(JedisCommands jedisCommands, Integer dbIndex, String key, int seconds) {
		return jedisCommands.expire(key, seconds);
	}

	@RedisOperation
	public Long expireAt(JedisCommands jedisCommands, Integer dbIndex, String key, long unixTime) {
		return jedisCommands.expireAt(key, unixTime);
	}

	@RedisOperation
	public String get(JedisCommands jedisCommands, Integer dbIndex, String key) {
		return jedisCommands.get(key);
	}

	@RedisOperation
	public Boolean getbit(JedisCommands jedisCommands, Integer dbIndex, String key, long offset) {
		return jedisCommands.getbit(key, offset);
	}

	@RedisOperation
	public String getrange(JedisCommands jedisCommands, Integer dbIndex, String key, long startOffset, long endOffset) {
		return jedisCommands.getrange(key, startOffset, endOffset);
	}

	@RedisOperation
	public String getSet(JedisCommands jedisCommands, Integer dbIndex, String key, String value) {
		return jedisCommands.getSet(key, value);
	}

	@RedisOperation
	public Long hdel(JedisCommands jedisCommands, Integer dbIndex, String key, String... field) {
		return jedisCommands.hdel(key, field);
	}

	@RedisOperation
	public Boolean hexists(JedisCommands jedisCommands, Integer dbIndex, String key, String field) {
		return jedisCommands.hexists(key, field);
	}

	@RedisOperation
	public String hget(JedisCommands jedisCommands, Integer dbIndex, String key, String field) {
		return jedisCommands.hget(key, field);
	}

	@RedisOperation
	public Map<String, String> hgetAll(JedisCommands jedisCommands, Integer dbIndex, String key) {
		return jedisCommands.hgetAll(key);
	}

	@RedisOperation
	public Long hincrBy(JedisCommands jedisCommands, Integer dbIndex, String key, String field, long value) {
		return jedisCommands.hincrBy(key, field, value);
	}

	@RedisOperation
	public Set<String> hkeys(JedisCommands jedisCommands, Integer dbIndex, String key) {
		return jedisCommands.hkeys(key);
	}

	@RedisOperation
	public Long hlen(JedisCommands jedisCommands, Integer dbIndex, String key) {
		return jedisCommands.hlen(key);
	}

	@RedisOperation
	public List<String> hmget(JedisCommands jedisCommands, Integer dbIndex, String key, String... fields) {
		return jedisCommands.hmget(key, fields);
	}

	@RedisOperation
	public String hmset(JedisCommands jedisCommands, Integer dbIndex, String key, Map<String, String> hash) {
		return jedisCommands.hmset(key, hash);
	}

	@RedisOperation
	public ScanResult<Entry<String, String>> hscan(JedisCommands jedisCommands, Integer dbIndex, String key,
			int cursor) {
		return jedisCommands.hscan(key, cursor);
	}

	@RedisOperation
	public ScanResult<Entry<String, String>> hscan(JedisCommands jedisCommands, Integer dbIndex, String key,
			String cursor) {
		return jedisCommands.hscan(key, cursor);
	}

	@RedisOperation
	public Long hset(JedisCommands jedisCommands, Integer dbIndex, String key, String field, String value) {
		return jedisCommands.hset(key, field, value);
	}

	@RedisOperation
	public Long hsetnx(JedisCommands jedisCommands, Integer dbIndex, String key, String field, String value) {
		return jedisCommands.hsetnx(key, field, value);
	}

	@RedisOperation
	public List<String> hvals(JedisCommands jedisCommands, Integer dbIndex, String key) {
		return jedisCommands.hvals(key);
	}

	@RedisOperation
	public Long incr(JedisCommands jedisCommands, Integer dbIndex, String key) {
		return jedisCommands.incr(key);
	}

	@RedisOperation
	public Long incrBy(JedisCommands jedisCommands, Integer dbIndex, String key, long integer) {
		return jedisCommands.incrBy(key, integer);
	}

	@RedisOperation
	public Double incrByFloat(JedisCommands jedisCommands, Integer dbIndex, String key, double value) {
		return jedisCommands.incrByFloat(key, value);
	}

	@RedisOperation
	public String lindex(JedisCommands jedisCommands, Integer dbIndex, String key, long index) {
		return jedisCommands.lindex(key, index);
	}

	@RedisOperation
	public Long linsert(JedisCommands jedisCommands, Integer dbIndex, String key, LIST_POSITION where, String pivot,
			String value) {
		return jedisCommands.linsert(key, where, pivot, value);
	}

	@RedisOperation
	public Long llen(JedisCommands jedisCommands, Integer dbIndex, String key) {
		return jedisCommands.llen(key);
	}

	@RedisOperation
	public String lpop(JedisCommands jedisCommands, Integer dbIndex, String key) {
		return jedisCommands.lpop(key);
	}

	@RedisOperation
	public Long lpush(JedisCommands jedisCommands, Integer dbIndex, String key, String... string) {
		return jedisCommands.lpush(key, string);
	}

	@RedisOperation
	public Long lpushx(JedisCommands jedisCommands, Integer dbIndex, String key, String... string) {
		return jedisCommands.lpushx(key, string);
	}

	@RedisOperation
	public List<String> lrange(JedisCommands jedisCommands, Integer dbIndex, String key, long start, long end) {
		return jedisCommands.lrange(key, start, end);
	}

	@RedisOperation
	public Long lrem(JedisCommands jedisCommands, Integer dbIndex, String key, long count, String value) {
		return jedisCommands.lrem(key, count, value);
	}

	@RedisOperation
	public String lset(JedisCommands jedisCommands, Integer dbIndex, String key, long index, String value) {
		return jedisCommands.lset(key, index, value);
	}

	@RedisOperation
	public String ltrim(JedisCommands jedisCommands, Integer dbIndex, String key, long start, long end) {
		return jedisCommands.ltrim(key, start, end);
	}

	@RedisOperation
	public Long move(JedisCommands jedisCommands, Integer dbIndex, String key, int targetIndex) {
		return jedisCommands.move(key, targetIndex);
	}

	@RedisOperation
	public Long persist(JedisCommands jedisCommands, Integer dbIndex, String key) {
		return jedisCommands.persist(key);
	}

	@RedisOperation
	public Long pexpire(JedisCommands jedisCommands, Integer dbIndex, String key, long milliseconds) {
		return jedisCommands.pexpire(key, milliseconds);
	}

	@RedisOperation
	public Long pexpireAt(JedisCommands jedisCommands, Integer dbIndex, String key, long millisecondsTimestamp) {
		return jedisCommands.pexpireAt(key, millisecondsTimestamp);
	}

	@RedisOperation
	public Long pfadd(JedisCommands jedisCommands, Integer dbIndex, String key, String... elements) {
		return jedisCommands.pfadd(key, elements);
	}

	@RedisOperation
	public long pfcount(JedisCommands jedisCommands, Integer dbIndex, String key) {
		return jedisCommands.pfcount(key);
	}

	@RedisOperation
	public String rpop(JedisCommands jedisCommands, Integer dbIndex, String key) {
		return jedisCommands.rpop(key);
	}

	@RedisOperation
	public Long rpush(JedisCommands jedisCommands, Integer dbIndex, String key, String... string) {
		return jedisCommands.rpush(key, string);
	}

	@RedisOperation
	public Long rpushx(JedisCommands jedisCommands, Integer dbIndex, String key, String... string) {
		return jedisCommands.rpushx(key, string);
	}

	@RedisOperation
	public Long sadd(JedisCommands jedisCommands, Integer dbIndex, String key, String... member) {
		return jedisCommands.sadd(key, member);
	}

	@RedisOperation
	public Long scard(JedisCommands jedisCommands, Integer dbIndex, String key) {
		return jedisCommands.scard(key);
	}

	@RedisOperation
	public String set(JedisCommands jedisCommands, Integer dbIndex, String key, String value) {
		return jedisCommands.set(key, value);
	}

	@RedisOperation
	public String set(JedisCommands jedisCommands, Integer dbIndex, String key, String value, String nxxx, String expx,
			long time) {
		return jedisCommands.set(key, value, nxxx, expx, time);
	}

	@RedisOperation
	public Boolean setbit(JedisCommands jedisCommands, Integer dbIndex, String key, long offset, boolean value) {
		return jedisCommands.setbit(key, offset, value);
	}

	@RedisOperation
	public Boolean setbit(JedisCommands jedisCommands, Integer dbIndex, String key, long offset, String value) {
		return jedisCommands.setbit(key, offset, value);
	}

	@RedisOperation
	public String setex(JedisCommands jedisCommands, Integer dbIndex, String key, int seconds, String value) {
		return jedisCommands.setex(key, seconds, value);
	}

	@RedisOperation
	public Long setnx(JedisCommands jedisCommands, Integer dbIndex, String key, String value) {
		return jedisCommands.setnx(key, value);
	}

	@RedisOperation
	public Long setrange(JedisCommands jedisCommands, Integer dbIndex, String key, long offset, String value) {
		return jedisCommands.setrange(key, offset, value);
	}

	@RedisOperation
	public Boolean sismember(JedisCommands jedisCommands, Integer dbIndex, String key, String member) {
		return jedisCommands.sismember(key, member);
	}

	@RedisOperation
	public Set<String> smembers(JedisCommands jedisCommands, Integer dbIndex, String key) {
		return jedisCommands.smembers(key);
	}

	@RedisOperation
	public List<String> sort(JedisCommands jedisCommands, Integer dbIndex, String key) {
		return jedisCommands.sort(key);
	}

	@RedisOperation
	public List<String> sort(JedisCommands jedisCommands, Integer dbIndex, String key,
			SortingParams sortingParameters) {
		return jedisCommands.sort(key, sortingParameters);
	}

	@RedisOperation
	public String spop(JedisCommands jedisCommands, Integer dbIndex, String key) {
		return jedisCommands.spop(key);
	}

	@RedisOperation
	public Set<String> spop(JedisCommands jedisCommands, Integer dbIndex, String key, long count) {
		return jedisCommands.spop(key, count);
	}

	@RedisOperation
	public String srandmember(JedisCommands jedisCommands, Integer dbIndex, String key) {
		return jedisCommands.srandmember(key);
	}

	@RedisOperation
	public List<String> srandmember(JedisCommands jedisCommands, Integer dbIndex, String key, int count) {
		return jedisCommands.srandmember(key, count);
	}

	@RedisOperation
	public Long srem(JedisCommands jedisCommands, Integer dbIndex, String key, String... member) {
		return jedisCommands.srem(key, member);
	}

	@RedisOperation
	public ScanResult<String> sscan(JedisCommands jedisCommands, Integer dbIndex, String key, int cursor) {
		return jedisCommands.sscan(key, cursor);
	}

	@RedisOperation
	public ScanResult<String> sscan(JedisCommands jedisCommands, Integer dbIndex, String key, String cursor) {
		return jedisCommands.sscan(key, cursor);
	}

	@RedisOperation
	public Long strlen(JedisCommands jedisCommands, Integer dbIndex, String key) {
		return jedisCommands.strlen(key);
	}

	@RedisOperation
	public String substr(JedisCommands jedisCommands, Integer dbIndex, String key, int start, int end) {
		return jedisCommands.substr(key, start, end);
	}

	@RedisOperation
	public Long ttl(JedisCommands jedisCommands, Integer dbIndex, String key) {
		return jedisCommands.ttl(key);
	}

	@RedisOperation
	public String type(JedisCommands jedisCommands, Integer dbIndex, String key) {
		return jedisCommands.type(key);
	}

	@RedisOperation
	public Long zadd(JedisCommands jedisCommands, Integer dbIndex, String key, double score, String member) {
		return jedisCommands.zadd(key, score, member);
	}

	@RedisOperation
	public Long zadd(JedisCommands jedisCommands, Integer dbIndex, String key, Map<String, Double> scoreMembers) {
		return jedisCommands.zadd(key, scoreMembers);
	}

	@RedisOperation
	public Long zcard(JedisCommands jedisCommands, Integer dbIndex, String key) {
		return jedisCommands.zcard(key);
	}

	@RedisOperation
	public Long zcount(JedisCommands jedisCommands, Integer dbIndex, String key, double min, double max) {
		return jedisCommands.zcount(key, min, max);
	}

	@RedisOperation
	public Long zcount(JedisCommands jedisCommands, Integer dbIndex, String key, String min, String max) {
		return jedisCommands.zcount(key, min, max);
	}

	@RedisOperation
	public Double zincrby(JedisCommands jedisCommands, Integer dbIndex, String key, double score, String member) {
		return jedisCommands.zincrby(key, score, member);
	}

	@RedisOperation
	public Long zlexcount(JedisCommands jedisCommands, Integer dbIndex, String key, String min, String max) {
		return jedisCommands.zlexcount(key, min, max);
	}

	@RedisOperation
	public Set<String> zrange(JedisCommands jedisCommands, Integer dbIndex, String key, long start, long end) {
		return jedisCommands.zrange(key, start, end);
	}

	@RedisOperation
	public Set<String> zrangeByLex(JedisCommands jedisCommands, Integer dbIndex, String key, String min, String max) {
		return jedisCommands.zrangeByLex(key, min, max);
	}

	@RedisOperation
	public Set<String> zrangeByLex(JedisCommands jedisCommands, Integer dbIndex, String key, String min, String max,
			int offset, int count) {
		return jedisCommands.zrangeByLex(key, min, max, offset, count);
	}

	@RedisOperation
	public Set<String> zrangeByScore(JedisCommands jedisCommands, Integer dbIndex, String key, double min, double max) {
		return jedisCommands.zrangeByScore(key, min, max);
	}

	@RedisOperation
	public Set<String> zrangeByScore(JedisCommands jedisCommands, Integer dbIndex, String key, double min, double max,
			int offset, int count) {
		return jedisCommands.zrangeByScore(key, min, max, offset, count);
	}

	@RedisOperation
	public Set<String> zrangeByScore(JedisCommands jedisCommands, Integer dbIndex, String key, String min, String max) {
		return jedisCommands.zrangeByScore(key, min, max);
	}

	@RedisOperation
	public Set<String> zrangeByScore(JedisCommands jedisCommands, Integer dbIndex, String key, String min, String max,
			int offset, int count) {
		return jedisCommands.zrangeByScore(key, min, max, offset, count);
	}

	@RedisOperation
	public Set<Tuple> zrangeByScoreWithScores(JedisCommands jedisCommands, Integer dbIndex, String key, double min,
			double max) {
		return jedisCommands.zrangeByScoreWithScores(key, min, max);
	}

	@RedisOperation
	public Set<Tuple> zrangeByScoreWithScores(JedisCommands jedisCommands, Integer dbIndex, String key, double min,
			double max, int offset, int count) {
		return jedisCommands.zrangeByScoreWithScores(key, min, max, offset, count);
	}

	@RedisOperation
	public Set<Tuple> zrangeByScoreWithScores(JedisCommands jedisCommands, Integer dbIndex, String key, String min,
			String max) {
		return jedisCommands.zrangeByScoreWithScores(key, min, max);
	}

	@RedisOperation
	public Set<Tuple> zrangeByScoreWithScores(JedisCommands jedisCommands, Integer dbIndex, String key, String min,
			String max, int offset, int count) {
		return jedisCommands.zrangeByScoreWithScores(key, min, max, offset, count);
	}

	@RedisOperation
	public Set<Tuple> zrangeWithScores(JedisCommands jedisCommands, Integer dbIndex, String key, long start, long end) {
		return jedisCommands.zrangeWithScores(key, start, end);
	}

	@RedisOperation
	public Long zrank(JedisCommands jedisCommands, Integer dbIndex, String key, String member) {
		return jedisCommands.zrank(key, member);
	}

	@RedisOperation
	public Long zrem(JedisCommands jedisCommands, Integer dbIndex, String key, String... member) {
		return jedisCommands.zrem(key, member);
	}

	@RedisOperation
	public Long zremrangeByLex(JedisCommands jedisCommands, Integer dbIndex, String key, String min, String max) {
		return jedisCommands.zremrangeByLex(key, min, max);
	}

	@RedisOperation
	public Long zremrangeByRank(JedisCommands jedisCommands, Integer dbIndex, String key, long start, long end) {
		return jedisCommands.zremrangeByRank(key, start, end);
	}

	@RedisOperation
	public Long zremrangeByScore(JedisCommands jedisCommands, Integer dbIndex, String key, double start, double end) {
		return jedisCommands.zremrangeByScore(key, start, end);
	}

	@RedisOperation
	public Long zremrangeByScore(JedisCommands jedisCommands, Integer dbIndex, String key, String start, String end) {
		return jedisCommands.zremrangeByScore(key, start, end);
	}

	@RedisOperation
	public Set<String> zrevrange(JedisCommands jedisCommands, Integer dbIndex, String key, long start, long end) {
		return jedisCommands.zrevrange(key, start, end);
	}

	@RedisOperation
	public Set<String> zrevrangeByLex(JedisCommands jedisCommands, Integer dbIndex, String key, String max,
			String min) {
		return jedisCommands.zrevrangeByLex(key, max, min);
	}

	@RedisOperation
	public Set<String> zrevrangeByLex(JedisCommands jedisCommands, Integer dbIndex, String key, String max, String min,
			int offset, int count) {
		return jedisCommands.zrevrangeByLex(key, max, min, offset, count);
	}

	@RedisOperation
	public Set<String> zrevrangeByScore(JedisCommands jedisCommands, Integer dbIndex, String key, double max,
			double min) {
		return jedisCommands.zrevrangeByScore(key, max, min);
	}

	@RedisOperation
	public Set<String> zrevrangeByScore(JedisCommands jedisCommands, Integer dbIndex, String key, double max,
			double min, int offset, int count) {
		return jedisCommands.zrevrangeByScore(key, max, min, offset, count);
	}

	@RedisOperation
	public Set<String> zrevrangeByScore(JedisCommands jedisCommands, Integer dbIndex, String key, String max,
			String min) {
		return jedisCommands.zrevrangeByScore(key, max, min);
	}

	@RedisOperation
	public Set<String> zrevrangeByScore(JedisCommands jedisCommands, Integer dbIndex, String key, String max,
			String min, int offset, int count) {
		return jedisCommands.zrevrangeByScore(key, max, min, offset, count);
	}

	@RedisOperation
	public Set<Tuple> zrevrangeByScoreWithScores(JedisCommands jedisCommands, Integer dbIndex, String key, double max,
			double min) {
		return jedisCommands.zrevrangeByScoreWithScores(key, max, min);
	}

	@RedisOperation
	public Set<Tuple> zrevrangeByScoreWithScores(JedisCommands jedisCommands, Integer dbIndex, String key, double max,
			double min, int offset, int count) {
		return jedisCommands.zrevrangeByScoreWithScores(key, max, min, offset, count);
	}

	@RedisOperation
	public Set<Tuple> zrevrangeByScoreWithScores(JedisCommands jedisCommands, Integer dbIndex, String key, String max,
			String min) {
		return jedisCommands.zrevrangeByScoreWithScores(key, max, min);
	}

	@RedisOperation
	public Set<Tuple> zrevrangeByScoreWithScores(JedisCommands jedisCommands, Integer dbIndex, String key, String max,
			String min, int offset, int count) {
		return jedisCommands.zrevrangeByScoreWithScores(key, max, min, offset, count);
	}

	@RedisOperation
	public Set<Tuple> zrevrangeWithScores(JedisCommands jedisCommands, Integer dbIndex, String key, long start,
			long end) {
		return jedisCommands.zrevrangeWithScores(key, start, end);
	}

	@RedisOperation
	public Long zrevrank(JedisCommands jedisCommands, Integer dbIndex, String key, String member) {
		return jedisCommands.zrevrank(key, member);
	}

	@RedisOperation
	public ScanResult<Tuple> zscan(JedisCommands jedisCommands, Integer dbIndex, String key, int cursor) {
		return jedisCommands.zscan(key, cursor);
	}

	@RedisOperation
	public ScanResult<Tuple> zscan(JedisCommands jedisCommands, Integer dbIndex, String key, String cursor) {
		return jedisCommands.zscan(key, cursor);
	}

	@RedisOperation
	public Double zscore(JedisCommands jedisCommands, Integer dbIndex, String key, String member) {
		return jedisCommands.zscore(key, member);
	}

}
