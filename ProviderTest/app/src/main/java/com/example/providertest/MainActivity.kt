package com.example.providertest

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.contentValuesOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var bookId: String? = null

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val addData = findViewById<Button>(R.id.addData)
        addData.setOnClickListener {
            val uri = Uri.parse("content://com.example.databasetest.provider/book")
            val values = contentValuesOf(
                "name" to "A Clash of Kings",
                "author" to "George Martin", "pages" to 1040, "price" to 22.85
            )
            val newUri = contentResolver.insert(uri, values)
            bookId = newUri?.pathSegments?.get(1)
        }

        val queryData = findViewById<Button>(R.id.queryData)
        queryData.setOnClickListener {
            val uri = Uri.parse("content://com.example.databasetest.provider/book")
            contentResolver.query(uri, null, null, null, null)?.apply {
                while (moveToNext()) {
                    val name = getString(getColumnIndex("name"))
                    val author = getString(getColumnIndex("author"))
                    val pages = getInt(getColumnIndex("pages"))
                    val price = getDouble(getColumnIndex("price"))
                    Log.d("MainActivity", "book name is $name")
                    Log.d("MainActivity", "book author is $author")
                    Log.d("MainActivity", "book pages is $pages")
                    Log.d("MainActivity", "book price is $price")
                }
                close()
            }
        }
        val updateData = findViewById<Button>(R.id.updateData)

        updateData.setOnClickListener {
            bookId?.let {
                val uri = Uri.parse(
                    "content://com.example.databasetest.provider/book/$it"
                )
                val values = contentValuesOf(
                    "name" to "A Storm of Swords",
                    "pages" to 1216, "price" to 24.05
                )
                contentResolver.update(uri, values, null, null)
            }
        }
        val deleteData = findViewById<Button>(R.id.deleteData)

        deleteData.setOnClickListener {
            bookId?.let {
                val uri = Uri.parse(
                    "content://com.example.databasetest.provider/book/$it"
                )
                contentResolver.delete(uri, null, null)
            }
        }
    }
}