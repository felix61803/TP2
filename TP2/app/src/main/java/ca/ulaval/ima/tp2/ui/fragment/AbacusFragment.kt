package ca.ulaval.ima.tp2.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import ca.ulaval.ima.tp2.R


class AbacusFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_abacus, container, false)
        val val1: TextView = root.findViewById(R.id.val1)
        val val2: TextView = root.findViewById(R.id.val2)
        val val3: TextView = root.findViewById(R.id.val3)
        val seekbar1: SeekBar = root.findViewById(R.id.seekBar1)
        val seekbar2: SeekBar = root.findViewById(R.id.seekBar2)
        val seekbar3: SeekBar = root.findViewById(R.id.seekBar3)
        var myval1 = 1
        var myval2 = 2

        
        seekbar1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                val1.text = (p1+1).toString()
                myval1 = p1+1
                val multip = (p1+1)*myval2
                seekbar3.setProgress(multip)
                val3.text = multip.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })

        seekbar2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                val2.text = (p1+2).toString()
                myval2 = p1+2
                val multip = myval1*(p1+2)
                seekbar3.setProgress(multip)
                val3.text = multip.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
        seekbar3.setOnTouchListener(OnTouchListener { v, event -> true })


        return root
    }
}