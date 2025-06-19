package com.example.string

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.*
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var inputString: EditText
    private lateinit var inputN: EditText
    private lateinit var inputChar: EditText
    private lateinit var replaceButton: Button
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputString = findViewById(R.id.inputString)
        inputN = findViewById(R.id.inputN)
        inputChar = findViewById(R.id.inputChar)
        replaceButton = findViewById(R.id.replaceButton)
        resultText = findViewById(R.id.resultText)

        replaceButton.setOnClickListener {
            val original = inputString.text.toString()
            val n = inputN.text.toString().toIntOrNull()
            val ch = inputChar.text.toString()

            if (original.isNotEmpty() && n != null && ch.isNotEmpty()) {
                val safeN = n.coerceAtMost(original.length)
                val replaced = ch[0].toString().repeat(safeN) + original.substring(safeN)
                resultText.text = "Результат: $replaced"
            } else {
                resultText.text = "Ошибка: заполните все поля"
            }
        }
    }
}