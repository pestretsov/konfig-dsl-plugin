package com.pestretsov.plugin.dsl

import com.intellij.ide.highlighter.JavaClassFileType
import com.intellij.openapi.components.AbstractProjectComponent
import com.intellij.openapi.components.ProjectComponent
import com.intellij.openapi.project.Project
import com.intellij.psi.search.EverythingGlobalScope
import com.intellij.psi.search.FileTypeIndex

class DSLProjectComponent(val project : Project) : ProjectComponent, AbstractProjectComponent(project) {
    override fun projectOpened() {
        print(project.name)

        val searchScope = EverythingGlobalScope.allScope(project)
        val files = FileTypeIndex.getFiles(JavaClassFileType.INSTANCE, searchScope)
        for (file in files) {
            println(file.name)
        }
    }
}
