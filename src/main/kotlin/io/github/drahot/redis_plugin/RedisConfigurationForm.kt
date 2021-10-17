package io.github.drahot.redis_plugin

import javax.swing.JFrame
import javax.swing.JPanel

class RedisConfigurationForm(title: String) : JFrame(title) {
    private val mainPanel: JPanel? = null

    init {
        defaultCloseOperation = EXIT_ON_CLOSE
        contentPane = mainPanel
        pack()
    }

    companion object {

        fun show() {
            val form  = RedisConfigurationForm("Add Redis Server")
            form.isVisible = true
        }
    }
}
