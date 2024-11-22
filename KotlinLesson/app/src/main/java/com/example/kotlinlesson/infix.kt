package com.example.kotlinlesson

// infix函数的语法规则并不复杂，上述代码其实就是调用的" Hello Kotlin "这个字符串的beginsWith()函数，并传入了一个"Hello"字符串作为参数。但是 infix函数允许我们将函数调用时的小数点、括号等计算机相关的语法去掉，从而使用一种更 接近英语的语法来编写程序，让代码看起来更加具有可读性。
// 另外，infix函数由于其语法糖格式的特殊性，有两个比较严格的限制:首先，infix函数是 不能定义成顶层函数的，它必须是某个类的成员函数，可以使用扩展函数的方式将它定义到某 个类当中;其次，infix函数必须接收且只能接收一个参数，至于参数类型是没有限制的。只 有同时满足这两点，infix函数的语法糖才具备使用的条件，你可以思考一下是不是这个道 理。
infix fun String.beginsWith(prefix: String) = startsWith(prefix)
infix fun <T> Collection<T>.has(element: T) = contains(element)
infix fun <A, B> A.with(that: B): Pair<A, B> = Pair(this, that)

fun main() {
    if ("Hello Kotlin".startsWith("Hello")) { // 处理具体的逻辑
        println("YES")
    }
    if ("Hello Kotlin" beginsWith "Hello") {
        println("YES")
    }

    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    if (list.contains("Banana")) {
        // 处理具体的逻辑
    }

    if (list has "Banana") {
        // 处理具体的逻辑
    }

    val map = mapOf("Apple" with 1, "Banana" with 2, "Orange" with 3, "Pear" with 4,
        "Grape" with 5)

    println(map)
}

