package com.example.kotlinlesson


// 泛型的协变
open class Person(val name: String, val age: Int)
class Student(name: String, age: Int) : Person(name, age)
class Teacher(name: String, age: Int) : Person(name, age)


//class SimpleData<T> {
//    private var data: T? = null
//    fun set(t: T?) {
//        data = t
//    }
//
//    fun get(): T? {
//        return data
//    }
//}
//
//class SimpleData<out T>(val data: T?) {
//    fun get(): T? {
//        return data }
//}
//
//fun main() {
//    val student = Student("Tom", 19)
//    val data = SimpleData<Student>()
//    data.set(student)
//    handleSimpleData(data) // 实际上这行代码会报错，这里假设它能编译通过 val studentData = data.get()
//}
//
//fun handleSimpleData(data: SimpleData<Person>) {
//    val teacher = Teacher("Jack", 35)
//    data.set(teacher)
//}

class SimpleData<out T>(val data: T?) {
    fun get(): T? {
        return data
    }
}

fun main() {
    val student = Student("Tom", 19)
    val data = SimpleData<Student>(student)
    handleMyData(data)
    val studentData = data.get()
}

fun handleMyData(data: SimpleData<Person>) {
    val personData = data.get()
}