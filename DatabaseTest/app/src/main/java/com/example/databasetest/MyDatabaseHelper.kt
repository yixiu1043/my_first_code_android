package com.example.databasetest

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDatabaseHelper(private val context: Context, name: String, version: Int) : SQLiteOpenHelper(context, name, null, version) {
    private val createBook = "create table Book (" +
            " id integer primary key autoincrement," +
            "author text," +
            "price real," +
            "pages integer," +
            "name text," +
            "category_id integer)"

    private val createCategory = "create table Category (" +
            "id integer primary key autoincrement," +
            "category_name text," +
            "category_code integer)"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(createBook)
        db?.execSQL(createCategory)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
//        db?.execSQL("drop table if exists Book")
//        db?.execSQL("drop table if exists Category")
//        onCreate(db)

        // 升级数据库的最佳写法
        if (oldVersion <= 1) {
            db?.execSQL(createCategory)
        }

        if (oldVersion <= 2) {
            db?.execSQL("alter table Book add column category_id integer")
        }
        // 每当升级一个数据库版本的时候，onUpgrade()方法里都一 定要写一个相应的if判断语句。为什么要这么做呢?这是为了保证App在跨版本升级的时候， 每一次的数据库修改都能被全部执行。比如用户当前是从第2版升级到第3版，那么只有第二条 判断语句会执行，而如果用户是直接从第1版升级到第3版，那么两条判断语句都会执行。使用 这种方式来维护数据库的升级，不管版本怎样更新，都可以保证数据库的表结构是最新的，而 且表中的数据完全不会丢失。

    }

}