package com.wolf.ankop0001.View


import android.app.ProgressDialog
import android.widget.EditText
import android.widget.ImageView
import com.wolf.ankop0001.Activity.MainActivity
import com.wolf.ankop0001.Activity.SplashActivity
import com.wolf.ankop0001.R
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.Appcompat
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.sdk25.coroutines.onClick
import android.widget.ProgressBar
import org.jetbrains.anko.custom.customView
import org.jetbrains.anko.sdk25.coroutines.onSeekBarChangeListener


//        很多时候我们其实还是希望布局和 Activity 分开的，所以这里单独编写anko的dsl。
// DSL只能在 Activity、ViewManager（ViewGroup 的接口）、Context 这三个类的作用域范围之内使用，换句话说布局的方法都是这几个类的扩展方法。

class MainActivityUI : AnkoComponent<MainActivity> {

    var tempStr = ""
    lateinit var tempEditText: EditText
    lateinit var dialog: ProgressDialog
//    lateinit var progressBar: ProgressBar

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
//                        longToast("Hello, ${name.text}!")
                        startActivity<SplashActivity>("from" to "已传参", SplashActivity().tempStr to "ddd")
                    }
                }
            }

            button("alert"){
                onClick {
//                    alert(Appcompat, "这是提醒信息").show()
                    alert("这里是描述的消息", "这里是对话框的标题") {
                        customView {
                            tempEditText =  editText()
                        }
                        yesButton {toast("您输入了：${tempEditText.text}") }
                        noButton {toast("点击了否定操作按钮")}
//                        positiveButton("肯定操作"){toast("您输入了：${tempEditText.text}") }
//                        negativeButton("否定操作"){toast("点击了否定操作按钮")}
                    }.show()
                }

            }



            button("加载器"){
                onClick{
                    selector("想要选择哪一种加载器", listOf("水平","环形","bar")) { dialogInterface, index ->
                        when (index) {
                            0 -> {
                                dialog = progressDialog("正在努力加载页面", "请稍候")
                                dialog.show()
                                dialog.progress = 57
                            }
                            1 -> {
                                dialog = indeterminateProgressDialog("正在努力加载页面", "请稍候")
                                dialog.show()
                            }
                            2 -> {

                            }
                        }
                    }
                }
            }


            seekBar {
                onSeekBarChangeListener {
                    onProgressChanged { seekBar, progress, fromUser ->

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

