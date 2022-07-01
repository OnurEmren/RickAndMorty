package com.onuremren.rickandmorty.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class CharacterAbstractAdapter<T : Any, VB: ViewDataBinding>
    :RecyclerView.Adapter<CharacterAbstractAdapter.Companion.CharacterViewHolder<VB>>()
{

    var items = mutableListOf<T>()

    fun addItems(items: List<T>){
        this.items = items as MutableList<T>
        notifyDataSetChanged()

    }
    var listener: ((view: View, item: T, position: Int)-> Unit)? = null

    override fun getItemCount(): Int {
        return items.size
    }
    abstract fun getLayout(): Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CharacterViewHolder<VB>(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            getLayout(),
            parent,
            false

        )
    )
        companion object{
            class CharacterViewHolder<VB: ViewDataBinding>(val binding: VB): RecyclerView.ViewHolder(binding.root)
        }
}