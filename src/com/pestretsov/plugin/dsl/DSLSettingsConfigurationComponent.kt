package com.pestretsov.plugin.dsl

import com.intellij.openapi.components.ProjectComponent
import com.intellij.openapi.project.Project
import org.jetbrains.kotlin.config.CompilerSettings
import org.jetbrains.kotlin.idea.compiler.configuration.KotlinCompilerSettings

const val PATH_TO_DSL_JAR = "\$PROJECT_DIR\$/helper/sample-dsl.jar"
const val DSL_CONFIG_CLASS = "com.example.AgentConfig"

class DSLSettingsConfigurationComponent(private val project: Project) : ProjectComponent {
    override fun projectOpened() {
        val kotlinCompilerSettings = KotlinCompilerSettings.getInstance(project)
        val settings = kotlinCompilerSettings.settings
        if (settings.scriptTemplates != DSL_CONFIG_CLASS && settings.scriptTemplatesClasspath != PATH_TO_DSL_JAR) {
            val newSettings = CompilerSettings()
            newSettings.scriptTemplates = DSL_CONFIG_CLASS
            newSettings.scriptTemplatesClasspath = PATH_TO_DSL_JAR
            kotlinCompilerSettings.settings = newSettings
        }
    }
}
