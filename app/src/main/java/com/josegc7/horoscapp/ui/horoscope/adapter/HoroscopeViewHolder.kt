package com.josegc7.horoscapp.ui.horoscope.adapter

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.josegc7.horoscapp.databinding.ItemHoroscopeBinding
import com.josegc7.horoscapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)

    fun render(horoscopeInfo: HoroscopeInfo) {
        val context:Context = binding.tvTitle.context
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvTitle.text = context.getString(horoscopeInfo.name)
    }
}