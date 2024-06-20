package com.example.myapplication

import kotlin.math.max


fun main() {
    val res = largerNumber(1, 2)
    println("max = $res")
    println("Hello kotlin")
    val num = 10
    checkNumber(num)
}

fun largerNumber(num1: Int, num2: Int): Int {
    return max(num1, num2)
}

// 1. 变量
// val(value的简写)用来声明一个不可变的变量
// var(variable的简写)用来声明一个可变的变量


// 2. 函数
// Kotlin函数的语法糖
// 当一个函数中只有一行代码时，Kotlin允许我们不必编写函数体，可以直接将唯一的一行代码写 在函数定义的尾部，中间用等号连接即可
fun largerNumber1(num1: Int, num2: Int): Int = max(num1, num2)

// 由于Kotlin出色的类型推导机制，函数返回的必然也是一个Int值，这样就不用再显式地声明返回值 类型了
fun largerNumber2(num1: Int, num2: Int) = max(num1, num2)

// 3. 程序的逻辑控制
// Kotlin中的条件语句主要有两种实现方式:if和when。

// 3.1 Kotlin中的if语句和Java中的if语句几乎没有任何区别
fun largerNumber3(num1: Int, num2: Int): Int {
    var value = 0
    if (num1 > num2) {
        value = num1
    } else {
        value = num2
    }
    return value
}

// Kotlin中的if语句相比于Java有一个额外的功能，它是可以有返回值的，返回值就是if语句每 一个条件中最后一行代码的返回值
fun largerNumber4(num1: Int, num2: Int): Int {
    var value = if (num1 > num2) {
        num1
    } else {
        num2
    }
    return value
}

// 精简
fun largerNumber5(num1: Int, num2: Int): Int {
    return if (num1 > num2) {
        num1
    } else {
        num2
    }
}

// 再精简
fun largerNumber6(num1: Int, num2: Int) = if (num1 > num2) {
    num1
} else {
    num2
}

// 再再精简
fun largerNumber7(num1: Int, num2: Int) = if (num1 > num2) num1 else num2

// 3.2 when条件语句
// Kotlin中的when语句有点类似于Java中的switch语句，但它又远比switch语句强大得多。
// 编写一个查询考试成绩的功能，输入一个学生的姓名，返回该学生考试的分数。
fun getScore(name: String) = if (name == "Tom") {
    86
} else if (name == "Jim") {
    77
} else if (name == "Jack") {
    95
} else if (name == "Lily") {
    100
} else {
    0
}

// 当你的判断条件非常多的时候，就是应该考虑使用when语句的时候，现在我们 将代码改成如下写法:
fun getScore1(name: String) = when (name) {
    "Tom" -> 86
    "Jim" -> 77
    "Jack" -> 95
    "Lily" -> 100
    else -> 0
}

// when语句允许传入一个任意类型的参数，然后可以在when的结构体中定义一系列的条件，格式是:
// 匹配值 -> { 执行逻辑 }
// 当你的执行逻辑只有一行代码时，{ }可以省略。
// 除了精确匹配之外，when语句还允许进行类型匹配。什么是类型匹配呢?这里我再举个例子。 定义一个checkNumber()函数，如下所示:
fun checkNumber(num: Number) {
    when (num) {
        is Int -> println("number is Int")
        is Double -> println("number is Double")
        else -> println("number not support")
    }
}

// when语句的基本用法就是这些，但其实when语句还有一种不带参数的用法，虽然这种用法可能 不太常用，但有的时候却能发挥很强的扩展性。
fun getScore2(name: String) = when {
    name == "Tom" -> 86
    name == "Jim" -> 77
    name == "Jack" -> 95
    name == "Lily" -> 100
    else -> 0
}

// 4. 循环语句
// Kotlin也提 供了while循环和for循环
// Kotlin在for循环方面做了很大幅度的修改，Java中最常用的for-i循环在Kotlin中直接被舍弃 了，而Java中另一种for-each循环则被Kotlin进行了大幅度的加强，变成了for-in循环，所 以我们只需要学习for-in循环的用法就可以了。

// 4.1 区间
// 在开始学习for-in循环之前，还得先向你普及一个区间的概念，因为这也是Java中没有的东 西。我们可以使用如下Kotlin代码来表示一个区间:
val range1 = 0..10

// 上述代码表示创建了一个0 到10的区间，包含0和10，双端闭区间
// ..是创建两端闭区间的关键字

// 4.2 for-in循环
fun testForIn1() {
    for (i in 0..10) {
        println(i)
    }
}

// 4.3 Kotlin中可以使用until关键字来创建一个左闭右开的区间
val range2 = 0 until 10

fun testForIn2() {
    for (i in 0 until 10) {
        println(i)
    }
}

