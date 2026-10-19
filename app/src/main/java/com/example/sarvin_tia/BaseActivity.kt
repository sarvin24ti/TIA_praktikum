package com.example.sarvin_tia

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.sarvin_tia.Home.Home
import com.example.sarvin_tia.Message.Message
import com.example.sarvin_tia.databinding.ActivityBaseBinding
import com.example.sarvin_tia.databinding.ActivityLoginBinding
import com.example.sarvin_tia.more.More

class BaseActivity : AppCompatActivity () {
    private lateinit var binding: ActivityBaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()


        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right,0 )
            insets
        }



        binding.bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    replaceFragment(Home())
                    true
                }
                R.id.message -> {
                    replaceFragment(Message())
                    true
                }
                R.id.more -> {
                    replaceFragment(More())
                    true
                }
                else -> false
            }
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            // .addToBackStack(null) sengaja dinonaktifkan: saat back langsung keluar aplikasi
            .commit()
    }
}