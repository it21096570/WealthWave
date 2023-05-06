package com.example.financemanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.financemanagement.Database.DbHelperFinance
import com.example.financemanagement.Model.BankModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_update_bank.*

class UpdateBank : AppCompatActivity() {

    var bank:BankModel= BankModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_bank)

        val value=intent.getStringExtra("id")
        val id=value!!.toInt()
        val db=DbHelperFinance(this)

        bank=db.getBankDetails(id)

        bankNameEdit.setText(bank.bankName)
        bankPriceEdit.setText(bank.bankPrice)

        updateBtn.setOnClickListener{


            var id=id
            var name=bankNameEdit.text.toString()
            var price=bankPriceEdit.text.toString()

            val bank=BankModel(id,name,price)

            val success=db.updateBank(bank)

            if(success===true){
                Toast.makeText(this,"Update Successs",Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this,"Update Unsuccess",Toast.LENGTH_LONG).show()
            }

        }
        viewBtn.setOnClickListener{
            startActivity(Intent(this,AccountAdminRead::class.java))
        }
    }
}
