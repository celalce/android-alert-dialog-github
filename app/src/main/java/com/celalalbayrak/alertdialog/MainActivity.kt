package com.celalalbayrak.alertdialog

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.celalalbayrak.alertdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //baslarken email ve parolımızı tutmak için iki değişken oluşturalmı

        var girisemal = ""
        var girisparola= ""

        binding.tvuyeol.setOnClickListener {
            var activity_uyeol = LayoutInflater.from(this).inflate(R.layout.activity_uyeol, null)
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setView(activity_uyeol)
            alertDialog.setNegativeButton("Kapat"){dialog, which->}
            alertDialog.show()
        }




    }
}