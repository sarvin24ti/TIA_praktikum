package com.example.sarvin_tia.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.sarvin_tia.DetailActivity
import com.example.sarvin_tia.Home.p5.LimaActivity
import com.example.sarvin_tia.Home.pertemuan6.EnamActivity
import com.example.sarvin_tia.LoginActivity
import com.example.sarvin_tia.R
import com.example.sarvin_tia.databinding.FragmentHomeBinding
import com.example.sarvin_tia.databinding.FragmentMessageBinding


class Home : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return inflater.inflate(R.layout.fragment_home, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Home"

        val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)
        val user = requireActivity().intent.getStringExtra("username")
        val pass = requireActivity().intent.getStringExtra("password")

        binding.textView2.text = "Halo, $user"
        binding.textView3.text = "Sandi: $pass"
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()
                    dialog.dismiss()
                    startActivity(Intent(requireContext(), LoginActivity::class.java))
                    requireActivity().finish()

                }
                .setNegativeButton("Batal") { dialog, _ -> dialog.dismiss() }
                .show()

        }
        binding.snackbar.setOnClickListener {
            val intent = Intent(requireContext(), DetailActivity::class.java)
            startActivity(intent)

        }
        binding.btnToLima.setOnClickListener {
            val intent = Intent(requireContext(), LimaActivity::class.java)
            startActivity(intent)
        }
        binding.pertemuan6.setOnClickListener {
            val intent = Intent(requireContext(), EnamActivity::class.java)
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