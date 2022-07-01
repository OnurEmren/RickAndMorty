package com.onuremren.rickandmorty.adapter

import com.onuremren.rickandmorty.R
import com.onuremren.rickandmorty.databinding.ItemRowBinding
import com.onuremren.rickandmorty.model.Character
import com.onuremren.rickandmorty.view.ListFragmentDirections

class AbstractAdapter: CharacterAbstractAdapter<Character,ItemRowBinding>() {

    override fun getLayout()= R.layout.item_row

    override fun onBindViewHolder(
        holder: Companion.CharacterViewHolder<ItemRowBinding>,
        position: Int
    ) {
        holder.binding.character = items[position]
        holder.binding.root.setOnClickListener {
            listener?.invoke(it,items[position],position)

        }
    }
}