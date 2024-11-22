package com.example.jetpacktest

import androidx.room.Entity
import androidx.room.PrimaryKey

//data class User(var firstName: String, var lastName: String, var age: Int)

@Entity
data class User(var firstName: String, var lastName: String, var age: Int) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}