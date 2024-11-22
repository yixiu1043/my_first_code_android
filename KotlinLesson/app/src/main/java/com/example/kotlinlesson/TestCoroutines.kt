package com.example.kotlinlesson

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

// Global.launch函数每次创建的都是一个顶层协程，这种协程当应用程序运行结束 时也会跟着一起结束。刚才的日志之所以无法打印出来，就是因为代码块中的代码还没来得及 运行，应用程序就结束了
//@OptIn(DelicateCoroutinesApi::class)
//fun main() {
//    GlobalScope.launch {
//        println("codes run in coroutine scope")
//    }
//    Thread.sleep(1000)
//}

//那么有没有什么办法能让应用程序在协程中所有代码都运行完了之后再结束呢?当然也是有 的，借助runBlocking函数就可以实现这个功能:
// runBlocking函数同样会创建一个协程的作用域，但是它可以保证在协程作用域内的所有代码 和子协程没有全部执行完之前一直阻塞当前线程。需要注意的是，runBlocking函数通常只应 该在测试环境下使用，在正式环境中使用容易产生一些性能上的问题。
//fun main() {
//    runBlocking {
//        println("codes run in coroutine scope")
//        delay(1500)
//        println("codes run in coroutine scope finished")
//    }
//}


// 创建多个协程
//fun main() {
//    runBlocking {
//        launch {
//            println("launch1")
//            delay(1000)
//            println("launch1 finished")
//        }
//        launch {
//            println("launch2")
//            delay(1000)
//            println("launch2 finished")
//        }
//    }
//}

//fun main() {
//    val start = System.currentTimeMillis()
//    runBlocking {
//        repeat(100000) {
////            launch {
////                println(".")
////            }
//            printDot()
//        }
//    }
//    val end = System.currentTimeMillis()
//    println(end - start)
//}

// Error
//suspend fun printDot() {
//    launch {
//        println(".")
//        delay(1000)
//    }
//}

// Correct
suspend fun printDot() = coroutineScope {
    launch {
        println(".")
        delay(1000)
    }
}

// 取消协程
//fun main() {
////val job = GlobalScope.launch { // 处理具体的逻辑
////}
////job.cancel()
//
//    val job = Job()
//    val scope = CoroutineScope(job)
//    scope.launch {
//        // 处理具体的逻辑
//    }
//    job.cancel()
//}

// 创建一个协程并获取它的执行结果呢?当然有， 使用async函数就可以实现。
//fun main() {
//    runBlocking {
//        val result = async {
//            5 + 5
//        }.await()
//        println(result)
//    }
//}

// await()方法在async函数代码块中的代码执行完之前会一直将当前协程阻 塞住
//fun main() {
//    runBlocking {
//        val start = System.currentTimeMillis()
//        val result1 = async {
//            delay(1000)
//            5 + 5
//        }.await()
//        val result2 = async {
//            delay(1000)
//            4 + 6
//        }.await()
//        println("result is ${result1 + result2}.")
//        val end = System.currentTimeMillis()
//        println("cost ${end - start} ms.")
//    }
//}

// 两个async函数就变成一种并 行关系
//fun main() {
//    runBlocking {
//        val start = System.currentTimeMillis()
//        val deferred1 = async {
//            delay(1000)
//            5 + 5
//        }
//        val deferred2 = async {
//            delay(1000)
//            4 + 6
//        }
//        println("result is ${deferred1.await() + deferred2.await()}.")
//        val end = System.currentTimeMillis()
//        println("cost ${end - start} milliseconds.")
//    }
//}

// 特殊的作用域构建器:withContext()函数。withContext() 函数是一个挂起函数，大体可以将它理解成async函数的一种简化版写法
fun main() {
    runBlocking {
        val result = withContext(Dispatchers.Default) {
            5 + 5
        }
        println(result)
    }
}

// 使用协程简化回调的写法
//HttpUtil.sendHttpRequest(address, object : HttpCallbackListener {
//    override fun onFinish(response: String) {
//        // 得到服务器返回的具体内容
//    }
//
//    override fun onError(e: Exception) { // 在这里对异常情况进行处理
//    }
//})
//suspend fun request(address: String): String {
//    return suspendCoroutine { continuation ->
//        HttpUtil.sendHttpRequest(address, object : HttpCallbackListener {
//            override fun onFinish(response: String) {
//                continuation.resume(response)
//            }
//
//            override fun onError(e: Exception) {
//                continuation.resumeWithException(e)
//            }
//        })
//    }
//}

//suspend fun getBaiduResponse() {
//    try {
//        val response = request("https://www.baidu.com/")
//        // 对服务器响应的数据进行处理
//    } catch (e: Exception) {
//        // 对异常情况进行处理
//    }
//}