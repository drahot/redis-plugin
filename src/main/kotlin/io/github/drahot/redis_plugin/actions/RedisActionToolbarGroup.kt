package io.github.drahot.redis_plugin.actions

import com.intellij.ide.actions.CollapseAllAction
import com.intellij.ide.actions.ExpandAllAction
import com.intellij.openapi.actionSystem.ActionManager
import com.intellij.openapi.actionSystem.DefaultActionGroup

class RedisActionToolbarGroup : DefaultActionGroup("RedisActionToolbar", false) {
    init {
        val actionManager = ActionManager.getInstance()
        add(actionManager.getAction("AddRedisAction"))
        add(actionManager.getAction("RemoveRedisAction"))
        add(CollapseAllAction())
        add(ExpandAllAction())
    }
}
