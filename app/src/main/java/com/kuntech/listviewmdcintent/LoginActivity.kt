package com.kuntech.listviewmdcintent

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kuntech.listviewmdcintent.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


    binding.btnLogin.setOnClickListener {
        val username = binding.etUsernameText.text.toString()
        val password = binding.etPasswordText.text.toString()
        if(username == USERNAME && password == PASSWORD){
            setUpIntent()
        }
        else {
            Toast.makeText(this, "Username or/and Password does not match", Toast.LENGTH_LONG)
                .show()
            return@setOnClickListener
        }

    }

    }


    companion object{
        val USERNAME = "adefabiyusuf@gmail.com"
        val PASSWORD = "ikeoluwa"
    }

    private fun setUpIntent(){
        Intent(this,MainActivity::class.java).also {
            startActivity(it)
        }

    }
}