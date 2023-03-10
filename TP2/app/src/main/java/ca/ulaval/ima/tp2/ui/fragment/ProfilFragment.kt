package ca.ulaval.ima.tp2.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import ca.ulaval.ima.tp2.R


class ProfilFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {



        val root = inflater.inflate(R.layout.fragment_mon_profil, container, false)
        val strPrenom : TextView=root.findViewById(R.id.prenom)
        val strNom : TextView=root.findViewById(R.id.nom)
        val strNaissance : TextView=root.findViewById(R.id.naissance)
        val strSexe : TextView=root.findViewById(R.id.leSexe)
        val strProgramme : TextView=root.findViewById(R.id.programme)

        val bund = this.arguments
        if (bund != null){
            val monParcel = bund?.getParcelable<ProfilUser>("profil")
            strPrenom.text = "Prénom: " + monParcel?.prenom
            strNom.text = "Nom: " + monParcel?.nom
            strNaissance.text = "Date de naissance: " + monParcel?.naissance
            strSexe.text = "Sexe: " + monParcel?.sexe
            strProgramme.text = "Programme: " + monParcel?.programme
        }

        Log.i("parcelable","Fin")

        return root
    }
}