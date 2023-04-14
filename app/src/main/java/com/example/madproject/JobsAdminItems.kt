package com.example.madproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_jobs_admin_items.*

class JobsAdminItems : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jobs_admin_items)


        jobs_page.setOnClickListener{
            
        }
        job_tips_page.setOnClickListener{

        }
    }
}