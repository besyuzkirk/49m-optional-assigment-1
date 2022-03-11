package com.example.simplecalculatormis_49m

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING

        var plusButton = findViewById<Button>(R.id.plus)
        var minusButton = findViewById<Button>(R.id.minus)
        var multipleButton = findViewById<Button>(R.id.multiple)
        var divisionButton = findViewById<Button>(R.id.division)

        var resultText = findViewById<TextView>(R.id.result)

        var field1 = findViewById<EditText>(R.id.numberOne)
        var field2 = findViewById<EditText>(R.id.numberTwo)



        plusButton.setOnClickListener {
            if(!field1.text.isNullOrEmpty() && !field2.text.isNullOrEmpty()) {
                resultText.setText(sumOfNumber(field1.text.toString().toInt(),field2.text.toString().toInt()).toString())
                field1.text.clear()
                field2.text.clear()
            } else {
                Toast.makeText(this,"Please Enter two numbers",Toast.LENGTH_SHORT).show()
            }

        }

        minusButton.setOnClickListener {
            if(!field1.text.isNullOrEmpty() && !field2.text.isNullOrEmpty()) {
                resultText.setText(differenceOfNumber(field1.text.toString().toInt(),field2.text.toString().toInt()).toString())
                field1.text.clear()
                field2.text.clear()
            } else {
                Toast.makeText(this,"Please Enter two numbers",Toast.LENGTH_SHORT).show()
            }
        }

        multipleButton.setOnClickListener {
            if(!field1.text.isNullOrEmpty() && !field2.text.isNullOrEmpty()) {
                resultText.setText(multiplyOfNumber(field1.text.toString().toInt(),field2.text.toString().toInt()).toString())
                field1.text.clear()
                field2.text.clear()
            } else {
                Toast.makeText(this,"Please Enter two numbers",Toast.LENGTH_SHORT).show()
            }
        }

        divisionButton.setOnClickListener {
            if(field1.text.isNullOrEmpty() || field2.text.isNullOrEmpty()) return@setOnClickListener Toast.makeText(this,"Please Enter two numbers",Toast.LENGTH_SHORT).show()
            if(field2.text.toString().toInt() != 0 ) {
                resultText.setText(df.format(divisonOfNumber(field1.text.toString().toDouble(),field2.text.toString().toDouble())))
                field1.text.clear()
                field2.text.clear()
            } else {
                Toast.makeText(this,"Number-2  cannot equal '0'",Toast.LENGTH_SHORT).show()
            }

        }

    }

    fun  sumOfNumber(number1 : Int   , number2 : Int ): Int {
        return number1 + number2
    }

    fun differenceOfNumber(number1 : Int   , number2 : Int ): Int {
        return number1 - number2
    }

    fun multiplyOfNumber(number1 : Int   , number2 : Int ): Int {
        return number1 * number2
    }

    fun divisonOfNumber(number1 : Double   , number2 : Double ): Double {
        return number1 / number2
    }
}