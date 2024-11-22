package com.example.kotlinlesson


// 泛型的逆变
//interface Transformer<T> {
//    fun transform(t: T): String
//}

interface Transformer<in T> {
    fun transform(t: T): String
}

fun main() {
    val trans = object : Transformer<Person> {
        override fun transform(t: Person): String {
            return "${t.name} ${t.age}"
        }
    }
    handleTransformer(trans) // 这行代码会报错
}

fun handleTransformer(trans: Transformer<Student>) {
    val student = Student("Tom", 19)

    val result = trans.transform(student)
}