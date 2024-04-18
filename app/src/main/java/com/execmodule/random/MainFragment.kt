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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val layout = LinearLayout(container?.context)
        val layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

        val button = Button(container?.context)
        button.text = "Generate random numer"
        button.layoutParams = layoutParams
        button.setOnClickListener {
            // Generate a random number
            val randomNumber = Random.nextInt(1, 101)

            // Create a TextView to display the random number
            val textView = TextView(requireContext())
            textView.text = randomNumber.toString()
            textView.textSize = 48f
            textView.gravity = Gravity.CENTER

            // Clear existing views and add the TextView to the layout
            layout.removeAllViews()
            layout.addView(textView)
        }

        layout.addView(button)

        return layout
    }
}