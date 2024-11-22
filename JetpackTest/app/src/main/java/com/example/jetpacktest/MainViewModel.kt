package com.example.jetpacktest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap

//class MainViewModel(countReserved: Int):ViewModel() {
//    var counter = countReserved
//}

//class MainViewModel(countReserved: Int):ViewModel() {
//    var counter = MutableLiveData<Int>()
//
//    init {
//        counter.value = countReserved
//    }
//
//    fun plusOne() {
//        // 这里使用了一个?:操作符，当获取到的数据为空时，就用0来作为默认计数
//        val count = counter.value ?: 0
//        counter.value = count + 1
//    }
//
//    fun clear() {
//        counter.value = 0
//    }
//}

class MainViewModel(countReserved: Int) : ViewModel() {
    val counter: LiveData<Int>
        get() = _counter
    private val _counter = MutableLiveData<Int>()

    init {
        _counter.value = countReserved
    }

    fun plusOne() {
        val count = _counter.value ?: 0
        _counter.value = count + 1
    }

    fun clear() {
        _counter.value = 0
    }

//    private val userLiveData = MutableLiveData<User>()
//    val userName: LiveData<String> = Transformations.map(userLiveData) { user ->
//        "${user.firstName} ${user.lastName}"
//    }

    private val userIdLiveData = MutableLiveData<String>()
    val user: LiveData<User> = userIdLiveData.switchMap { userId ->
        Repository.getUser(userId)
    }

    fun getUser(userId: String) {
        userIdLiveData.value = userId
    }
}