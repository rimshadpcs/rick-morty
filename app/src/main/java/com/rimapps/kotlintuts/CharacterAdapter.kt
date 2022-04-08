package com.rimapps.kotlintuts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rimapps.kotlintuts.network.Character

class CharacterAdapter (private val charactersList: List<Character>): RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>(){

    private lateinit var mListener :OnItemClickListener

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        mListener = listener

    }

    class CharacterViewHolder (itemView: View, listener: OnItemClickListener):RecyclerView.ViewHolder(itemView){
        fun bindData(character: Character){
            val characterName = itemView.findViewById<TextView>(R.id.tvCharacter)
            val characterStatus = itemView.findViewById<TextView>(R.id.tvCharacterStatus)
            val characterImage = itemView.findViewById<ImageView>(R.id.ivCharacter)

            characterName.text = character.name
            characterStatus.text = character.status

            Glide.with(itemView.context).load(character.image).into(characterImage)

//            image.load(character.image){
//                transformations(CircleCropTransformation())
//            }

        }
        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.character_list,parent,false),mListener)

    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bindData(charactersList[position])
    }

    override fun getItemCount(): Int {
        return charactersList.size
    }

    companion object fun getItem(pos : Int) : Character {
        return charactersList[pos]
    }

}
