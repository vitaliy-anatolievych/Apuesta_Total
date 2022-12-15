package com.doriangrei.apueastawinapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.doriangrei.apueastawinapp.databinding.ActivityMainBinding
import com.doriangrei.apueastawinapp.screens.GameFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_container, GameFragment.newInstance(24), GameFragment::class.simpleName)
            commit()
        }
    }
}