// 4.4 使用step跳过区间内的元素
// 默认情况下，for-in循环每次执行循环时会在区间范围内递增1，相当于Java for-i循环中 i++的效果，而如果你想跳过其中的一些元素，可以使用step关键字:
fun testForIn3() {
    for (i in 0 until 10 step 2) {
        println(i)
    }
}
// 上述代码表示在遍历[0, 10)这个区间的时候，每次执行循环都会在区间范围内递增2，相当于 for-i循环中i = i + 2的效果

// 4.5 创建一个降序的区间，可以使用downTo 关键字
fun testForIn4() {
    for (i in 10 downTo 1) {
        println(i)
    }
}

// 5. 类与对象
// 5.1 对象
class Person {
    var name = ""
    var age = 0
    fun eat() {
        println(name + " is eating. He is " + age + " years old.")
    }
}
// 5.2 继承
// Kotlin不同的 地方，在Kotlin中任何一个非抽象类默认都是不可以被继承的，相当于Java中给类声明了final 关键字。之所以这么设计，其实和val关键字的原因是差不多的，因为类和变量一样，最好都是 不可变的，而一个类允许被继承的话，它无法预知子类会如何实现，因此可能就会存在一些未 知的风险。
// Kotlin在设计的时候遵循了这条编程规范，默认所有非抽象类都是不可以被继承的。

// 5.2.1 加上open关键字就可以被继承
open class Person1 {
    var name = ""
    var age = 0
    fun eat() {
        println(name + " is eating. He is " + age + " years old.")
    }
}

// 5.2.2 在Java中继承的关键字是extends，而在Kotlin 中变成了一个冒号
class Student : Person1() {
    var sno = ""
    var grade = 0
}

// 为什么Person类的后面要加上一对括 号呢?Java中继承的时候好像并不需要括号。
// 对于初学Kotlin的人来讲，这对括号确实挺难理解 的，也可能是Kotlin在这方面设计得太复杂了，因为它还涉及主构造函数、次构造函数等方面的 知识

// 5.3 主构造函数
// 每个类默认都会有一个不带参数的主构造函数，当然
//你也可以显式地给它指明参数。主构造函数的特点是没有函数体，直接定义在类名的后面即
//可。
class Student2(val sno: String, val grade: Int) : Person1() {

}

// 这里我们将学号和年级这两个字段都放到了主构造函数当中，这就表明在对Student类进行实 例化的时候，必须传入构造函数中要求的所有参数。
val student = Student2("a123", 5)

// 由 于构造函数中的参数是在创建实例的时候传入的，不像之前的写法那样还得重新赋值，因此我 们可以将参数全部声明成val

// 5.3.1 init结构体
// 构造函数没有函数体，如果我想在主构造函数中编写一些逻辑，该怎么办呢? Kotlin给我们提供了一个init结构体，所有主构造函数中的逻辑都可以写在里面:
class Student3(val sno: String, val grade: Int) : Person1() {
    init {
        println("sno is " + sno)
        println("grade is " + grade)
    }
}

// 5.4 次构造函数
// 任何一个类只能有一个主构造函数，但是可以有多个次构造函数。次构造函数也可以用于实例化一个类，这一点和主构造函数没有什么不同，只不过它是有函数体的。
// Kotlin规定，当一个类既有主构造函数又有次构造函数时，所有的次构造函数都必须调用主构造 函数(包括间接调用)。

open class Person2(val name: String, val age: Int) {
}

class Student4(val sno: String, val grade: Int, name: String, age: Int) :
    Person2(name, age) {
    constructor(name: String, age: Int) : this("", 0, name, age) {
    }

    constructor() : this("", 0) {
    }
}

//次构造函数是通过constructor关键字来定义的，这里我们定义了两个次构造函数:第一个次 构造函数接收name和age参数，然后它又通过this关键字调用了主构造函数，并将sno和 grade这两个参数赋值成初始值;第二个次构造函数不接收任何参数，它通过this关键字调用 了我们刚才定义的第一个次构造函数，并将name和age参数也赋值成初始值，由于第二个次构 造函数间接调用了主构造函数，因此这仍然是合法的。
//那么现在我们就拥有了3种方式来对Student类进行实体化，分别是通过不带参数的构造函数、 通过带两个参数的构造函数和通过带4个参数的构造函数，对应代码如下所示:
val student1 = Student4()
val student2 = Student4("Jack", 19)
val student3 = Student4("a123", 5, "Jack", 19)

// 那么接下来我们就再来看一种非常特殊的情况:类中只有次构造函数，没有主构造函数。这种 情况真的十分少见，但在Kotlin中是允许的。
class Student5 : Person2 {
    constructor(name: String, age: Int) : super(name, age) {
    }
}
//注意这里的代码变化，首先Student类的后面没有显式地定义主构造函数，同时又因为定义了 次构造函数，所以现在Student类是没有主构造函数的。那么既然没有主构造函数，继承 Person类的时候也就不需要再加上括号了。
// 另外，由于没有主构造函数，次构造函数只能直接调用父类的构造函数，上述代码也是将this 关键字换成了super关键字，这部分就很好理解了

