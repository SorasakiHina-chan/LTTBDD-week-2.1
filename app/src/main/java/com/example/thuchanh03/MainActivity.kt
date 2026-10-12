package com.example.thuchanh03

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number1 = findViewById<EditText>(R.id.number1)
        val number2 = findViewById<EditText>(R.id.number2)
        val resultText = findViewById<TextView>(R.id.resultText)

        findViewById<Button>(R.id.addButton).setOnClickListener { calculate(number1, number2, resultText, "+") }
        findViewById<Button>(R.id.subButton).setOnClickListener { calculate(number1, number2, resultText, "-") }
        findViewById<Button>(R.id.mulButton).setOnClickListener { calculate(number1, number2, resultText, "*") }
        findViewById<Button>(R.id.divButton).setOnClickListener { calculate(number1, number2, resultText, "/") }
    }

    private fun calculate(input1: EditText, input2: EditText, result: TextView, operation: String) {
        val a = input1.text.toString().toDoubleOrNull()
        val b = input2.text.toString().toDoubleOrNull()

        if (a == null || b == null) {
            Toast.makeText(this, "Vui lòng nhập đủ hai số", Toast.LENGTH_SHORT).show()
            return
        }
        if (operation == "/" && b == 0.0) {
            result.text = "Kết quả: Không thể chia cho 0"
            return
        }

        val answer = when (operation) {
            "+" -> a + b
            "-" -> a - b
            "*" -> a * b
            else -> a / b
        }

        val formattedResult = if (answer % 1 == 0.0) {
            answer.toLong().toString()
        } else {
            answer.toString()
        }
        result.text = "Kết quả: $formattedResult"
    }
}
