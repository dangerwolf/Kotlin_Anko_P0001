package com.wolf.ankop0001.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import android.view.View
import com.tencent.bugly.proguard.v
import com.wolf.ankop0001.R
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class SplashActivity : AppCompatActivity() {

    var tempStr: String = "待传参"

//  定义selector的显示选项
    private val opinions = listOf("Make a call","Send a text","Browse the web","Share some text","Send a email")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        setContentView(R.layout.activity_splash)

        /**
         * 隐藏/显示返回箭头
         */
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //设置actionBar的title
//        supportActionBar?.setTitle(R.string.splash_title)
        //设置actionBar的logo图片
//        supportActionBar?.setLogo(R.drawable.ic_launcher);

        verticalLayout {
            val name = editText {
                hint = intent.extras["from"]?.toString()
            }
            button("Say Hello") {
                onClick {
//                    toast("Hello, ${name.text}! + ${tempStr}")
                    selectorTemp()
                }

            }
        }

    }





    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id = item.itemId
        when (id) {
            android.R.id.home////主键id 必须这样写
            -> onBackPressed()//按返回图标直接回退上个界面
        }
        return super.onOptionsItemSelected(item)
    }


    private fun selectorTemp(){
        selector("想要做什么?", opinions, { dialogInterface, index ->
            when (index) {
                0 -> makeCall("10086")
                1 -> sendSMS("10086", "116")
                2 -> browse("www.baidu.com")
                3 -> share("Tesf","WOLF")
                4 -> email("sunht@bjyn.com","Test001")
            }
        })
    }

}
