package com.example.kotlinlesson

import android.content.Context
import android.content.Intent

// 泛型的高级特性

// 1. 对泛型进行实化
// 那么具体该怎么写才能将泛型实化呢?首先，该函数必须是内联函数才行，也就是要用inline 关键字来修饰该函数。其次，在声明泛型的地方必须加上reified关键字来表示该泛型要进行 实化。
inline fun <reified T> getGenericType() = T::class.java

fun main() {
    val result1 = getGenericType<String>()
    val result2 = getGenericType<Int>()
    println("result1 is $result1")
    println("result2 is $result2")
}

// 2. 泛型实化的应用

inline fun <reified T> startActivity(context: Context) {
    val intent = Intent(context, T::class.java)
    context.startActivity(intent)
}

inline fun <reified T> startActivity(context: Context, block: Intent.() -> Unit) {
    val intent = Intent(context, T::class.java)
    intent.block()
    context.startActivity(intent)
}

//startActivity<TestActivity>(context)

// startActivity<TestActivity>(context) {
//    putExtra("param1", "data")
//    putExtra("param2", 123)
//}

// 3. 泛型的协变