package com.example.helloworld

fun main() {
    println("Hello Kotlin")
    // 标准函数with、run和apply
    // 1. with函数接收两个参数:第一个参数可以是一个任意类型的对 象，第二个参数是一个Lambda表达式。with函数会在Lambda表达式中提供第一个参数对象 的上下文，并使用Lambda表达式中的最后一行代码作为返回值返回
    // 比如有一个水果列表，现在我们想吃完所有水果，并将结果打印出来
//    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
//    val builder = StringBuilder()
//    builder.append("Start eating fruit. \n")
//    for (fruit in list) {
//        builder.append(fruit).append("\n")
//    }
//    builder.append("Ate all fruits.")
//    val result = builder.toString()
//    println(result)

//    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
//    val result = with(StringBuilder()) {
//        append("Start eating fruit. \n")
//        for (fruit in list) {
//            append(fruit).append("\n")
//        }
//        append("Ate all fruits.")
//        toString()
//    }
//    println(result)

    // 2. run函数。run函数的用法和使用场景其实和 with函数是非常类似的，只是稍微做了一些语法改动而已。首先run函数通常不会直接调用， 而是要在某个对象的基础上调用;其次run函数只接收一个Lambda参数，并且会在Lambda表 达式中提供调用对象的上下文。其他方面和with函数是一样的，包括也会使用Lambda表达式 中的最后一行代码作为返回值返回
//    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
//    val result = StringBuilder().run {
//        append("Start eating fruit. \n")
//        for (fruit in list) {
//            append(fruit).append("\n")
//        }
//        append("Ate all fruits.")
//        toString()
//    }
//    println(result)

    // 3. apply函数和run函数也是极其类似的，都要在某 个对象上调用，并且只接收一个Lambda参数，也会在Lambda表达式中提供调用对象的上下 文，但是apply函数无法指定返回值，而是会自动返回调用对象本身
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    val result = StringBuilder().apply {
        append("Start eating fruits.\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("Ate all fruits.")
    }
    println(result.toString())
}

// 3.7.2 定义静态方法
// java
//public class Util {
//    public static void doAction() {
//        System.out.println("do action");
//    } }

// Kotlin却极度弱化了静态方法这个概念，在Kotlin中就非常推荐使用单例类的方式来实现
//object Util {
//    fun doAction() {
//        println("do action")
//    }
//}

// 不过，使用单例类的写法会将整个类中的所有方法全部变成类似于静态方法的调用方式，而如 果我们只是希望让类中的某一个方法变成静态方法的调用方式该怎么办呢?这个时候就可以使 用刚刚在最佳实践环节用到的companion object了

//class Util {
//    fun doAction1() {
//        println("do action1")
//    }
//
//    companion object {
//        fun doAction2() {
//            println("do action2")
//        }
//    }
//}

// 如果你确确实实需要定义真正的静态方法， Kotlin仍然提供了两种实现方式:注解和顶层 方法。
// 1. 注解 @JvmStatic注解
// 如果我们给单例类或companion object中的方 法加上@JvmStatic注解，那么Kotlin编译器就会将这些方法编译成真正的静态方法，
class Util {
    fun doAction1() {
        println("do action1")
    }
    // @JvmStatic注解只能加在单例类或companion object中的方法上
    companion object {
        @JvmStatic
        fun doAction2() {
            println("do action2")
        }
    }
}