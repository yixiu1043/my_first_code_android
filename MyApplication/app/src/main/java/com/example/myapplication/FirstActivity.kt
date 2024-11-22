package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FirstActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Log.d("FirstActivity", this.toString())
        Log.d("FirstActivity", "Task id is $taskId")
        setContentView(R.layout.activity_first)
        val button1 = findViewById<Button>(R.id.button1)
        button1.setOnClickListener {
//            val intent = Intent(this, FirstActivity::class.java)
//            startActivity(intent)

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }


    override fun onRestart() {
        super.onRestart()
        Log.d("FirstActivity", "onRestart")
    }
}