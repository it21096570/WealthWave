package com.example.financemanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.financemanagement.Database.DbHelperFinance
import com.example.financemanagement.Model.BankModel
import kotlinx.android.synthetic.main.activity_add_bank.*

class AddBank : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_bank)

        var db=DbHelperFinance(this)
        submit.setOnClickListener{if(!validation()){
            return@setOnClickListener
        }

            var name=name.text.toString()
            var price=price.text.toString()

            var bank=BankModel(name,price)

            var success=db.addBankDetails(bank)

            if(success==true){
                Toast.makeText(this,"Adders Success",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Not success",Toast.LENGTH_LONG).show()
            }

        }

        imageButton.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
    private fun validation():Boolean{
        if(name.text.isNullOrEmpty()){
            name.error="Please Enter The Bank Name"
            return false;
        }
        if(price.text.isNullOrEmpty()){
            price.error="Please Enter The Amount"
            return false
        }

        return true
    }
    }
