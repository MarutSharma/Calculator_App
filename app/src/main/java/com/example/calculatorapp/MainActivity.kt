package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.calculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAdd.setOnClickListener { calculateAddition() }
        binding.btnMinus.setOnClickListener { calculateSubtraction() }
        binding.btnDivide.setOnClickListener { calculateDivision() }
        binding.btnMultiply.setOnClickListener { calculateMultiplication() }
        binding.btnRating.setOnClickListener { countRating() }
        binding.btnClear.setOnClickListener { clearAll() }

    }

    private fun clearAll() {
        binding.editInput1.setText("")
        binding.editInput2.setText("")
        binding.textResult.text = ""
    }


    private fun calculateMultiplication() {
        if (inputIsNotEmpty()) {
            val textField1 = binding.editInput1.text.toString().toDouble()
            val textField2 = binding.editInput2.text.toString().toDouble()
            val sum = textField1 * textField2
            binding.textResult.text = sum.toString()
        }
    }

    private fun calculateDivision() {
        if (inputIsNotEmpty()) {
            val textField1 = binding.editInput1.text.toString().toDouble()
            val textField2 = binding.editInput2.text.toString().toDouble()
            val sum = textField1 / textField2
            binding.textResult.text = sum.toString()
        }
    }

    private fun inputIsNotEmpty(): Boolean {
        var b = true
        if (binding.editInput1.text.toString().isEmpty()) {
            binding.editInput1.error = "Required"
            binding.editInput1.requestFocus()
            b = false
        }
        if (binding.editInput2.text.toString().isEmpty()) {
            binding.editInput2.error = "Required"
            binding.editInput2.requestFocus()
            b = false
        }
        return b
    }

    private fun countRating() {
        binding.btnRating.visibility = View.INVISIBLE
        val msg = binding.ratingBar2.rating.toString()
        Toast.makeText(this, "You Rated $msg Stars", Toast.LENGTH_SHORT).show()
    }

    private fun calculateSubtraction() {
        if (inputIsNotEmpty()) {
            val textField1 = binding.editInput1.text.toString().toDouble()
            val textField2 = binding.editInput2.text.toString().toDouble()
            val sum = textField1 - textField2
            binding.textResult.text = sum.toString()
        }
    }

    private fun calculateAddition() {
        if (inputIsNotEmpty()) {
            val textField1 = binding.editInput1.text.toString().toDouble()
            val textField2 = binding.editInput2.text.toString().toDouble()
            val sum = textField1 + textField2
            binding.textResult.text = sum.toString()
        }
    }
}

