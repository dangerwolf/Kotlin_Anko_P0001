# Kotlin_Anko_P0001
wolf 自用基于Anko的Kotlin模板


[TOC]




# gradle环境配置


## Project:
根据实际情况，添加最新的anko版本号。

在`buildscript`中添加如下：
~~~
ext.anko_version = '0.10.6'
~~~



## Module:app

### fresco图片缓存

在`dependencies`中添加如下：

~~~

    implementation 'com.facebook.fresco:fresco:1.9.0'  //图片缓存 https://github.com/facebook/fresco

    // 在 API < 14 上的机器支持 WebP 时，需要添加
    implementation 'com.facebook.fresco:animated-base-support:0.12.0'

    // 支持 GIF 动图，需要添加
    implementation 'com.facebook.fresco:animated-gif:0.12.0'

    // 支持 WebP （静态图+动图），需要添加
    implementation 'com.facebook.fresco:animated-webp:0.12.0'
    implementation 'com.facebook.fresco:webpsupport:0.12.0'

    // 仅支持 WebP 静态图，需要添加
    //compile 'com.facebook.fresco:webpsupport:0.12.0'
~~~


### 腾讯Bugly
在`dependencies`中添加如下：
~~~
    implementation 'com.tencent.bugly:crashreport:latest.release'
    //其中latest.release指代最新Bugly SDK版本号，也可以指定明确的版本号，例如2.2.0
~~~


### Anko
在`dependencies`中添加如下：
~~~

    // Anko Commons
    implementation "org.jetbrains.anko:anko-commons:$anko_version"

    // Anko Layouts
    implementation "org.jetbrains.anko:anko-sdk25:$anko_version"
    // sdk15, sdk19, sdk21, sdk23 are also available
    implementation "org.jetbrains.anko:anko-appcompat-v7:$anko_version"

    // Coroutine listeners for Anko Layouts
    implementation "org.jetbrains.anko:anko-sdk25-coroutines:$anko_version"
    implementation "org.jetbrains.anko:anko-appcompat-v7-coroutines:$anko_version"

    // Anko SQLite
    implementation "org.jetbrains.anko:anko-sqlite:$anko_version"

    // Appcompat-v7 (only Anko Commons)
    implementation "org.jetbrains.anko:anko-appcompat-v7-commons:$anko_version"

    // Appcompat-v7 (Anko Layouts)
    implementation "org.jetbrains.anko:anko-appcompat-v7:$anko_version"
    implementation "org.jetbrains.anko:anko-coroutines:$anko_version"

    // CardView-v7
    implementation "org.jetbrains.anko:anko-cardview-v7:$anko_version"

    // Design
    implementation "org.jetbrains.anko:anko-design:$anko_version"
    implementation "org.jetbrains.anko:anko-design-coroutines:$anko_version"

    // GridLayout-v7
    implementation "org.jetbrains.anko:anko-gridlayout-v7:$anko_version"

    // Percent
    implementation "org.jetbrains.anko:anko-percent:$anko_version"

    // RecyclerView-v7
    implementation "org.jetbrains.anko:anko-recyclerview-v7:$anko_version"
    implementation "org.jetbrains.anko:anko-recyclerview-v7-coroutines:$anko_version"

    // Support-v4 (only Anko Commons)
    implementation "org.jetbrains.anko:anko-support-v4-commons:$anko_version"

    // Support-v4 (Anko Layouts)
    implementation "org.jetbrains.anko:anko-support-v4:$anko_version"

    // ConstraintLayout
    implementation "org.jetbrains.anko:anko-constraint-layout:$anko_version"
~~~

##proguard
在`proguard-rules.pro`中添加如下：

~~~
-dontwarn com.tencent.bugly.**
-keep public class com.tencent.bugly.**{*;}

-keep class android.support.**{*;}
~~~

## sdk位置

根据实际情况，在`local.properties`中修改如下：

~~~
sdk.dir=/Users/SLB/Library/Android/sdk
~~~


# 目录结构设置
根据个人使用习惯，在`app/java/com.wolf.ankop001`中添加如下文件夹

## Activity
用于存放`Activity`文件。

## Application
用于存放自定义的`Application`文件。

例如：初始化Bugly用的自定义`WOLFApplication.kt`

~~~kotlin
class WOLFApplication : Application() {
//    用于向Bugly提交bug时的用户追踪，请自行修改为获取登录id的方法。
    var userName: String = "Test001"

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
//此处替换自己的app id
        Bugly.init(getApplicationContext(), "baa0bb0eb7", false)
        CrashReport.setUserId(userName)
    }
}
~~~


## Bean
用于存放`Bean`文件。

## Fragment
用于存放`Fragment`文件。

## Model
用于存放`Model`文件。

## Presenter
用于存放`Presenter`文件。

## Utils
用于存放`Utils`文件。

## View
用于存放`View`文件。


# AndroidMainfest.xml

根据实际需要，添加相关app权限。
~~~xml
    <!-- To auto-complete the email text field in the login form with the user's emails -->
    <uses-permission android:name="android.permission.GET_ACCOUNTS" />
    <uses-permission android:name="android.permission.READ_PROFILE" />
    <uses-permission android:name="android.permission.READ_CONTACTS" />

    <!-- 网络访问权限 -->
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.READ_PHONE_STATE" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
    <uses-permission android:name="android.permission.READ_LOGS" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.REQUEST_INSTALL_PACKAGES" />
~~~

在`<application>`中添加自定义的`Application`文件：
~~~
android:name=".Application.WOLFApplication"
~~~

在`<application>`中添加一个`activity`用于Bugly的配置：
~~~
        <activity
            android:name="com.tencent.bugly.beta.ui.BetaActivity"
            android:configChanges="keyboardHidden|orientation|screenSize|locale"
            android:theme="@android:style/Theme.Translucent" />

        <provider
            android:name="android.support.v4.content.FileProvider"
            android:authorities="${applicationId}.fileProvider"
            android:exported="false"
            android:grantUriPermissions="true">
            <meta-data
                android:name="android.support.FILE_PROVIDER_PATHS"
                android:resource="@xml/provider_paths" />
        </provider>
~~~