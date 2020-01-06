package com.example.intent

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)



        //get the extra value
        val msg = intent.getStringExtra(MainActivity.EXTRA_MSG)
        val num = intent.getIntExtra(MainActivity.EXTRA_LUCKY,0)
        textViewMessage.text = String.format("%s %s %s", getString(R.string.message),msg + num)

        btnDone.setOnClickListener{

            intent = getIntent() //who called me?

            if(!editTextReply.text.isEmpty()){
                val reply = editTextReply.text.toString()
                intent.putExtra(MainActivity.EXTRA_REPLY, reply)
                setResult(Activity.RESULT_OK, intent)

            }else{
                setResult(Activity.RESULT_CANCELED)
            }




            //terminate the second activity
            finish()
        }
    }
}
