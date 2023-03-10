package ca.ulaval.ima.tp2.ui.fragment

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import ca.ulaval.ima.tp2.R


class FormulaireFragment : Fragment() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val root = inflater.inflate(R.layout.fragment_formulaire, container, false)
        val prenom: EditText = root.findViewById(R.id.form_edit_prenom)
        val nom: EditText = root.findViewById(R.id.form_edit_nom)
        val naissance: EditText = root.findViewById(R.id.form_edit_naissance)
        val group: RadioGroup = root.findViewById(R.id.radioGroup)

        //val f: RadioButton = root.findViewById(R.id.sexe_f)
        val programme: Spinner = root.findViewById(R.id.form_edit_prog)
        ArrayAdapter.createFromResource(
            root.context,
            R.array.department,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            programme.adapter = adapter
                }
        programme.setOnItemSelectedListener(object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                val cck = parent.getItemAtPosition(position).toString()
                Log.i("prog",cck)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        })


        group.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
                if (p1 == R.id.sexe_m) {
                    Log.i("sexe", "homme")
                } else if (p1 == R.id.sexe_f) {
                    Log.i("sexe", "femme")
                }
            }
        }
        )



        naissance.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(
                root.context,
                { view, year, monthOfYear, dayOfMonth ->
                    val dateSelected = (year.toString() + "-" + (monthOfYear + 1) + "-" + dayOfMonth.toString())
                    naissance.setText(dateSelected)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }


        //prenom.hint ="Félix"
        //nom.hint="Côté"


        return root
    }
}