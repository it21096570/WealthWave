package com.example.wealthwave

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.wealthwave.Database.DBHandler
import com.example.wealthwave.Database.Invesment

class Set_goal : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_goal)

        val setgoalGoal: Button = findViewById(R.id.setgoalGoal)

        setgoalGoal.setOnClickListener {


            val dbHandler = DBHandler(applicationContext)

            // Check if the database has any data


            val success = dbHandler.addGoal(
                findViewById<EditText>(R.id.invesmentGoal).text.toString(),
                findViewById<EditText>(R.id.incomeGoal).text.toString(),
                findViewById<EditText>(R.id.dateGoal).text.toString(),
            )

            Toast.makeText(this, "Data Added Successfully!", Toast.LENGTH_LONG).show()
            startActivity(Intent(this, Set_goal::class.java))

            findViewById<EditText>(R.id.invesmentGoal).text = null
            findViewById<EditText>(R.id.incomeGoal).text = null
            findViewById<EditText>(R.id.dateGoal).text = null


            if (dbHandler.getGoalCount() > 0) {
                // If the database has at least one data, disable the button
                setgoalGoal.isEnabled = false
            }


            setgoalGoal.isEnabled = false

        }
    }





}