package com.example.uiwidgettest

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.uiwidgettest.ui.theme.UIWidgetTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val editText = findViewById<EditText>(R.id.editText)
            val inputText = editText.text.toString()
            Toast.makeText(this, inputText, Toast.LENGTH_SHORT).show()
            val imageView = findViewById<ImageView>(R.id.imageView)
//            imageView.setImageResource(R.drawable.img_2)

            val progressBar = findViewById<ProgressBar>(R.id.progressBar)
            progressBar.progress = progressBar.progress + 10
//            if (progressBar.visibility == View.VISIBLE) {
//                progressBar.visibility = View.GONE
//            } else {
//                progressBar.visibility = View.VISIBLE
//            }


            AlertDialog.Builder(this).apply {
                setTitle("This is Dialog")
                setMessage("Something important.")
                setCancelable(false)
                setPositiveButton("OK") { dialog, which ->
                }
                setNegativeButton("Cancel") { dialog, which ->
                }
                show()
            }
        }
    }
}