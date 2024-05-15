package com.creativeitlimited.contactsnumberlist.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    fun addUser(user: User)

    @Query("SELECT * FROM USER")
    fun getAllUser():List<User>
}