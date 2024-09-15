package com.example.registerloginintentapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.registerloginintentapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val registeredUsername = intent.getStringExtra("username")
        val registeredPassword = intent.getStringExtra("password")
        val registeredEmail = intent.getStringExtra("email")
        val registeredPhone = intent.getStringExtra("phone")

        with(binding) {
            btnLogin.setOnClickListener {
                val inputUsername = etUsername.text.toString()
                val inputPassword = etPassword.text.toString()


                if (inputUsername == registeredUsername && inputPassword == registeredPassword) {
                    val intent = Intent(this@SecondActivity, ThirdActivity::class.java)
                    intent.putExtra("username", registeredUsername)
                    intent.putExtra("email", registeredEmail)
                    intent.putExtra("phone", registeredPhone)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@SecondActivity, "Username or Password is incorrect", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
}