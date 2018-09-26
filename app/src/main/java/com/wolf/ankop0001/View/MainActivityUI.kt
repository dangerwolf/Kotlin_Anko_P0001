package com.wolf.ankop0001.View


import android.widget.EditText
import android.widget.ImageView
import com.wolf.ankop0001.Activity.MainActivity
import com.wolf.ankop0001.R
import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.sdk25.coroutines.onClick

//        很多时候我们其实还是希望布局和 Activity 分开的，所以这里单独编写anko的dsl。
// DSL只能在 Activity、ViewManager（ViewGroup 的接口）、Context 这三个类的作用域范围之内使用，换句话说布局的方法都是这几个类的扩展方法。

class MainActivityUI : AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {

        verticalLayout {
            padding = dip(60)
            topPadding = dip(200)


            relativeLayout {
                relativeLayout {
                    textView("作者") {
                        id = R.id.extra
                        useSecond()
                    }.lparams(wrapContent, wrapContent) {
                        alignParentRight()
                        centerVertically()
                        rightMargin = dip(10)
                    }


                    imageView {
                        id = R.id.avatar
                        imageResource = R.drawable.abc_ic_star_black_48dp
                        scaleType = ImageView.ScaleType.FIT_XY
                    }.lparams(dip(40), dip(40)) {
                        centerVertically()
                        leftMargin = dip(10)
                    }

                    textView("歌曲名") {
                        id = R.id.title
                        usePrimary()
                    }.lparams(matchParent, wrapContent) {
                        leftOf(R.id.extra)
                        rightOf(R.id.avatar)
                        margin = dip(5)
                    }

                    textView("专辑名") {
                        id = R.id.subtitle
                        useSecond()
                    }.lparams(matchParent, wrapContent) {
                        leftOf(R.id.extra)
                        rightOf(R.id.avatar)
                        below(R.id.title)
                        leftMargin = dip(5)
                    }

                }.lparams(matchParent, dip(50))
            }


            val name = editText {
                hint = "请输入您的用户名"

            }
            button("Say Hello") {
                width = dip(50)
                onClick {
                    //                    longToast("Hello, ${name.text}!")
//                    toast("Hello, ${name.text}!")
//                    snackbar("Hello, ${name.text}!")
                    snackbar("是否弹出提醒", "弹出") {
                        toast("Hello, ${name.text}!")
                    }
                }
            }



            wOLFCustomItemCell001 {
                extra.text = "假假假"
                extra.useSecond()
                title.text = "hdnfe"
                title.usePrimary()
                subtile.text = "dfs fdsf"
                subtile.useSecond()
                avatar.imageResource = R.drawable.abc_ic_star_half_black_48dp

            }

        }.applyRecursively {
            textSizeStyle
        }

    }
}

