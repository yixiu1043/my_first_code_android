package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ThirdActivity : BaseActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third)
        Log.d("ThirdActivity", "Task id is $taskId")
        val button3 = findViewById<Button>(R.id.button3)
//        button3.setOnClickListener {
//            //直接退出程序
//            ActivityCollector.finishAll()
//            //当然你还可以在销毁所有Activity的代码后面再加上杀掉当前进程的代码，以保证程序完全退 出
//            android.os.Process.killProcess(android.os.Process.myPid())
//        }

        button3.setOnClickListener {
            ForthActivity.actionStart(this, "data1", "data2")
        }

    }
}