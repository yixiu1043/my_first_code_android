package com.example.sharedpreferencestest

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 将数据存储到SharedPreferences中
        val saveButton = findViewById<Button>(R.id.saveButton)
        saveButton.setOnClickListener {
//            val editor = getSharedPreferences("data", Context.MODE_PRIVATE).edit()
//
//            editor.putString("name", "Tom")
//            editor.putInt("age", 28)
//            editor.putBoolean("married", false)
//            editor.apply()

            // 简化SharedPreferences的用法
            getSharedPreferences("data", Context.MODE_PRIVATE).open {
                putString("name", "Tom")
                putInt("age", 28)
                putBoolean("married", false)
            }
        }

        // 从SharedPreferences中读取数据
        val restoreButton = findViewById<Button>(R.id.restoreButton)
        restoreButton.setOnClickListener {
            val prefs = getSharedPreferences("data", Context.MODE_PRIVATE)
            val name = prefs.getString("name", "")
            val age = prefs.getInt("age", 0)
            val married = prefs.getBoolean("married", false)
            Log.d("MainActivity", "name is $name")
            Log.d("MainActivity", "age is $age")
            Log.d("MainActivity", "married is $married")
        }

    }
}