package io.github.drahot.redis_plugin.client

import com.jcraft.jsch.JSch
import com.jcraft.jsch.Session
import java.net.Socket

private const val DEFAULT_SSH_PORT = 22
private const val DEFAULT_REDIS_PORT = 6379

/**
 * SSHTunnel
 */
@Suppress("unused")
class SSHTunnel(
    host: String,
    user: String,
    private val password: String? = null,
    port: Int = DEFAULT_SSH_PORT,
    private val identity: String? = null
) {

    private val jsch: JSch = JSch().apply {
        if (identity != null) {
            addIdentity(identity)
        }
    }

    private val session: Session = jsch.getSession(user, host, port).apply {
        setConfig("StrictHostKeyChecking", "no")
        if (password != null) {
            setConfig("PreferredAuthentications", "password")
            setPassword(password)
        }
    }

    fun connect(redisHost: String, redisPort: Int = DEFAULT_REDIS_PORT): Int {
        session.connect()
        return session.setPortForwardingL(getAvailablePort(), redisHost, redisPort)
    }

    fun disconnect() {
        session.disconnect()
    }

    private fun getAvailablePort(): Int = Socket().use {
        it.bind(null)
        it.localPort
    }
}
