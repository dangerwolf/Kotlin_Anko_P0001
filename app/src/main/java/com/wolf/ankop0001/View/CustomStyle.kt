package com.wolf.ankop0001.View

import android.graphics.Color
import android.graphics.Typeface
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.jetbrains.anko.textColor

fun TextView.usePrimary(){
    textSize = 15f
    textColor = Color.BLACK
    typeface = Typeface.DEFAULT_BOLD
}

fun TextView.useSecond(){
    textSize = 12f
    textColor = Color.GRAY
}

val textSizeStyle = { v:Any ->

    when (v) {
        is Button -> v.textSize = 26f
        is EditText -> v.textSize = 24f
    }

}
