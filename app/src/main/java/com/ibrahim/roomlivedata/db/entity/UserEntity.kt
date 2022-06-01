package com.ibrahim.roomlivedata.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="UserEntity")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    var userId:Int=0,
    var userName:String,
    var userAge:Int,
    var userHeight:Int,
)
