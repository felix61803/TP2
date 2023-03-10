package ca.ulaval.ima.tp2.ui.fragment


import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import ca.ulaval.ima.tp2.R


class InternetFragment : Fragment() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {



        val root = inflater.inflate(ca.ulaval.ima.tp2.R.layout.fragment_internet, container, false)
        val connection: TextView = root.findViewById(ca.ulaval.ima.tp2.R.id.connection)
        val button: Button = root.findViewById(ca.ulaval.ima.tp2.R.id.button_status_internet)
        val circle: ImageView = root.findViewById(R.id.image_circle)
        button.setOnClickListener(View.OnClickListener {
            val connectivityManager =
                context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (connectivityManager != null) {
                val capabilities =
                    connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
                if (capabilities != null) {
                    if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                        Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                        connection.text = "LTE"
                        circle.setImageResource(R.drawable.circle_green)
                    } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                        Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                        connection.text = "WIFI"
                        circle.setImageResource(R.drawable.circle_green)                    }

                }
                else {
                    connection.text = "aucune connection"
                    Log.i("Internet", "aucune connexion")
                    circle.setImageResource(R.drawable.circle_red)}
}
        })


        return root
    }
}