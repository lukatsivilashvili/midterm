package com.example.lukatsivilashvili

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MessageActivity : AppCompatActivity() {

    private lateinit var tvNumber: TextView
    private lateinit var tvMessage: TextView
    private lateinit var btClear: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        init()
        initListeners()
        receiveMessage()
    }

    private fun init() {
        tvNumber = findViewById(R.id.tvNumber)
        tvMessage = findViewById(R.id.tvMessage)
        btClear = findViewById(R.id.btClear)
    }

    private fun initListeners() {
        btClear.setOnClickListener {
            tvMessage.text = "The message will appear here"
            tvNumber.text = "Sender's number appear here"
        }
    }

    private fun receiveMessage() {
        val intent = intent
        val number = intent.getStringExtra(MainActivity.NUMBER)
        val message = intent.getStringExtra(MainActivity.MESSAGE)

        tvMessage.text = message.toString()
        tvNumber.text = number.toString()
    }

}