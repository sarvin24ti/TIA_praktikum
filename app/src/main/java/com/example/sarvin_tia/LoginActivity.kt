package com.example.sarvin_tia

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sarvin_tia.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonnLogin.setOnClickListener {
            val user = binding.edtuser.text.toString()
            val password = binding.edtPassword.text.toString()

            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("username", user)
                putExtra("password", password)
            }
            Toast.makeText(this, "Selamat Datang, $user!", Toast.LENGTH_SHORT).show()
            startActivity(intent)
            finish()
        }
    }
}