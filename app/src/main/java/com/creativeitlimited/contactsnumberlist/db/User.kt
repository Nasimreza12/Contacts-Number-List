package com.creativeitlimited.contactsnumberlist.db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class User(

    @PrimaryKey(autoGenerate = true)
    val id:Int,

    val name:String,
    val age:Int,
    val mobile:String,
)
