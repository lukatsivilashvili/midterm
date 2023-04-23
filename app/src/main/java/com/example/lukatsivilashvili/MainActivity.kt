package com.example.lukatsivilashvili

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var etNumber: EditText
    private lateinit var etMessage: EditText
    private lateinit var btSend: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        initListeners()
    }

    private fun init() {
        etNumber = findViewById(R.id.etNumber)
        etMessage = findViewById(R.id.etMessage)
        btSend = findViewById(R.id.btSendMssg)
    }

    private fun initListeners() {
        btSend.setOnClickListener { sendMessage() }
    }

    private fun sendMessage() {
        val phoneNumber = etNumber.text.toString()
        val message = etMessage.text.toString()

        if (phoneNumber.isEmpty() || message.isEmpty()) {
            Toast.makeText(this, "One or more fields are empty!", Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent(this, MessageActivity::class.java)

            intent.putExtra(MESSAGE, message)
            intent.putExtra(NUMBER, phoneNumber)

            startActivity(intent)
            finish()
        }
    }

    companion object {
        const val MESSAGE = "MESSAGE"
        const val NUMBER = "NUMBER"
    }
}