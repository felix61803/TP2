package ca.ulaval.ima.tp2

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.ui.AppBarConfiguration


class MainActivity2 : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ca.ulaval.ima.tp2.R.layout.activity_main2)

        val drawerLayout: DrawerLayout = findViewById(ca.ulaval.ima.tp2.R.id.drawer_layout2)
        val myParcelable: Parcelable = intent.getParcelableExtra<ProfilUser>("Profil")
        val fragment = ProfilFragment()
        val args = Bundle()
        args.apply{
            this.putParcelable("profil",myParcelable)
        }
        fragment.arguments = args
        //val intent2= Intent(this, ProfilFragment::class.java)
        //intent2.putExtra("Profil",myParcelable)

        val transaction : FragmentTransaction= supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment, fragment)
        transaction.commit()
    }

    override fun onBackPressed() {
        val drawer = findViewById<View?>(ca.ulaval.ima.tp2.R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }

    }

}