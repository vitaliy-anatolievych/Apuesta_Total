package com.doriangrei.apueastawinapp.presentation.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.doriangrei.apueastawinapp.R
import com.doriangrei.apueastawinapp.model.Level

class LevelAdapter : RecyclerView.Adapter<LevelAdapter.ViewHolder>() {

    var listLevels = mutableListOf<Level>()

    private var setOnItemClickListener: ((Level) -> Unit)? = null

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(level: Level) {
            if (!level.isLock) {
                val tvLevel = view.findViewById<TextView>(R.id.tv_level_number)
                val root = view.findViewById<ImageButton>(R.id.imgb_active_level)
                tvLevel.text = level.levelName.toString()

                root.setOnClickListener {
                    setOnItemClickListener?.invoke(level)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = when (viewType) {
            VIEW_TYPE_OPEN -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.active_button_item, parent, false)
            }
            VIEW_TYPE_LOCK -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.lock_button_item, parent, false)
            }
            else -> throw IllegalArgumentException("Unsupported type")
        }

        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        val levelItem = listLevels[position]
        return when (levelItem.isLock) {
            true -> VIEW_TYPE_LOCK
            false -> VIEW_TYPE_OPEN
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listLevels[position])
    }

    fun setOnLevelClickListener(listener: (Level) -> Unit) {
        setOnItemClickListener = listener
    }

    override fun getItemCount(): Int = listLevels.size

    companion object {
        private const val VIEW_TYPE_OPEN = 1
        private const val VIEW_TYPE_LOCK = 2
    }
}