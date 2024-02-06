package edu.temple.inclassuiacvitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val displayTextView = findViewById<TextView>(R.id.textDisplay)

        /* TODO Step 1: Populate this array */
        val evenNumbers = mutableListOf<Int>()

        for (i in 2..100 step 2){
            evenNumbers.add(i)
        }
        val numbersArray = evenNumbers.toIntArray()

        /* TODO Step 2: Create adapter to display items from array in Spinner */
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, numbersArray.toList())
        spinner.adapter = adapter


        // TODO Step 3: Change TextView's text size to the number selected in the Spinner */
        spinner.onItemSelectedListener = object: OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                p1?.run{
                    val textSize = (this as TextView).textSize
                    displayTextView.textSize = textSize
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

    }
}