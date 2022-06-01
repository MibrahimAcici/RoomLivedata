package com.ibrahim.roomlivedata.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibrahim.roomlivedata.databinding.ActivityMainBinding
import com.ibrahim.roomlivedata.db.UserDatabase
import com.ibrahim.roomlivedata.db.entity.UserEntity
import com.ibrahim.roomlivedata.main.adapter.UserAdapter

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var userAdapter: UserAdapter
    lateinit var userDatabase:UserDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //init database
        userDatabase=UserDatabase.getUserDatabase(this)

        //init adapter
        userAdapter = UserAdapter()
        binding.recyclerView.adapter = userAdapter

        //init layoutManager
        val layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.layoutManager = layoutManager

        val liveDataList = userDatabase.userDao().getAllUser()
      liveDataList.observe(this) {dbList ->
            userAdapter.setList(dbList)
      }

        userAdapter.removeClickListener = {userEntity ->
            userDatabase.userDao().delete(userEntity)
        }

        binding.btnSave.setOnClickListener {
            val name=binding.userName.text.toString()
            val age=binding.userAge.text.toString().toInt()
            val height=binding.userHeight.text.toString().toInt()

            val user=UserEntity(userName = name, userAge = age, userHeight = height)
            userDatabase.userDao().insert(user)
        }

        /*
        binding.btnShow.setOnClickListener {
            val list = userDatabase.userDao().getAllUser()
            userAdapter.setList(list)
        }
         */

    }
}
