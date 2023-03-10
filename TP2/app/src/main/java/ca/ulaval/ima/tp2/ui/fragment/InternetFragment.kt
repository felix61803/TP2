package ca.ulaval.ima.tp2.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import ca.ulaval.ima.tp2.R

class InternetFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {



        val root = inflater.inflate(R.layout.fragment_internet, container, false)
        val textView: TextView = root.findViewById(R.id.text_internet)

        return root
    }
}