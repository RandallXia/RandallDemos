package com.randalldev.demos

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.randalldev.demos.databinding.ActivityMainBinding
import com.randalldev.fiteditor.FitInitActivity
import com.randalldev.injectaweme.SetupActivity

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tvGoInjectAweme.setOnClickListener {
            startActivity(Intent(this, SetupActivity::class.java))
        }

        binding.tvGoFitEditor.setOnClickListener {
            startActivity(Intent(this, FitInitActivity::class.java))
        }
    }
}