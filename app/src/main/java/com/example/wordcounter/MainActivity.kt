package com.example.wordcounter

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var editTextInput: EditText
    private lateinit var spinnerOption: Spinner
    private lateinit var buttonCalculate: Button
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            editTextInput = findViewById(R.id.editTextInput)
            spinnerOption = findViewById(R.id.spinnerOption)
            buttonCalculate = findViewById(R.id.buttonCalculate)
            textViewResult = findViewById(R.id.textViewResult)

            ArrayAdapter.createFromResource(
                this,
                R.array.count_options,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerOption.adapter = adapter
            }

            buttonCalculate.setOnClickListener {
                calculateResult()
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Error initializing app: ${e.message}", Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    private fun calculateResult() {
        try {
            val inputText = editTextInput.text.toString()
            if (inputText.isEmpty()) {
                Toast.makeText(this, R.string.empty_input_message, Toast.LENGTH_SHORT).show()
                return
            }

            val selectedOption = spinnerOption.selectedItem.toString()
            val calculator = TextCalculator()

            val result = if (selectedOption == getString(R.string.option_words)) {
                calculator.getWordsCount(inputText)
            } else {
                calculator.getCharCount(inputText)
            }

            textViewResult.text = getString(R.string.result_format, result)
        } catch (e: Exception) {
            Toast.makeText(this, "Error calculating result: ${e.message}", Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }
}