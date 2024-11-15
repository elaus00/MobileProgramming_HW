package com.example.hw_4

import android.app.Activity
import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.hw_4.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    // Activity Result API를 사용한 콜백 등록
    private val searchLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // SubActivity로부터 반환된 메시지 처리
            val returnedMessage = result.data?.getStringExtra("return_message") ?: ""
            // Snackbar로 메시지 표시
            Snackbar.make(binding.root, returnedMessage, Snackbar.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {
            val searchQuery = binding.searchEditText.text.toString()
            if (searchQuery.isNotEmpty()) {
                // implicit intent 생성
                val searchIntent = Intent(Intent.ACTION_WEB_SEARCH).apply {
                    putExtra(SearchManager.QUERY, searchQuery)
                }

                // Chooser 생성
                val chooserIntent = Intent.createChooser(searchIntent, "Search with...")
                searchLauncher.launch(chooserIntent)
            }
        }
    }
}