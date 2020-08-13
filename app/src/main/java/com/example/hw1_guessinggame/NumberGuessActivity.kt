package com.example.hw1_guessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_number_guess.*
import java.util.*

class NumberGuessActivity : AppCompatActivity() {
    var numberRandom = 0
    var attempts = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_guess)
        randomNumber()
    }
    fun doClickNewNumberRandom(v: View) {
        attempts = 0
        randomNumber()
        numeroValidar.setText("")
        avisoValidacion.text = ""

    }

    fun doClickValidateNumber(v: View) {
        attempts++
        // Toast.makeText(this,"Número validado es:  ${numeroValidar.text.toString()}",Toast.LENGTH_SHORT).show()
        println("numero "+numeroValidar.text)
        println(numeroValidar.text.isEmpty())
        if (numeroValidar.text.isEmpty()) {
            println("isNotEmpty")
            avisoValidacion.text = "DIGITE UN NÚMERO"
        } else {

            if (numeroValidar.text.toString().toInt() > numberRandom) {
                avisoValidacion.text =
                        "El ${numeroValidar.text.toString()} es mayor que el número generado"
            } else if (numeroValidar.text.toString().toInt() < numberRandom) {
                avisoValidacion.text =
                        "El ${numeroValidar.text.toString()} es menor que el número generado"
            } else {
                avisoValidacion.text = "Felicidades, adivino el número en $attempts intentos"
            }
        }


    }

    private fun randomNumber() {
        var random = Random()
        numberRandom = random.nextInt(1000)
        println("$numberRandom...$attempts")
    }
}