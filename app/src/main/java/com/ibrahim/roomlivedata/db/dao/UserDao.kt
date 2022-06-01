package com.ibrahim.roomlivedata.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ibrahim.roomlivedata.db.entity.UserEntity

@Dao
interface UserDao {
    @Insert
    fun insert(user: UserEntity)

    @Delete
    fun delete(user: UserEntity)

    @Query("SELECT * FROM UserEntity")
    fun getAllUser():LiveData<List<UserEntity>>

}