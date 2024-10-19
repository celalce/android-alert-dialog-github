package com.celalalbayrak.alertdialog

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
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

        var girisemail = ""
        var girisparola= ""

        binding.tvuyeol.setOnClickListener {
            var activity_uyeol = LayoutInflater.from(this).inflate(R.layout.activity_uyeol, null)
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setView(activity_uyeol)
            alertDialog.setNegativeButton("Kapat"){dialog, which->}
            alertDialog.show()

        //yeni üye kaydı yapalım
        val kaydetbutton = activity_uyeol.findViewById<TextView>(R.id.kaydetbutton)
            kaydetbutton.setOnClickListener {
                val etkayitolemail = activity_uyeol.findViewById<TextView>(R.id.etkayitolemail).text.toString().trim()
                val etkayitolparola = activity_uyeol.findViewById<TextView>(R.id.etkayitolparola).text.toString().trim()

                girisemail = etkayitolemail.toString()
                girisparola = etkayitolparola.toString()
                println(girisemail)
                println(girisparola)

                Toast.makeText(applicationContext, "Başarılı",Toast.LENGTH_LONG ).show()


            }
    } //fonksiyon burda bitiyor

 // giriş işlemi yapmak için yeni bir binding ile işlemleri yapıyoruz...

    binding.girisyapbutton.setOnClickListener {
        val etemail = binding.etemail.text.toString().trim()
        val etparola = binding.etparola.text.toString().trim()
        if (TextUtils.isEmpty(etemail)){
            binding.etemail.error ="Lüften emailinizi giriniz"
        }
        if (TextUtils.isEmpty(etparola)){
            binding.etparola.error = "Lütfen Parolanızı giriniz"
            }
        else{
                //eger giris etemail ve etparalo kayıtlı olan(girisemal ve girisparola) kayıtla eşleşiyorsa giris başarılı if çalışacaktır.
                if ((girisemail == etemail) && (girisparola == etparola)){
                    var alertDialog = AlertDialog.Builder(this)
                    alertDialog.setTitle("Başarlı")
                    alertDialog.setMessage("İşleminiz Başarıyla gerçekleşmiştir")
                    alertDialog.setNegativeButton("kapat"){dialog, which->}
                    alertDialog.show()
                }
                else   // giriş işlemi başarısız ise else çalışacaktır.
                {
                    var alertDialog = AlertDialog.Builder(this)
                    alertDialog.setTitle("Hatalı")
                    alertDialog.setMessage("İşleminiz Başarısız")
                    alertDialog.setNegativeButton("kapat"){dialog, which->}
                    alertDialog.show()
                }

        }
    }



    }
}