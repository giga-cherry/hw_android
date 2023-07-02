package com.example.skvortsova_task1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.NumberFormatException
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private var string:String = ""
        set(value) {
            field = if(value.equals("error"))
                "Incorrect input"
            else "Answer: $value"
            textView?.text = field
        }
    private var textView: TextView? = null
    private var nameIn: EditText? = null
    private var heightIn: EditText? = null
    private var weightIn: EditText? = null
    private var ageIn: EditText? = null
    private var button: Button? = null;

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        nameIn = findViewById(R.id.editTextName);
        heightIn = findViewById(R.id.editTextHeight);
        weightIn = findViewById(R.id.editTextWeight);
        ageIn = findViewById(R.id.editTextAge);
        button = findViewById(R.id.button);
        button?.setOnClickListener{
            pressTheButton()
        }

    }

    private fun pressTheButton(){
        val name:String = nameIn?.text.toString()
        string = try {
            val height = heightIn?.text.toString().toInt()
            val weight = weightIn?.text.toString().toDouble()
            val age = ageIn?.text.toString().toInt()
            if(name.length in 1..50&&height in 1..249&&weight>0&&weight<250&&age in 1..149){
                val bmi=weight/(height*height/10000);
                name+"'s BMI is "+ (bmi * 10.0).roundToInt() / 10.0+", "+validateBMI(age, bmi)
            } else{
                "error"
            }
        } catch (e:NumberFormatException){
            "error"
        }
    }

    private fun validateBMI(age: Int, bmi: Double): String {
        var answer: String
        var coef: Double
        if (age<25) {
            coef = 27.5
        }else{
            coef=28.0
        }
        if (bmi>coef){
            answer="you have obesity"
        } else{
            answer="you don’t have obesity"
        }
        return answer
    }

}