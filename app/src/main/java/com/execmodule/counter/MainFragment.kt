package com.execmodule.counter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

class MainFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val layout = LinearLayout(container?.context)
        val layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

        var count = 0
        val button = Button(container?.context)
        button.text = "Count: $count"
        button.layoutParams = layoutParams
        button.setOnClickListener {
            count++
            button.text = "Count: $count"
        }
        layout.addView(button)

        return layout
    }
}
