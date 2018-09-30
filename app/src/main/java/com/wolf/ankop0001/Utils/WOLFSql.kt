package com.wolf.ankop0001.Utils

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.ManagedSQLiteOpenHelper

/**
 * 实现ManagedSQLiteOpenHelper。
 * 用同步的方法使不同的线程不能生成多个实例。
 * 为上下文创建一个扩展属性，这样任何需要Context的类都可以直接访问数据库。
 *
 * 需要使用时，使用 database.use { ... }，
 * 大括号内是SQLiteDatabase类的扩展函数，仅在这块代码执行前，将此表打开。而在代码执行结束后将其关闭。
 *
 */


class WOLFSql(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "wolfdb") {

    companion object {
        private var instance: WOLFSql? = null
//      用同步的方法使不同的线程不能生成多个实例。
        @Synchronized
        fun getInstance(ctx: Context): WOLFSql {
            if (instance == null) {
                instance = WOLFSql(ctx.applicationContext)
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        //这里可以编写初始化，创建表结构
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        //这里可以自定义每次版本变更的操作
    }

}

// 为上下文创建一个扩展属性，这样任何需要Context的类都可以直接访问数据库。
val Context.database: WOLFSql
    get() = WOLFSql.getInstance(applicationContext)