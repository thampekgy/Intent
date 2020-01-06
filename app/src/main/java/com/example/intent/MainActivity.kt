package com.example.intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSend.setOnClickListener {
        sendMessage()
    }
    }

    private fun sendMessage() {
        // Input validation
        if(editTextMessage.text.isEmpty())
        {
            editTextMessage.setError("Value Required")
            return
        }
        val intent = Intent(this, SecondActivity::class.java)


        //Intert extra to the Intent
        val msg = editTextMessage.text.toString()
        //val msg = findViewById<EditText>(R.id.editTextMessage).toString()
        val num = findViewById<EditText>(R.id.editText2).toString()
        intent.putExtra(EXTRA_LUCKY,num)
        intent.putExtra(EXTRA_MSG,msg)

        //dont expecting any return value from secondActivity
                //startActivity(intent)

        // got return from second activity
        startActivityForResult(intent, REQUEST_CODE)




    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK){
                val reply = data?.getStringExtra(EXTRA_REPLY)
                textViewReply.text = reply
                //Display reply here
            }

        }
    }

    companion object{
        const val EXTRA_LUCKY = "com.example.intent.EXTRA_LUCKY"
        const val EXTRA_MSG ="com.example.intent.EXTRA_MSG"
        const val EXTRA_REPLY ="com.example.intent.EXTRA_REPLY"
        const val REQUEST_CODE = 1
    }
}


