package com.example.myapplication

import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.util.Calendar
import java.util.Locale





class MainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mylayout = RelativeLayout(container!!.context)
        mylayout.gravity = Gravity.CENTER
        val lp = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        val mybutton = TextView(container.context)

        val date  = Calendar.getInstance().getTime();
        val df = SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault())
        mybutton.text = df.format(date)


        mybutton.setLayoutParams(lp)
        mybutton.gravity = Gravity.CENTER
        mybutton.textSize = 32.0F
        mylayout.addView(mybutton)

        return mylayout
    }

    companion object {
        fun newInstance(param1: String?, param2: String?): MainFragment {
            return MainFragment()
        }
    }
}
