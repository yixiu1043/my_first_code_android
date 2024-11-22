package com.example.listviewtest

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

//class FruitAdapter(activity: Activity, val resourceId: Int, data: List<Fruit>): ArrayAdapter<Fruit>(activity, resourceId, data) {
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//        val view = LayoutInflater.from(context).inflate(resourceId,parent,false)
//        val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
//        val fruitName: TextView = view.findViewById(R.id.fruitName)
//        val fruit = getItem(position) // 获取当前项的Fruit实例
//        if (fruit != null) {
//            fruitImage.setImageResource(fruit.imageId)
//            fruitName.text = fruit.name
//        }
//        return view
//    }
//}

//提升ListView的运行效率
//class FruitAdapter(activity: Activity, val resourceId: Int, data: List<Fruit>) :
//    ArrayAdapter<Fruit>(activity, resourceId, data) {
//        // 仔细观察你会发现，getView()方法中还有一个convertView参数，这个参数用于将之前加 载好的布局进行缓存，以便之后进行重用，我们可以借助这个参数来进行性能优化。
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//        val view: View
//        if (convertView == null) {
//            view = LayoutInflater.from(context).inflate(resourceId, parent, false)
//        } else {
//            view = convertView
//        }
//        val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
//        val fruitName: TextView = view.findViewById(R.id.fruitName)
//        val fruit = getItem(position) // 获取当前项的Fruit实例
//        if (fruit != null) {
//            fruitImage.setImageResource(fruit.imageId)
//            fruitName.text = fruit.name
//        }
//        return view
//    }
//}

//不过，目前我们的这份代码还是可以继续优化的，虽然现在已经不会再重复去加载布局，但是 每次在getView()方法中仍然会调用View的findViewById()方法来获取一次控件的实例。 我们可以借助一个ViewHolder来对这部分性能进行优化
class FruitAdapter(activity: Activity, val resourceId: Int, data: List<Fruit>) :
    ArrayAdapter<Fruit>(activity, resourceId, data) {
        // 内部类ViewHolder，用于对ImageView和TextView的控件实例进行缓存
    inner class ViewHolder(val fruitImage: ImageView, val fruitName: TextView)

    // 仔细观察你会发现，getView()方法中还有一个convertView参数，这个参数用于将之前加 载好的布局进行缓存，以便之后进行重用，我们可以借助这个参数来进行性能优化。
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder: ViewHolder
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resourceId, parent, false)
            val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
            val fruitName: TextView = view.findViewById(R.id.fruitName)
            viewHolder = ViewHolder(fruitImage, fruitName)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        val fruit = getItem(position) // 获取当前项的Fruit实例
        if (fruit != null) {
            viewHolder.fruitImage.setImageResource(fruit.imageId)
            viewHolder.fruitName.text = fruit.name
        }
        return view
    }
}
