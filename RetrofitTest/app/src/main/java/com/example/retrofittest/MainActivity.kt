package com.example.retrofittest

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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

        val getAppDataBtn = findViewById<Button>(R.id.getAppDataBtn)
        getAppDataBtn.setOnClickListener {
//            val retrofit = Retrofit.Builder()
//                .baseUrl("http://192.168.254.105:8080/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//            val appService = retrofit.create(AppService::class.java)
//            val appService = ServiceCreator.create(AppService::class.java)
            val appService = ServiceCreator.create<AppService>()
            appService.getAppData().enqueue(object : Callback<List<App>> {
                override fun onResponse(
                    call: Call<List<App>>,
                    response: Response<List<App>>
                ) {
                    val list = response.body()
                    Log.d("MainActivity", "response is ${response}")
                    if (list != null) {
                        for (app in list) {
                            Log.d("MainActivity", "id is ${app.id}")
                            Log.d("MainActivity", "name is ${app.name}")
                            Log.d("MainActivity", "version is ${app.version}")
                        }
                    }
                }

                override fun onFailure(call: Call<List<App>>, t: Throwable) {
                    t.printStackTrace()
                }
            })
        }
    }
}
