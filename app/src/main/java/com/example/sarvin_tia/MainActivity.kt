package com.example.sarvin_tia

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sarvin_tia.databinding.ActivityMainBinding
import com.example.sarvin_tia.Home.p5.LimaActivity
import com.example.sarvin_tia.Home.pertemuan6.EnamActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        val user = intent.getStringExtra("username")
        val pass = intent.getStringExtra("password")
        binding.textView2.text = "Halo, $user"

        binding.textView3.text = "Sandi: $pass"

        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()
                    dialog.dismiss()
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()

                }
                .setNegativeButton("Batal") { dialog, _ -> dialog.dismiss() }
                .show()

        }
        binding.snackbar.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)

        }
        binding.btnToLima.setOnClickListener {
            val intent = Intent(this@MainActivity, LimaActivity::class.java)
            startActivity(intent)
        }
        binding.pertemuan6.setOnClickListener {
            val intent = Intent(this@MainActivity, EnamActivity::class.java)
            startActivity(intent)
        }
//        binding.btnLogout.setOnClickListener {
//            MaterialAlertDialogBuilder(this)
//                .setTitle("Konfirmasi LogOut")
//                .setMessage("Apakah Anda yakin ingin keluar dari aplikasi?")
//                .setNegativeButton("Tidak") { dialog, _ ->
//                    dialog.dismiss()
//                }
//                .setPositiveButton("Ya") { dialog, _ ->
//                    val intent = Intent(this, LoginActivity::class.java)
//                    startActivity(intent)
//                    finish()
//                    Toast.makeText(this, "Berhasil LogOut", Toast.LENGTH_SHORT).show()
//                }
//                .setCancelable(false)
//                .show()
//        }
    }
}