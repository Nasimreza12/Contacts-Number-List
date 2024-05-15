package com.creativeitlimited.contactsnumberlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.creativeitlimited.contactsnumberlist.databinding.ActivityAddUserBinding
import com.creativeitlimited.contactsnumberlist.db.User
import com.creativeitlimited.contactsnumberlist.db.UserDao
import com.creativeitlimited.contactsnumberlist.db.UserDatabase

class AddUserActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAddUserBinding
    private lateinit var dao: UserDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db= Room.databaseBuilder(applicationContext, UserDatabase::class.java,"Userdb")
            .allowMainThreadQueries().build()

        dao=db.getUserDao()


        binding.btnAddUser.setOnClickListener {

            val name=binding.userName.text.toString()
            val age =binding.userAge.text.toString()
            val mobile=binding.userAge.text.toString()

            addUser(name,age,mobile)

        }


    }

    private fun addUser(name:String, age:String, mobile:String) {
        val user= User(0,name,age.toInt(),mobile)
        dao.addUser(user)
    }
}