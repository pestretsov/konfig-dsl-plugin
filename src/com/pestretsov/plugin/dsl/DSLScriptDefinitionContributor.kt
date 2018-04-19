package com.pestretsov.plugin.dsl

import com.intellij.openapi.diagnostic.Logger
import org.jetbrains.kotlin.idea.core.script.ScriptDefinitionContributor
import org.jetbrains.kotlin.idea.core.script.loadDefinitionsFromTemplates
import org.jetbrains.kotlin.script.KotlinScriptDefinition
import java.io.File

const val PATH_TO_DSL_JAR = "/Users/artemypestretsov/IdeaProjects/konfing-dsl-test/helper/sample-dsl.jar"
const val DSL_CONFIG_CLASS = "com.example.AgentConfig"

private val LOG = Logger.getInstance("ScriptTemplatesProviders")

class DSLScriptDefinitionContributor : ScriptDefinitionContributor {
    override val id = "DSLScriptDefinitionContributor"

    override fun getDefinitions(): List<KotlinScriptDefinition> {
        LOG.info("Loading Konfig DSL definitions")

        return loadDefinitionsFromTemplates(
                templateClassNames = listOf(DSL_CONFIG_CLASS),
                templateClasspath = listOf(File(PATH_TO_DSL_JAR))
        )
    }
}
