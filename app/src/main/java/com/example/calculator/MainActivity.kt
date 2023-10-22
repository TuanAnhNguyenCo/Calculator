package com.example.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var number1 = "0"
    private var operator = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var pressed : String = ""

//    Action Buttons
        binding.btnCe.setOnClickListener {
            binding.result.text = "0"
            binding.press.text = ""
            pressed = ""
        }
        binding.btnC.setOnClickListener {
            handleClickClearBtn()
            binding.press.text = ""
            pressed = ""
        }
        binding.btnBs.setOnClickListener { handleClickBackspaceBtn() }
        binding.btnMinus.setOnClickListener {
            handleClickOperatorBtn("-")
            pressed += binding.btnMinus.text.toString()
            binding.press.text = pressed


        }
        binding.btnMul.setOnClickListener {
            handleClickOperatorBtn("*")
            pressed += binding.btnMul.text.toString()
            binding.press.text = pressed


        }
        binding.btnDevice.setOnClickListener {
            handleClickOperatorBtn("/")
            pressed += binding.btnDevice.text.toString()
            binding.press.text = pressed


        }
        binding.btnPlus.setOnClickListener {
            handleClickOperatorBtn("+")
            pressed += binding.btnPlus.text.toString()
            binding.press.text = pressed


        }
        binding.btnSign.setOnClickListener { handleClickChaneBtn() }
        binding.btnBalance.setOnClickListener { handleClickResultBtn() }


//    Number Buttons
        binding.btn0.setOnClickListener{
            handleClickNumberBtn("0")
            pressed += binding.btn0.text.toString()
            binding.press.text = pressed

        }
        binding.btn1.setOnClickListener {
            handleClickNumberBtn("1")
            pressed += binding.btn1.text.toString()
            binding.press.text = pressed


        }
        binding.btn2.setOnClickListener {
            handleClickNumberBtn("2")
            pressed += binding.btn2.text.toString()
            binding.press.text = pressed


        }
        binding.btn3.setOnClickListener {
            handleClickNumberBtn("3")
            pressed += binding.btn3.text.toString()
            binding.press.text = pressed


        }
        binding.btn4.setOnClickListener {
            handleClickNumberBtn("4")
            pressed += binding.btn4.text.toString()
            binding.press.text = pressed


        }
        binding.btn5.setOnClickListener {
            handleClickNumberBtn("5")
            pressed += binding.btn5.text.toString()
            binding.press.text = pressed


        }
        binding.btn6.setOnClickListener {
            handleClickNumberBtn("6")
            pressed += binding.btn6.text.toString()
            binding.press.text = pressed

        }
        binding.btn7.setOnClickListener {
            handleClickNumberBtn("7")
            pressed += binding.btn7.text.toString()
            binding.press.text = pressed

        }
        binding.btn8.setOnClickListener {
            handleClickNumberBtn("8")
            pressed += binding.btn8.text.toString()
            binding.press.text = pressed

        }
        binding.btn9.setOnClickListener {
            handleClickNumberBtn("9")
            pressed += binding.btn9.text.toString()
            binding.press.text = pressed

        }

    }

    private fun handleClickNumberBtn(number: String) {

        val textResult = binding.result
        if (textResult.text.toString().compareTo("0") == 0) {
            if (number.compareTo("0") != 0) {
                textResult.text = number
            }
        } else {
            val newResult = textResult.text.toString().plus(number)
            textResult.text = newResult
        }

    }

    private fun handleClickOperatorBtn(clickedBtn: String) {
        number1 = binding.result.text.toString()
        binding.result.text = "0"
        operator = clickedBtn
    }

    private fun handleClickResultBtn() {
        if (operator.compareTo("/") == 0 && binding.result.text.toString().toInt() == 0) {
            return
        }

        val result = when (operator) {
            "+" -> number1.toInt() + binding.result.text.toString().toInt()
            "-" -> number1.toInt() - binding.result.text.toString().toInt()
            "*" -> number1.toInt() * binding.result.text.toString().toInt()
            "/" -> number1.toInt() / binding.result.text.toString().toInt()
            else -> binding.result.text.toString().toInt()
        }
        binding.result.text = result.toString()
        number1 = "0"

    }

    private fun handleClickClearBtn() {
        number1 = ""
        operator = ""
        binding.result.text = "0"
    }

    private fun handleClickBackspaceBtn() {
        if (binding.result.text.toString().length == 1) {
            binding.result.text = "0"
        } else {
            binding.result.text = binding.result.text.toString().dropLast(1)
        }
    }

    private fun handleClickChaneBtn() {
        val result = 0 - binding.result.text.toString().toInt()
        binding.result.text = result.toString()
    }

}