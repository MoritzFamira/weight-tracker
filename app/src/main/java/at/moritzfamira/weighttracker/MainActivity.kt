package at.moritzfamira.weighttracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.RecyclerView
import at.moritzfamira.weighttracker.adapter.WeightAdapter
import at.moritzfamira.weighttracker.data.Datasource
import at.moritzfamira.weighttracker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.fab.setOnClickListener() {
            if (navController.currentDestination?.id == R.id.listWeights) {
                //println("INLISTWEIGHTS")
                // better than before but not perfect solution
                navController.navigate(R.id.addWeight)
            }
        }
        Thread {
            val weightDataSet = Datasource().loadWeights(this)
            val recyclerView = findViewById<RecyclerView>(R.id.weightList)
            recyclerView.adapter = WeightAdapter(this,weightDataSet)
            recyclerView.setHasFixedSize(true)
        }.start()
        println("onCreate")
    }

    override fun onPause() {
        println("onPause")
        super.onPause()
    }

    override fun onRestart() {
        println("onRestart")
        super.onRestart()
    }

    public override fun onResume() {
        println("onResume")

        super.onResume()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}