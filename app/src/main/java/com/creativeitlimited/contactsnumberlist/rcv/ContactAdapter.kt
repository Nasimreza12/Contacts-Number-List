package com.creativeitlimited.contactsnumberlist.rcv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.creativeitlimited.contactsnumberlist.databinding.ContactItemBinding
import com.creativeitlimited.contactsnumberlist.db.User

class ContactAdapter(private val contactItem: List<User>) :RecyclerView.Adapter<ContactViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding=ContactItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
       return ContactViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return contactItem.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contactList=contactItem[position]
     with(holder.binding){
         contactName.text=contactList.name
         contactAge.text=contactList.age.toString()
         contactMobile.text=contactList.mobile
    }
}
}