package com.example.kotlinlesson

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.showSnackbar(text: String, duration: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this, text, duration).show()
}

fun View.showSnackbar(resId: Int, duration: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this, resId, duration).show()
}

fun View.showSnackbar(
    text: String, actionText: String? = null,
    duration: Int = Snackbar.LENGTH_SHORT, block: (() -> Unit)? = null
) {
    val snackbar = Snackbar.make(this, text, duration)
    if (actionText != null && block != null) {
        snackbar.setAction(actionText) {
            block()
        }
    }
    snackbar.show()
}


// 支持setAction()方法
fun View.showSnackbar(
    resId: Int, actionResId: Int? = null,
    duration: Int = Snackbar.LENGTH_SHORT, block: (() -> Unit)? = null
) {
    val snackbar = Snackbar.make(this, resId, duration)
    if (actionResId != null && block != null) {
        snackbar.setAction(actionResId) {
            block()
        }
    }
    snackbar.show()
}

fun main() {
//    Snackbar.make(view, "This is Snackbar", Snackbar.LENGTH_SHORT)
//        .setAction("Action") {
//// 处理具体的逻辑 }
//            .show()

    view.showSnackbar("This is Snackbar")

    view.showSnackbar("This is Snackbar", "Action") { // 处理具体的逻辑
    }
}