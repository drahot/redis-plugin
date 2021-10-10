package io.github.drahot.redis_plugin.client

import redis.clients.jedis.Jedis
import redis.clients.jedis.exceptions.JedisDataException
import redis.clients.jedis.params.SetParams

/**
 * RedisClient
 */
@Suppress("unused")
class RedisClient(
    host: String,
    port: Int
) {

    private val jedis = Jedis(host, port)

    val dbCount: Int
        get() {
            for (i in 0 until 64) {
                try {
                    jedis.select(i)
                } catch (e: JedisDataException) {
                    return i
                }
            }
            return 0
        }

    fun db(): Int = jedis.db
    fun dbSize(): Long = jedis.dbSize()

    /**
     * Select
     *
     * @param dbIndex
     * @return String
     */
    fun select(dbIndex: Int): String = jedis.select(dbIndex)

    /**
     * Keys
     * @param pattern
     * @return keys
     */
    fun keys(pattern: String): Set<String> = jedis.keys(pattern)

    fun get(key: String): String = jedis.get(key)

    fun set(key: String, value: String): String = jedis.set(key, value)

    fun set(key: String, value: String, params: SetParams): String = jedis.set(key, value, params)

    fun del(key: String): Long = jedis.del(key)

    fun del(vararg keys: String): Long = jedis.del(*keys)

    fun exists(key: String): Boolean = jedis.exists(key)

    fun exists(vararg keys: String): Long = jedis.exists(*keys)

    fun exists(vararg keys: ByteArray): Long = jedis.exists(*keys)

    fun exists(key: ByteArray): Boolean = jedis.exists(key)

    fun type(key: String): String = jedis.type(key)

    fun disconnect() = jedis.disconnect()
}
