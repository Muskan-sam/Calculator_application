package com.muskan.calculator_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clear.setOnClickListener {
            input.text = ""
            output.text = ""
        }

        bracket_left.setOnClickListener {
            input.text = addToInputText("(")
        }
        bracket_right.setOnClickListener {
            input.text = addToInputText(")")
        }
        b0.setOnClickListener {
            input.text = addToInputText("0")
        }
        b1.setOnClickListener {
            input.text = addToInputText("1")
        }
        b2.setOnClickListener {
            input.text = addToInputText("2")
        }
        b3.setOnClickListener {
            input.text = addToInputText("3")
        }
        b4.setOnClickListener {
            input.text = addToInputText("4")
        }
        b5.setOnClickListener {
            input.text = addToInputText("5")
        }
        b6.setOnClickListener {
            input.text = addToInputText("6")
        }
        b7.setOnClickListener {
            input.text = addToInputText("7")
        }
        b8.setOnClickListener {
            input.text = addToInputText("8")
        }
        b9.setOnClickListener {
            input.text = addToInputText("9")
        }
        dot.setOnClickListener {
            input.text = addToInputText(".")
        }
        mod.setOnClickListener {
            input.text = addToInputText("%")
        }
        division.setOnClickListener {
            input.text = addToInputText("÷")
        }
        multiply.setOnClickListener {
            input.text = addToInputText("×")
        }
        subtraction.setOnClickListener {
            input.text = addToInputText("-")
        }
        addition.setOnClickListener {
            input.text = addToInputText("+")
        }

        equals.setOnClickListener {
            showResult()
        }
    }
    private fun addToInputText(buttonValue: String): String {
        return "${input.text}$buttonValue"
    }

    private fun getInputExpression(): String {
        var expression = input.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                output.text = "Error"
                output.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                //Result
                output.text = DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        } catch (e: Exception) {
            output.text = "Error"
            output.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }
}