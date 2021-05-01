package com.kuntech.listviewmdcintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kuntech.listviewmdcintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
     private var binding: ActivityMainBinding? = null
    var adapter: AppAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setUpFact()
    }

    private fun setUpFact (){
        adapter = AppAdapter(this,DummyData.appFacts)
        binding?.appListView?.adapter = adapter
    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}