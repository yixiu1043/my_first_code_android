package com.example.networktest

import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okio.IOException
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

object HttpUtil {
    //    fun sendHttpRequest(address: String): String {
//        var connection: HttpURLConnection? = null
//        try {
//            val response = StringBuilder()
//            val url = URL(address)
//            connection = url.openConnection() as HttpURLConnection
//            connection.connectTimeout = 8000
//            connection.readTimeout = 8000
//            val input = connection.inputStream
//            val reader = BufferedReader(InputStreamReader(input))
//            reader.use {
//                reader.forEachLine {
//                    response.append(it)
//                } }
//            return response.toString()
//        } catch (e: Exception) {
//            e.printStackTrace()
//            return e.message.toString()
//        } finally {
//            connection?.disconnect()
//        }
//    }
    fun sendHttpRequest(address: String, listener: HttpCallbackListener) {
        thread {
            var connection: HttpURLConnection? = null
            try {
                val response = StringBuilder()
                val url = URL(address)
                connection = url.openConnection() as HttpURLConnection
                connection.connectTimeout = 8000
                connection.readTimeout = 8000
                val input = connection.inputStream
                val reader = BufferedReader(InputStreamReader(input))
                reader.use {
                    reader.forEachLine {
                        response.append(it)
                    }
                }
                // 回调onFinish()方法
                listener.onFinish(response.toString())
            } catch (e: Exception) {
                e.printStackTrace() // 回调onError()方法 listener.onError(e)
            } finally {
                connection?.disconnect()
            }
        }
    }

    fun sendOkHttpRequest(address: String, callback: okhttp3.Callback) {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(address)
            .build()
        client.newCall(request).enqueue(callback)
    }

}

fun main() {
    HttpUtil.sendHttpRequest("address", object : HttpCallbackListener {
        override fun onFinish(response: String) {
            // 得到服务器返回的具体内容
        }

        override fun onError(e: Exception) { // 在这里对异常情况进行处理
        }
    })

    HttpUtil.sendOkHttpRequest("address", object : Callback {
        override fun onResponse(call: Call, response: Response) {
            // 得到服务器返回的具体内容
            val responseData = response.body?.string()
        }
        override fun onFailure(call: Call, e: IOException) { // 在这里对异常情况进行处理
        }
    })
}



