package com.example.jetpacktest

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var sp: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        sp = getPreferences(Context.MODE_PRIVATE)
        val countReserved = sp.getInt("count_reserved", 0)
        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(countReserved)
        ).get(MainViewModel::class.java)
//        findViewById<Button>(R.id.plusOneBtn).setOnClickListener {
//            viewModel.counter++
//            refreshCounter()
//        }
//        findViewById<Button>(R.id.clearBtn).setOnClickListener {
//            viewModel.counter = 0
//            refreshCounter()
//        }
//        refreshCounter()

        findViewById<Button>(R.id.plusOneBtn).setOnClickListener {
            viewModel.plusOne()
        }
        findViewById<Button>(R.id.clearBtn).setOnClickListener {
            viewModel.clear()
        }
//        viewModel.counter.observe(this, Observer { count ->
//            findViewById<TextView>(R.id.infoText).text = count.toString()
//        })
        viewModel.counter.observe(this) { count ->
            findViewById<TextView>(R.id.infoText).text = count.toString()
        }
        lifecycle.addObserver(MyObserver(lifecycle))
        findViewById<Button>(R.id.getUserBtn).setOnClickListener {
            val userId = (0..10000).random().toString()
            viewModel.getUser(userId)
        }
        viewModel.user.observe(this, Observer { user ->
            findViewById<TextView>(R.id.infoText).text = user.firstName
        })

        val userDao = AppDatabase.getDatabase(this).userDao()
        val user1 = User("Tom", "Brady", 40)
        val user2 = User("Tom", "Hanks", 63)
        findViewById<Button>(R.id.addDataBtn).setOnClickListener {
            thread {
                user1.id = userDao.insertUser(user1)
                user2.id = userDao.insertUser(user2)
            }
        }
        findViewById<Button>(R.id.updateDataBtn).setOnClickListener {
            thread {
                user1.age = 42
                userDao.updateUser(user1)
            }
        }
        findViewById<Button>(R.id.deleteDataBtn).setOnClickListener {
            thread {
                userDao.deleteUserByLastName("Hanks")
            }
        }
        findViewById<Button>(R.id.queryDataBtn).setOnClickListener {
            thread {
                for (user in userDao.loadAllUsers()) {
                    Log.d("MainActivity", user.toString())
                }
            }
        }

        findViewById<Button>(R.id.doWorkBtn).setOnClickListener {
            val request = OneTimeWorkRequest.Builder(SimpleWorker::class.java).build()
            WorkManager.getInstance(this).enqueue(request)
        }
    }


    private fun refreshCounter() {
        findViewById<TextView>(R.id.infoText).text = viewModel.counter.toString()
    }

    override fun onPause() {
        super.onPause()
//        sp.edit {
//            putInt("count_reserved", viewModel.counter)
//        }
        sp.edit {
            putInt("count_reserved", viewModel.counter.value ?: 0)
        }
    }
}