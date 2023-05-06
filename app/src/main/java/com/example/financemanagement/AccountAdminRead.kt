package com.example.financemanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.financemanagement.Adapter.BankAdapterAdmin
import com.example.financemanagement.Database.DbHelperFinance
import com.example.financemanagement.Model.BankModel
import kotlinx.android.synthetic.main.activity_account_admin_read.*
import kotlinx.android.synthetic.main.activity_update_bank.*

class AccountAdminRead : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    var Adapter:BankAdapterAdmin?=null
    var DbHelp:DbHelperFinance?=null

    var BankList:List<BankModel> = ArrayList<BankModel>()
    var linierlayoutManager:LinearLayoutManager?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_admin_read)

        recyclerView=findViewById(R.id.recyclerView)

        DbHelp=DbHelperFinance(this)
        val db=DbHelperFinance(this)

        fetchlist()
        var deleteBtn = findViewById<Button>(R.id.deletebtn)

        deleteBtn.setOnClickListener{
            var id = editTextNumber.text.toString()
            println(id)

            val iD = id.toInt()//Casting
            val success = db.deleteBank(iD)

            println(iD)

            if (success == true){
                Toast.makeText(this,"Delete Successfully",Toast.LENGTH_LONG).show()
                startActivity(Intent(this,AccountAdminRead::class.java))
            }else{
                Toast.makeText(this,"Delete Unsuccessfully",Toast.LENGTH_LONG).show()
            }
        }

        update.setOnClickListener{
            var id=editTextNumber.text.toString()
            val intent=Intent(this,UpdateBank::class.java)
            intent.putExtra("id",id)
            startActivity(intent)


        }
        imageButton2.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }


    }

    private fun fetchlist() {

        BankList= DbHelp!!.getAllBanks()
        Adapter = BankAdapterAdmin(BankList, applicationContext);
        linierlayoutManager = LinearLayoutManager(applicationContext);
        recyclerView.layoutManager = LinearLayoutManager(this);
        recyclerView.adapter = Adapter
        Adapter!!.notifyDataSetChanged()

    }
}
