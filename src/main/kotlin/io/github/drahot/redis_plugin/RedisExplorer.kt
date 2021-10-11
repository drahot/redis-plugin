package io.github.drahot.redis_plugin

import com.intellij.openapi.actionSystem.ActionManager
import com.intellij.openapi.actionSystem.ActionPlaces
import com.intellij.openapi.actionSystem.ActionToolbar
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.SimpleToolWindowPanel
import com.intellij.ui.treeStructure.Tree
import io.github.drahot.redis_plugin.actions.RedisActionToolbarGroup
import javax.swing.SwingConstants

class RedisExplorer(project: Project) : SimpleToolWindowPanel(true, true) {

    private val logger = Logger.getInstance(RedisExplorer::class.java)

    companion object {
        fun buildActionToolbar(tree: Tree): ActionToolbar {
            val actionManager = ActionManager.getInstance()
            val actionToolbarGroup = RedisActionToolbarGroup()
            val actionToolbar = actionManager.createActionToolbar(
                ActionPlaces.UNKNOWN, actionToolbarGroup, true
            )
            return actionToolbar.apply {
                setOrientation(SwingConstants.HORIZONTAL)
                setShowSeparatorTitles(true)
                component.name = "REDIS_ACTION_TOOLBAR"
            }
        }

//        fun buildTree(project: Project, backgroundColor: Color): Tree {
//            val top = DefaultMutableTreeNode("Root Node")
//
//        }
    }
}
