package com.wolf.ankop0001.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.wolf.ankop0001.R
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        verticalLayout {
            padding = dip(60)
            topPadding = dip(200)
            val name = editText{
                hint = "请输入您的用户名"
                
            }
            button("Say Hello") {
                width = dip(50)
                onClick { toast("Hello, ${name.text}!") }
            }
        }.applyRecursively {
            view -> when(view) {
                is EditText -> view.textSize = 20f
            }
        }
    }
}
