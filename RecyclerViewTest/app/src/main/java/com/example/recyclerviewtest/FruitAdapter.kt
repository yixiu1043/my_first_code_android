package com.example.recyclerviewtest

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView

//class FruitAdapter (val fruitList: List<Fruit>): RecyclerView.Adapter<FruitAdapter.ViewHolder>() {
//    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val fruitImage : ImageView = view.findViewById(R.id.fruitImage)
//        val fruitName : TextView = view.findViewById(R.id.fruitName)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.fruit_item, parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val fruit: Fruit = fruitList[position]
//        holder.fruitImage.setImageResource(fruit.imageId)
//        holder.fruitName.text = fruit.name
//
//    }
//
//    // 写法一
////    override fun getItemCount(): Int {
////        return fruitList.size
////    }
//
//    // 写法二
//    override fun getItemCount() = fruitList.size
//}

//在RecyclerView中注册点击事件

class FruitAdapter(val fruitList: List<Fruit>, private val context: Context) : RecyclerView.Adapter<FruitAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
        val fruitName: TextView = view.findViewById(R.id.fruitName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.fruit_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit: Fruit = fruitList[position]
        holder.fruitImage.setImageResource(fruit.imageId)
        holder.fruitName.text = fruit.name

        holder.itemView.setOnClickListener {
            val position = holder.bindingAdapterPosition
            Log.d("bindingAdapterPosition", position.toString())
            if (position != RecyclerView.NO_POSITION) {
                // 处理点击事件
                Log.d("bindingAdapterPosition", position.toString())
                Toast.makeText(
                    context,
                    "you  clicked view ${fruit.name}",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }

        holder.fruitImage.setOnClickListener {
            val position = holder.bindingAdapterPosition
            if (position != RecyclerView.NO_POSITION) {
                Toast.makeText(
                    context, "you clicked image ${fruit.name}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    // 写法一
//    override fun getItemCount(): Int {
//        return fruitList.size
//    }

    // 写法二
    override fun getItemCount() = fruitList.size
}
