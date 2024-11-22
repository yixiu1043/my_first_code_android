package com.example.kotlinlesson

import android.content.Context
import android.widget.Toast

// 简化Toast的用法

//fun String.showToast(context: Context) {
//    Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
//}
//fun Int.showToast(context: Context) {
//    Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
//}

fun String.showToast(context: Context, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, this, duration).show()
}
fun Int.showToast(context: Context, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, this, duration).show()
}

fun main() {
//    Toast.makeText(context, "This is Toast", Toast.LENGTH_SHORT).show()
//    "This is Toast".showToast(context)
//    R.string.app_name.showToast(context)

    "This is Toast".showToast(context, Toast.LENGTH_LONG)
}