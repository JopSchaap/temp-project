package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment


class MainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mylayout = LinearLayout(container!!.context)
        val lp = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
//        val mybutton = Button(container.context)
//        mybutton.text = "hhhhhh"
//        mybutton.setLayoutParams(lp)
//        mylayout.addView(mybutton)

        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.duckduckgo.com"))
        startActivity(browserIntent)

        return mylayout
    }

    companion object {
        fun newInstance(param1: String?, param2: String?): MainFragment {
            return MainFragment()
        }
    }
}
