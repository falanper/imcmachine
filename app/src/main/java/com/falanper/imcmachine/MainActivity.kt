package com.falanper.imcmachine

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var weightEditText: EditText
    private lateinit var heightEditText: EditText
    private lateinit var calcButton: Button
    private lateinit var resultText: TextView
    private lateinit var personImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weightEditText = findViewById(R.id.weight_edit_text)
        heightEditText = findViewById(R.id.height_edit_text)
        resultText = findViewById(R.id.result_text_view)
        calcButton = findViewById(R.id.calc_button)
        personImageView = findViewById(R.id.person_image_view)

        calcButton.setOnClickListener {
            if (weightEditText.text.isNotEmpty() && heightEditText.text.isNotEmpty()) {
                calculateBMI()
            } else {
                Toast.makeText(this, "Please insert the data", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun calculateBMI() {

        val weight = weightEditText.text.toString().toFloat()
        val height = heightEditText.text.toString().toFloat()

        val myIMC = weight / (height * height)

        resultText.text = myIMC.toString()

        if (myIMC < 18.5) {
            personImageView.setImageResource(R.drawable.ic_underweight)
        } else if (myIMC >= 18.5 && myIMC < 25) {
            personImageView.setImageResource(R.drawable.ic_healthy)
        } else if (myIMC >= 25 && myIMC < 30) {
            personImageView.setImageResource(R.drawable.ic_overweight)
        } else {
            personImageView.setImageResource(R.drawable.ic_obesity)
        }
    }
}
