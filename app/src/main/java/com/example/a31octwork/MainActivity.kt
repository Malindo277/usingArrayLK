package com.example.a31octwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var txtNumber: EditText? = null
    private var lblDispArr: TextView? = null
    private var lblDispAns: TextView? = null

    private var intNumbers = Array<Int>(10) { 0 }

    private var intCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEnter = findViewById<Button>(R.id.btnEnter)
        val btnSumAvg = findViewById<Button>(R.id.btnSumAvg)
        val btnHighLow = findViewById<Button>(R.id.btnHighLow)
        val btnClear = findViewById<Button>(R.id.btnClear)

        txtNumber = findViewById(R.id.etNumber)
        lblDispArr = findViewById(R.id.tvDispArr)
        lblDispAns = findViewById(R.id.tvDispAns)

        btnEnter.setOnClickListener {
            enterValues()

        }

    }

    private fun enterValues() {
        if (intCount <= 9){
        intNumbers[intCount] = txtNumber.toString().toInt()
            intCount++
    }else {
            lblDispAns.text = "Reached limit for numbers"
        }
    }
    private fun calcSumAvg(){
        var intSum: Int = 0
        var dblAvg: Double = 0.0

        for (index in 0..(intCount - 1)){
            intSum += intNumbers[index]
       }
        dblAvg = (intSum.toDouble() / intCount.toDouble())
        lblDispAns.text = "The sum is" + "and the average is" + dblAvg
    }
    private fun calcHighLow(){

        var intHigh: Int = -32767
        var intLow: Int = 32767

        for (index in 0..(intCount- 1)) {
            if (intNumbers[index]>intHigh){
                intHigh = intNumbers[index]
            }
            if (intNumbers[index]< intLow){
                intLow = intNumbers[index]
            }
        }
        lblDispAns.text = "The highest " + intHigh + "the lowest " + intLow


    }
    private fun clearEverything(){
        for (index in 0..9){
            intNumbers[index] = 0
        }
    }
    private fun clearOnlyThisNumber() 
}