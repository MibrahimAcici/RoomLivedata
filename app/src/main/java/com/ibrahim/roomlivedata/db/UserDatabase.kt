package com.ibrahim.roomlivedata.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ibrahim.roomlivedata.db.dao.UserDao
import com.ibrahim.roomlivedata.db.entity.UserEntity

@Database(entities = [UserEntity::class],version = 2)
abstract class UserDatabase:RoomDatabase() {
    abstract fun userDao(): UserDao


    companion object {
        private var appDatabase: UserDatabase? = null

        fun getUserDatabase(context: Context): UserDatabase {
            if (appDatabase == null) {
                appDatabase = Room
                    .databaseBuilder(
                        context,
                        UserDatabase::class.java,
                        "user.db"
                )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return appDatabase!!
        }
    }
}
