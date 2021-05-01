package com.kuntech.listviewmdcintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kuntech.listviewmdcintent.databinding.ActivityDetailBinding
import com.kuntech.listviewmdcintent.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    private var binding: ActivityDetailBinding? = null
    private var logo = 0
    private var name: String? = null
    private var detail: String?  = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        logo = intent.getIntExtra(AppAdapter.LOGO_EXTRA,0)
        name = intent.getStringExtra(AppAdapter.NAME_EXTRAS)
        detail = intent.getStringExtra(AppAdapter.FACT_EXTRAS)
        setUpFactDetail()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    private fun setUpFactDetail(){
        binding?.detailNameTv?.text = detail
        binding?.detailImageLogo?.setImageResource(logo)
        title = name
    }
}