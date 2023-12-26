package com.sahin.runnable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.sahin.runnable.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    var runnable : Runnable = Runnable {}
    var handler : Handler = Handler()
    var number = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Runnable -> kullanıcı arayüzünü bloklamadan işlemlerimizi yapmamamıza olanak sağlar.
        // Handler Sınıfı runnable objelerini yönetmemizi ve kullanmamızı sağlayan bir sınıf.


    }
    fun start(view : View){
        number = 0
        binding.button.isEnabled = false

        runnable = object  : Runnable{
            override fun run() {
                number = number + 1
                binding.textView.text = "Time: ${number}"
                // Yapılacak işlemi 1 saniye bekletir arka planda.
                handler.postDelayed(runnable,1000)
            }


        }
        // runnable çalışır.
        handler.post(runnable)

    }
    fun stop(view : View){
        binding.button.isEnabled = true
        // runnable durdurur.
        handler.removeCallbacks(runnable)
        binding.textView.text = "Time: 0"


    }
}