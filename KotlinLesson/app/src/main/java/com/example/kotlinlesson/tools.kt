package com.example.kotlinlesson

import kotlin.math.max

fun main() {
    // 两个数比大小
//    val a = 10
//    val b = 15
//    val larger = max(a, b)

    // 如果我们想要在3个数中获取最大的那个数
//    val a = 10
//    val b = 15
//    val c = 5
//    val largest = max(max(a, b), c)
    // 如果是4个数、5个数呢？

    val a = 10
    val b = 15
    val c = 5
    val largest = max(a, b, c)
}

// vararg关键字，它允许方法接收任意多个同 等类型的参数，正好满足我们这里的需求
fun max(vararg nums: Int): Int {
    var maxNum = Int.MIN_VALUE
    for (num in nums) {
        maxNum = kotlin.math.max(maxNum, num)
    }
    return maxNum
}