//package com.execmodule.helloworld
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import androidx.core.view.allViews
//import androidx.fragment.app.Fragment
//import com.example.myapplication.R
//
//class MainFragment: Fragment() {
////    override fun onCreateView(inflater: LayoutInflater,
////                              container: ViewGroup?, savedInstanceState: Bundle?): View?
////            = inflater.inflate(R.layout.main_fragment, container, false).apply {
////        val button = Button(this.context)
////        button.text = getString(R.string.button_text)
////    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        this.activity?.setContentView(R.layout.main_fragment)
//        this.activity.
//    }
//}

package com.execmodule.helloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

class MainFragment : Fragment() {

    companion object {
        fun newInstance(param1: String, param2: String): MainFragment {
            return MainFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val mylayout = LinearLayout(container?.context)
        val lp = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

        val mybutton = Button(container?.context)
        mybutton.text = "hhhhhh"
        mybutton.layoutParams = lp
        mylayout.addView(mybutton)

        return mylayout
    }
}
