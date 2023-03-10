package ca.ulaval.ima.tp2

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment


class ProfilFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {



        val root = inflater.inflate(R.layout.fragment_mon_profil, container, false)
        //val stringProfilText: TextView = root.findViewById(R.id.text_mon_profil)
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

        //val mystring: String = intent.getParcelableExtra<ProfilUser>("Profil").prenom

        //stringProfilText.text =  "lsdfldsfjdslkf"
        //if (bundle != null) {
            //val textComplet: String = "Prénom:" + bundle.getParcelable<ProfilUser>("Profil")?.prenom
            //Log.i("parcelable",textComplet)
            //stringProfilText.text =  "lol"

        Log.i("parcelable","Fin")

        //var textComplet: String = "Prénom: " + intent.getParcelableExtra<Profil>("Profil")?.prenom + "\n"
        //textComplet += "Nom de famille: " + intent.getParcelableExtra<Profil>("Profil")?.nom + "\n"
        //textComplet += "Date de naissance: " + intent.getParcelableExtra<Profil>("Profil")?.naissance + "\n"
        //textComplet += "IDUL : " + intent.getParcelableExtra<Profil>("Profil")?.idul + "\n"
        //stringProfilText.text =  textComplet

        return root
    }
}