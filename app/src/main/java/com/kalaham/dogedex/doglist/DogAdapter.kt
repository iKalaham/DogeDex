package com.kalaham.dogedex.doglist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kalaham.dogedex.Dog
import com.kalaham.dogedex.databinding.DogListItemBinding

class DogAdapter : ListAdapter <Dog, DogAdapter.DogViewHolder>(DiffCallback){

    companion object DiffCallback : DiffUtil.ItemCallback<Dog>(){
        override fun areItemsTheSame(oldItem: Dog, newItem: Dog): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Dog, newItem: Dog): Boolean {
            return oldItem.id == newItem.id
        }
    }

    private var OnItemClickListener: ((Dog) -> Unit)? = null
    fun setOnItemClickListener(onItemClickListener: (Dog) -> Unit){
        this.OnItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val binding = DogListItemBinding.inflate(LayoutInflater.from(parent.context))
        return DogViewHolder(binding)
    }

    override fun onBindViewHolder(dogViewHolder: DogViewHolder, position: Int) {
        val dog = getItem(position)
        dogViewHolder.bind(dog)
    }

    inner class DogViewHolder(private val binding: DogListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(dog: Dog){
            binding.dogListItemLayout.setOnClickListener {
                OnItemClickListener?.invoke(dog)
            }
            binding.dogImage.load(dog.imageUrl)
        }

    }

}