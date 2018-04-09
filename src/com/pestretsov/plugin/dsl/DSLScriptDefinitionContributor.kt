package com.pestretsov.plugin.dsl

import com.intellij.openapi.project.Project
import org.jetbrains.kotlin.idea.core.script.ScriptDefinitionContributor
import org.jetbrains.kotlin.idea.core.script.loadDefinitionsFromTemplates
import org.jetbrains.kotlin.script.KotlinScriptDefinition
import java.io.File


class DSLScriptDefinitionContributor(val project: Project) : ScriptDefinitionContributor {
    override val id = "DSLScriptDefinitionContributor"

    override fun getDefinitions(): List<KotlinScriptDefinition> {

        println("loading defs")

        return loadDefinitionsFromTemplates(
                templateClassNames = listOf(DSL_CONFIG_CLASS),
                templateClasspath = listOf(File(PATH_TO_DSL_JAR)),
                environment = mapOf(
                        "projectRoot" to (project.basePath ?: project.baseDir.canonicalPath)?.let(::File))
        )
    }
}
