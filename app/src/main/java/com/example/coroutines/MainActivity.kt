package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = MainViewModel(Repository.Base())
        val textView = findViewById<TextView>(R.id.textView)
        viewModel.observe(this) {
            textView.text = it
        }
        viewModel.load()
    }
}