package com.pestretsov.plugin.konf

import com.intellij.lang.Language

class KonfLanguage private constructor() : Language("Konf") {
    companion object {
        val INSTANCE = KonfLanguage()
    }
}
