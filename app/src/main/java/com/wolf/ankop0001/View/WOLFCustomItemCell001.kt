package com.wolf.ankop0001.View

import android.content.Context

import android.util.AttributeSet
import android.view.ViewManager
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.wolf.ankop0001.R
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.internals.AnkoInternals




open class WOLFCustomItemCell001 : RelativeLayout,AnkoLogger {

    companion object {                    // 这里定义了控件的ID，方面在Activity中根据ID找控件
        val extraId = 1
        val titleId = 2
        val subtitleId = 3
        val avatarId = 4
    }



    var _extra = "作者"
    var _title = "歌曲名"
    var _subtitle = "专辑名"
    var _avatar: Int = R.drawable.abc_ic_star_black_48dp

    lateinit var extra: TextView
    lateinit var title: TextView
    lateinit var subtile: TextView
    lateinit var avatar: ImageView




    constructor(context: Context?) : this(context,null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs,0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    fun init() = AnkoContext.createDelegate(this).apply {


        relativeLayout {
            relativeLayout {
                extra = textView(_extra) {
                    id = extraId
                }.lparams(wrapContent, wrapContent) {
                    alignParentRight()
                    centerVertically()
                    rightMargin = dip(10)
                }


                avatar = imageView {
                    id = avatarId
                    imageResource = _avatar
                    scaleType = ImageView.ScaleType.FIT_XY
                }.lparams(dip(40), dip(40)) {
                    centerVertically()
                    leftMargin = dip(10)
                }

                title = textView(_title) {
                    id = titleId
                }.lparams(matchParent, wrapContent) {
                    leftOf(extraId)
                    rightOf(avatarId)
                    margin = dip(5)
                }

                subtile = textView(_subtitle) {
                    id = subtitleId
                }.lparams(matchParent, wrapContent) {
                    leftOf(extraId)
                    rightOf(avatarId)
                    below(titleId)
                    leftMargin = dip(5)
                }

            }.lparams(matchParent, dip(50))
        }
        info("the extra id is :" + extra.id)
        info("the avatar id is :" + avatar.id)
    }




}

inline fun ViewManager.wOLFCustomItemCell001(
        ctx: Context = AnkoInternals.getContext(this),
        theme: Int = 0,
        init :WOLFCustomItemCell001.() -> Unit
):WOLFCustomItemCell001{
    return ankoView({WOLFCustomItemCell001(ctx)},theme,init)
}

inline  fun <T:WOLFCustomItemCell001> T.extra(
        init:TextView.() -> Unit
):T {
    init()
    return this
}

inline  fun <T:WOLFCustomItemCell001> T.title(
        init:TextView.() -> Unit
):T {
    init()
    return this
}

inline  fun <T:WOLFCustomItemCell001> T.subtitle(
        init:TextView.() -> Unit
):T {
    init()
    return this
}

inline  fun <T:WOLFCustomItemCell001> T.avatar(
        init:ImageView.() -> Unit
):T {
    init()
    return this
}
