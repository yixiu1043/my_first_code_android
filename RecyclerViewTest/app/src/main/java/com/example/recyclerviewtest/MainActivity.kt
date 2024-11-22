package com.example.recyclerviewtest

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager


//为什么ListView很难或者根本无法实现的效果在RecyclerView上这么轻松就实现了呢?这主要 得益于RecyclerView出色的设计。ListView的布局排列是由自身去管理的，而RecyclerView
//则将这个工作交给了LayoutManager。LayoutManager制定了一套可扩展的布局排列接口， 子类只要按照接口的规范来实现，就能定制出各种不同排列方式的布局了。
//除了LinearLayoutManager之外，RecyclerView还给我们提供了GridLayoutManager和 StaggeredGridLayoutManager这两种内置的布局排列方式。GridLayoutManager可以用于 实现网格布局，StaggeredGridLayoutManager可以用于实现瀑布流布局。这里我们来实现 一下效果更加炫酷的瀑布流布局，网格布局就作为课后习题，交给你自己来研究了。

class MainActivity : AppCompatActivity() {
    private val fruitList = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initFruits()
//        val layoutManager = LinearLayoutManager(this)
//        设置滚动方向为横向
//        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

//       瀑布流布局
        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        val adapter = FruitAdapter(fruitList, this)
        recyclerView.adapter = adapter;
    }

//    private fun initFruits() {
//        repeat(2) {
//            fruitList.add(Fruit("Apple", R.drawable.apple_pic))
//            fruitList.add(Fruit("Banana", R.drawable.banana_pic))
//            fruitList.add(Fruit("Orange", R.drawable.orange_pic))
//            fruitList.add(Fruit("Watermelon", R.drawable.watermelon_pic))
//            fruitList.add(Fruit("Pear", R.drawable.pear_pic))
//            fruitList.add(Fruit("Grape", R.drawable.grape_pic))
//            fruitList.add(Fruit("Pineapple", R.drawable.pineapple_pic))
//            fruitList.add(Fruit("Strawberry", R.drawable.strawberry_pic))
//            fruitList.add(Fruit("Cherry", R.drawable.cherry_pic))
//            fruitList.add(Fruit("Mango", R.drawable.mango_pic))
//        }
//    }

    private fun initFruits() {
        repeat(2) {
            fruitList.add(
                Fruit(
                    getRandomLengthString("Apple"),
                    R.drawable.apple_pic
                )
            )
            fruitList.add(
                Fruit(
                    getRandomLengthString("Banana"),
                    R.drawable.banana_pic
                )
            )
            fruitList.add(
                Fruit(
                    getRandomLengthString("Orange"),
                    R.drawable.orange_pic
                )
            )
            fruitList.add(
                Fruit(
                    getRandomLengthString("Watermelon"),
                    R.drawable.watermelon_pic
                )
            )
            fruitList.add(
                Fruit(
                    getRandomLengthString("Pear"),
                    R.drawable.pear_pic
                )
            )
            fruitList.add(
                Fruit(
                    getRandomLengthString("Grape"),
                    R.drawable.grape_pic
                )
            )
            fruitList.add(
                Fruit(
                    getRandomLengthString("Pineapple"),
                    R.drawable.pineapple_pic
                )
            )
            fruitList.add(
                Fruit(
                    getRandomLengthString("Strawberry"),
                    R.drawable.strawberry_pic
                )
            )
            fruitList.add(
                Fruit(
                    getRandomLengthString("Cherry"),
                    R.drawable.cherry_pic
                )
            )
            fruitList.add(
                Fruit(
                    getRandomLengthString("Mango"),
                    R.drawable.mango_pic
                )
            )
        }
    }

    private fun getRandomLengthString(str: String): String {
        val n = (1..20).random()
        val builder = StringBuilder()
        repeat(n) {
            builder.append(str)
        }
        return builder.toString()
    }
}