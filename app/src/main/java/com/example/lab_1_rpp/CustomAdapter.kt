package com.example.lab_1_rpp

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*


class CustomAdapter(val items : ArrayList<Int>, val context: Context) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (items.get(position) % 2 == 1)
        {
            holder?.number?.setBackgroundColor(Color.WHITE)
            holder.image.setImageResource(R.drawable.lc)
        }
        else
        {
            holder?.number?.setBackgroundColor(Color.LTGRAY)
            holder.image.setImageResource(R.drawable.lc4)
        }
        holder?.number?.text = intToString(items.get(position))
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val number = view.item_textView
        var image = view.item_icon
    }

    fun intToString(number: Int) : String
    {
        var tempString = ""
        var tempNumber = number
        var flag = false;
        val digits : Array<String> = arrayOf("", "один", "два", "три", "четыре","пять", "шесть", "семь", "восемь", "девять")
        val tens1: Array<String> = arrayOf("десять", "одиннадцать", "двеннадцать", "тринадцать","четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать")
        val tens2: Array<String> = arrayOf("", "", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто")
        val hundreds: Array<String> = arrayOf("", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот")
        val thousands: Array<String> = arrayOf("", "тысяча", "две тысячи", "три тысячи", "четыре тысячи", "пять тысяч", "шесть тысяч", "семь тысяч", "восемь тысяч", "девять тысяч")

        if (tempNumber/1000000 > 0)
            return "Один миллион"
        tempNumber %= 1000000
        if (tempNumber/100000 > 0)
        {
            flag = true;
            tempString += hundreds[number/100000 % 10] + " "
        }
        tempNumber %= 100000
        if (tempNumber/10000 > 0)
        {
            if (tempNumber/10000 == 1)
            {
                tempString += tens1[tempNumber/1000 % 10] + " "
                tempNumber %= 1000
                flag = true
            }
            else
            {
                tempString+= tens2[tempNumber/10000] + " "
                tempNumber %= 10000
                flag = true
            }
        }
        if (tempNumber/1000 > 0)
        {
            tempString += thousands[tempNumber/1000] + " "
        }
        else if (flag)
        {
            tempString += "тысяч "
        }
        tempNumber %= 1000
        if (tempNumber/100 > 0)
        {
            tempString += hundreds[tempNumber/100] + " "
        }

        tempNumber %= 100
        if (tempNumber/10 > 0)
        {
            if (tempNumber/10 == 1)
            {
                tempString += tens1[tempNumber%10] + " "
                return tempString
            }
            else
            {
                tempString += tens2[tempNumber/10] + " " + digits[tempNumber%10] + " "
                return tempString
            }
        }
        tempString += digits[tempNumber%10] + " "
        return tempString
    }

}