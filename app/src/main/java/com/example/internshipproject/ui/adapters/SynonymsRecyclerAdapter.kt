package com.example.internshipproject.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.internshipproject.databinding.ViewholderSynonymsItemBinding

class SynonymsRecyclerAdapter(val list:List<String>):RecyclerView.Adapter<SynonymsRecyclerAdapter.SynonymsViewHolder>() {

    /** ViewHolder that will hold the view which we want to display in recyclerView **/
    inner class SynonymsViewHolder(val binding:ViewholderSynonymsItemBinding):RecyclerView.ViewHolder(binding.root){

    }

    /** this function will create the viewHolder **/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SynonymsViewHolder {
        val binding=ViewholderSynonymsItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SynonymsViewHolder(binding)
    }

    /** this function will load data to the view **/
    override fun onBindViewHolder(holder: SynonymsViewHolder, position: Int) {
        val binding=holder.binding
        binding.synonym.text=list[position]
    }

    /** this function will help the recylerView in knowing the total items **/
    override fun getItemCount()=list.size
}