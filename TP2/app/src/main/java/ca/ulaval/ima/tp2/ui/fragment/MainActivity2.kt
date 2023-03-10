package ca.ulaval.ima.tp2.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.ui.AppBarConfiguration
import ca.ulaval.ima.tp2.R
import ca.ulaval.ima.tp2.ui.fragment.FormulaireFragment


class MainActivity2 : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val toolbar: Toolbar = findViewById(R.id.toolbar2)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout2)

        val myParcelable: Parcelable = intent.getParcelableExtra<ProfilUser>("Profil")
        val fragment = ProfilFragment()
        val args = Bundle()
        args.apply{
            this.putParcelable("profil",myParcelable)
        }
        fragment.arguments = args
        title="Mon Profil"
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        val transaction : FragmentTransaction= supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment, fragment)
        transaction.commit()
    }

    override fun onBackPressed() {
        title = "TP2"
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("return","1")
        startActivity(intent)
        //val transaction : FragmentTransaction= supportFragmentManager.beginTransaction()
        //transaction.replace(R.id.nav_host_fragment, FormulaireFragment())
        //transaction.commit()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}