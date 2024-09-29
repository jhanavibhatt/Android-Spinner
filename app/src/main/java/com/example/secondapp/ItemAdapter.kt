package com.example.secondapp

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ItemAdapter(private val context: Context, private val items: List<Item>) : BaseAdapter() {

    override fun getCount(): Int = items.size

    override fun getItem(position: Int): Any = items[position]

    override fun getItemId(position: Int): Long = position.toLong()

    // Create and return the view for each item in the spinner
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.spinner_layout, parent, false)

        val item = getItem(position) as Item

        // Bind data to views
        val icon = view.findViewById<ImageView>(R.id.ivSpinnerLayout)
        val text = view.findViewById<TextView>(R.id.tvSpinnerLayout)

        icon.setImageResource(item.iconResId)
        text.text = item.itemName

        return view
    }
    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_spinner, parent, false)

        val item = getItem(position) as Item

        // Bind data to views
        val icon = view.findViewById<ImageView>(R.id.spinner_icon)
        val text = view.findViewById<TextView>(R.id.spinner_text)

        icon.setImageResource(item.iconResId)
        text.text = item.itemName

        return view
    }
}