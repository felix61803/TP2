package ca.ulaval.ima.tp2.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import ca.ulaval.ima.tp2.R

class FormulaireFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {



        val root = inflater.inflate(R.layout.fragment_formulaire, container, false)
        val textView: TextView = root.findViewById(R.id.form_prenom)

        return root
    }
}