// 5.5 接口
// 接口是用于实现多态编程的重要组成部分。我们都知道，Java是单继承结构的语言，任何一个类最多只能继承一个父类，但是却可以实现任意多个接口，Kotlin也是如此。
interface Study {
    fun readBooks()
    fun doHomework()
}

class Student6(name: String, age: Int) : Person2(name, age), Study {
    override fun readBooks() {
        println(name + " is reading.")
    }

    override fun doHomework() {
        println(name + " is doing homework.")
    }
}

// 熟悉Java的人一定知道，Java中继承使用的关键字是extends，实现接口使用的关键字是 implements，而Kotlin中统一使用冒号，中间用逗号进行分隔。

fun doStudy() {
    val student = Student6("Jack", 19)
    student.readBooks()
    student.doHomework()
}

// 5.6 数据类和单例类
// 数据类通常需要重写equals()、hashCode()、toString()这几个方法。其中，equals() 方法用于判断两个数据类是否相等。hashCode()方法作为equals()的配套方法，也需要一起 重写，否则会导致HashMap、HashSet等hash相关的系统类无法正常工作。toString()方法 用于提供更清晰的输入日志，否则一个数据类默认打印出来的就是一行内存地址。

// 5.6.1 数据类

// data关键字
data class Cellphone(val brand: String, val price: Double)
// 奇的地方就在于data这个关键字，当在一个类前 面声明了data关键字时，就表明你希望这个类是一个数据类，Kotlin会根据主构造函数中的参 数帮你将equals()、hashCode()、toString()等固定且无实际逻辑意义的方法自动生成， 从而大大减少了开发的工作量。
// 另外，当一个类中没有任何代码时，还可以将尾部的大括号省略。

fun testDataClass() {
    val cellphone1 = Cellphone("Samsung", 1299.99)
    val cellphone2 = Cellphone("Samsung", 1299.99)
    println(cellphone1)
    println("cellphone1 equals cellphone2 " + (cellphone1 == cellphone2))
}

// 5.6.2 单例类
// object关键字
object Singleton {
    fun singletonTest() {
        println("singletonTest is called.")
    }
}

fun testSingletonClass() {
    Singleton.singletonTest()
}

// 6. Lambda编程
// Kotlin从第一个版本开始就支持了Lambda编程，并且Kotlin中的Lambda功能极为强大，我 甚至认为Lambda才是Kotlin的灵魂所在。

// 6.1 集合的创建与遍历
// 6.1.1 创建的是一个不可变的集合
val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
fun testList() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    for (fruit in list) {
        println(fruit)
    }
}

// listOf()函数创建的是一个不可变的集合, 可变的集合指的就是该集合只能用于读取， 我们无法对集合进行添加、修改或删除操作。
// 6.1.2 创建一个可变的集合

fun testMutableList() {
    val list = mutableListOf("Apple", "Banana", "Orange", "Pear", "Grape")
    list.add("Watermelon")
    for (fruit in list) {
        println(fruit)
    }
}

// 6.1.3 Set集合
// Set集合中是不可以存放重复元素的，如果存放了多个相同的元素，只会保留其中一 份，
fun testSet() {
    val set = setOf("Apple", "Banana", "Orange", "Pear", "Grape")
    for (fruit in set) {
        println(fruit)
    }
}

// 6.1.4 Map集合
fun testMap() {
    val map = HashMap<String, Int>()
    map["Apple"] = 1
    map["Banana"] = 2
    map["Orange"] = 3
    map["Pear"] = 4
    map["Grape"] = 5
}

// Kotlin毫无疑问地提供了一对mapOf()和 mutableMapOf()函数来继续简化Map的用法
fun testMap1() {
    val map = mapOf("Apple" to 1, "Banana" to 2, "Orange" to 3, "Pear" to 4, "Grape" to 5)
}

// 其实to并不是关键字，而 是一个infix函数

fun testMap2() {
    val map = mapOf("Apple" to 1, "Banana" to 2, "Orange" to 3, "Pear" to 4, "Grape" to 5)
    for ((fruit, number) in map) {
        println("fruit is " + fruit + ", number is " + number)
    }
}

// 6.2 集合的函数式API
// maxBy
fun testListApi() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape", "Watermelon")
    val maxLengthFruit = list.maxBy { it.length }
    println("max length fruit is " + maxLengthFruit)
}

// 6.2.1 Lambda表达式

//首先来看一下Lambda的定义，如果用最直白的语言来阐述的话，Lambda就是一小段可以作 为参数传递的代码。从定义上看，这个功能就很厉害了.
// 因为正常情况下，我们向某个函数传 参时只能传入变量，而借助Lambda却允许传入一小段代码。
// 接着我们来看一下Lambda表达式的语法结构:
//{参数名1: 参数类型, 参数名2: 参数类型 -> 函数体}

// 由繁入简
fun testListLambda() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape", "Watermelon")
    val lambda = { fruit: String -> fruit.length }
    val maxLengthFruit = list.maxBy(lambda)
}