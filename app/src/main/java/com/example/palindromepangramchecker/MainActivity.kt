package com.example.palindromepangramchecker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputText: EditText = findViewById((R.id.editText2))
        val palindromeButton: Button = findViewById(R.id.button)
        val pangramButton: Button = findViewById(R.id.button2)

        palindromeButton.setOnClickListener {
            if (inputText.length() > 2) {
                if (isPalindrome(inputText.text.toString())) {
                    openPalindromeActivity()
                } else {
                    openNotPalindromeActivity()
                }
            } else {
                openInvalidActivity()
            }
        }

        pangramButton.setOnClickListener {
            if (inputText.length() > 2) {
                if (isPangram(inputText.text.toString())) {
                    openPangramActivity()
                } else {
                    openNotPangramActivity()
                }
            } else {
                openInvalidActivity()
            }
        }
    }

    private fun isPalindrome(text: String): Boolean {
        val reverseText = text.reversed()
        return text == reverseText
    }

    private fun isPangram(text: String): Boolean {
        val lowerCase = text.lowercase()
        return ('a'..'z').all {it in lowerCase}
    }

    private fun openNotPalindromeActivity() {
        val notPalindromeIntent = Intent(this, NotPalindromeActivity::class.java)
        startActivity(notPalindromeIntent)
    }

    private fun openPalindromeActivity() {
        val palindromeIntent = Intent(this, PalindromeActivity::class.java)
        startActivity(palindromeIntent)
    }

    private fun openNotPangramActivity() {
        val notPangramIntent = Intent(this, NotPangramActivity::class.java)
        startActivity(notPangramIntent)
    }

    private fun openPangramActivity() {
        val pangramIntent = Intent(this, PangramActivity::class.java)
        startActivity(pangramIntent)
    }

    private fun openInvalidActivity() {
        val invalidIntent = Intent(this, InvalidActivity::class.java)
        startActivity(invalidIntent)
    }
}