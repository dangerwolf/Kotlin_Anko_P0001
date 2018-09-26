package com.wolf.ankop0001.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.wolf.ankop0001.View.MainActivityUI
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() ,AnkoLogger{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

//        很多时候我们其实还是希望布局和 Activity 分开的，所以建议在Activity 的 onCreate 方法中使用 DSL。

        MainActivityUI().setContentView(this)

        info("Test")
    }
}


