package com.example.wealthwave

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 : Button = findViewById(R.id.button)

        button1.setOnClickListener {
           startActivity(Intent(this,new_invesment::class.java))
        }

        val button2 : Button = findViewById(R.id.button2)

        button2.setOnClickListener {
            startActivity(Intent(this,View_Individual::class.java))
        }

        val button3 : Button = findViewById(R.id.button3)

        button3.setOnClickListener {
            startActivity(Intent(this, Total_Invesment::class.java))
        }
    }

    // Inflate the menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout -> {
                // Handle action_settings
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}