package com.example.tmdbapplication.presentation

import android.content.Intent
import com.example.tmdbapplication.R

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.tmdbapplication.databinding.ActivityMainBinding
import com.example.tmdbapplication.presentation.movie.MovieFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btMovies.setOnClickListener {
            val intent = Intent(this, MovieFragment::class.java)
            startActivity(intent)
        }
    }
}