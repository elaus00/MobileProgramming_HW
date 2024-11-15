package com.example.hw_4

import android.app.Activity
import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.hw_4.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 전달받은 검색어 표시
        val searchQuery = intent.getStringExtra(SearchManager.QUERY)
        binding.searchKeywordText.text = "검색어: $searchQuery"

        binding.returnButton.setOnClickListener {
            // 사용자가 입력한 걸 MainActivity로 전달
            val returnIntent = Intent().apply {
                putExtra("return_message", binding.userMessageEdit.text.toString())
            }
            setResult(Activity.RESULT_OK, returnIntent)
            finish()  // Activity 종료
        }
    }
}