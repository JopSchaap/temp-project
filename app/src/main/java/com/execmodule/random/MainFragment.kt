package com.execmodule.random

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlin.random.Random

class MainFragment : Fragment() {

    private lateinit var randomNumberTextView: TextView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val layout = LinearLayout(container?.context)
        layout.orientation = LinearLayout.VERTICAL
        layout.gravity = Gravity.CENTER

        // Create the button
        val button = Button(requireContext())
        button.text = "Generate random number"
        button.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        button.setOnClickListener {
            // Generate a random number
            val randomNumber = Random.nextInt(1, 101)

            // Update the TextView with the random number
            randomNumberTextView.text = randomNumber.toString()
        }

        // Add the button to the layout
        layout.addView(button)

        // Create the TextView to display the random number
        randomNumberTextView = TextView(requireContext())
        randomNumberTextView.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        randomNumberTextView.textSize = 48f
        randomNumberTextView.gravity = Gravity.CENTER
        randomNumberTextView.text = " "

        // Add the TextView to the layout
        layout.addView(randomNumberTextView)

        // Return the parent layout as the fragment's view
        return layout
    }
}