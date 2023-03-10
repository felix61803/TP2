package ca.ulaval.ima.tp2.ui.fragment
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class ProfilUser(
    val prenom: String,
    val nom: String,
    val naissance: String,
    val sexe: String,
    val programme: String): Parcelable