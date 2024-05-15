package com.creativeitlimited.contactsnumberlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.creativeitlimited.contactsnumberlist.databinding.ActivityMainBinding
import com.creativeitlimited.contactsnumberlist.db.UserDao
import com.creativeitlimited.contactsnumberlist.db.UserDatabase
import com.creativeitlimited.contactsnumberlist.rcv.ContactAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var dao: UserDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val db= Room.databaseBuilder(applicationContext, UserDatabase::class.java,"Userdb")
            .allowMainThreadQueries().build()

        dao=db.getUserDao()

        dao.getAllUser().apply {
            val contactAdapter=ContactAdapter(this)
            binding.rvUser.adapter=contactAdapter
        }




        binding.btnAddContact.setOnClickListener{
            val intent=Intent(this@MainActivity,AddUserActivity::class.java)
             startActivity(intent)
        }
    }
}