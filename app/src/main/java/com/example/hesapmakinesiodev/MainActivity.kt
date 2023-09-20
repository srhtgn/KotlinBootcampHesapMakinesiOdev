package com.example.hesapmakinesiodev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.hesapmakinesiodev.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var girilen = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttons = listOf(
            binding.button0,
            binding.button1,
            binding.button2,
            binding.button3,
            binding.button4,
            binding.button5,
            binding.button6,
            binding.button7,
            binding.button8,
            binding.button9,
            binding.buttonTopla
        )

        buttons.forEach { button ->
            button.setOnClickListener {
                val deger = button.text.toString()
                girilen.add(deger)
                degerGir()
            }
        }

        binding.buttonSonuc.setOnClickListener {
            sonuc()
        }

        binding.buttonSil.setOnClickListener {
            sil()
        }
    }

    private fun degerGir() {
        val girilenDeger = girilen.joinToString("")
        binding.textView.text = girilenDeger
    }

    private fun sonuc() {
        val sayilar = girilen.joinToString("")
        val sayiDizisi = sayilar.split("+").filter { it.isNotEmpty() }
        var sonuc = 0.0

        for (sayi in sayiDizisi) {
            sonuc += sayi.toDoubleOrNull() ?: 0.0
        }

        binding.textView.text = sonuc.toString()
    }

    private fun sil() {
        girilen.clear()
        binding.textView.text = ""
    }

}
