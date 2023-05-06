package com.example.financemanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener{
            startActivity(Intent(this,AddBank::class.java))
        }

        button2.setOnClickListener{
            startActivity(Intent(this,AccountAdminRead::class.java))
        }
    }
}