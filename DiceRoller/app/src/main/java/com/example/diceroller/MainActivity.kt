package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton : Button = findViewById(R.id.button)
        rollButton.setOnClickListener{
            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
            rollDice()
//            rollDice2()
        }
    }
    class Dice(val numSides: Int){
        fun roll(): Int {
            return (1..numSides).random()
        }
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage : ImageView = findViewById(R.id.imageView)

        val drawableResource =  if (diceRoll == 1) {
            R.drawable.dice_1
        } else if (diceRoll == 2) {
            R.drawable.dice_2
        } else if (diceRoll == 3) {
            R.drawable.dice_3
        } else if (diceRoll == 4) {
            R.drawable.dice_4
        } else if (diceRoll == 5) {
            R.drawable.dice_5
        } else{
            R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
    }
//    private fun rollDice2() {
//        val dice = Dice(6)
//        val diceRoll = dice.roll()
//        val resultTextView: TextView = findViewById(R.id.textView2)
//        resultTextView.text = diceRoll.toString()
//    }
}