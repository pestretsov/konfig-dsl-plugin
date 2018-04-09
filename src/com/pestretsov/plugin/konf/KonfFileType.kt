package com.pestretsov.plugin.konf

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object KonfFileType : LanguageFileType(KonfLanguage.INSTANCE) {
    override fun getName() = "Konf"

    override fun getDefaultExtension() = "konf"

    override fun getDescription() = "Konf language file"

    override fun getIcon(): Icon? = KonfIcons.FILE
}
