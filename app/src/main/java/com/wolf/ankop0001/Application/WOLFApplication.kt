package com.wolf.ankop0001.Application

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.tencent.bugly.Bugly
import com.tencent.bugly.crashreport.CrashReport


class WOLFApplication : Application() {
//    用于向Bugly提交bug时的用户追踪，请自行修改为获取登录id的方法。
    var userName: String = "Test001"


    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        //此处替换自己的app id
        Bugly.init(applicationContext, "baa0bb0eb7", false)
        CrashReport.setUserId(userName)



    }


}