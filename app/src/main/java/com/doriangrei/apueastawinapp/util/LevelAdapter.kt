package com.doriangrei.apueastawinapp.util

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class LevelAdapter: RecyclerView.Adapter<LevelAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    companion object {
        private const val VIEW_TYPE_OPEN = 1
        private const val VIEW_TYPE_LOCK = 2
    }
}