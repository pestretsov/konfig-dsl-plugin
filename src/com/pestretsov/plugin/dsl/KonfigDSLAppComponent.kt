package com.pestretsov.plugin.dsl

import com.intellij.openapi.application.PathManager.getPluginsPath
import com.intellij.openapi.components.ApplicationComponent
import com.intellij.openapi.util.io.FileUtilRt.toSystemIndependentName

class KonfigDSLAppComponent: ApplicationComponent {
    override fun initComponent() {
        print(pluginLibsPath)
    }

    companion object {
        val pluginId = "KonfigDSL"
        val pluginLibsPath = toSystemIndependentName(getPluginsPath() + "/LivePlugin/lib/")
    }
}