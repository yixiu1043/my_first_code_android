package com.example.broadcasttest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast


//动态注册的BroadcastReceiver可以自由地控制注册与注销，在灵活性方面有很大的优势。但 是它存在着一个缺点，即必须在程序启动之后才能接收广播，因为注册的逻辑是写在 onCreate()方法中的。那么有没有什么办法可以让程序在未启动的情况下也能接收广播呢? 这就需要使用静态注册的方式了。
//静态注册实现开机启动
class BootCompleteReceivere : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        Toast.makeText(context, "Boot Complete" ,Toast.LENGTH_SHORT).show()
    }
}