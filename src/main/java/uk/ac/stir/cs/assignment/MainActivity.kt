package uk.ac.stir.cs.assignment

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.setDefaultNightMode
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.switchmaterial.SwitchMaterial
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {

    //An instance of the database
    var dbHelper: ConvertDB? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        setSupportActionBar(toolbar)

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)

        //The 2 tabs  used to move between fragments and their icons
        tabLayout.addTab(tabLayout.newTab())
        tabLayout.addTab(tabLayout.newTab())
        tabLayout.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_home_24)
        tabLayout.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_compare_arrows_24)
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        //Use the PageAdaptor class to move between views
        val viewPager = findViewById<ViewPager>(R.id.pager)
        val adaptor = PagerAdaptor(supportFragmentManager, tabLayout.tabCount)
        viewPager.adapter = adaptor
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        //Use a switch to move between dark and light mode
            //--Currently not fully functional, tells user the switch has occurred but no visible change in colour
        val setThemeMode = findViewById<SwitchMaterial>(R.id.dmSwitch)
        setThemeMode.setOnCheckedChangeListener { _, isChecked ->
            //Checking if switch is clicked not not
            if (isChecked) {
                //Will cause the application go to dark / night mode
                setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                Toast.makeText(this, "Dark Mode set", Toast.LENGTH_SHORT).show()
            } else {
                //Will cause the application go to light / default mode
                setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                Toast.makeText(this, "Light Mode set", Toast.LENGTH_SHORT).show()

            }
        }

        //Initialise the variable
        dbHelper = ConvertDB(applicationContext)
    }

    /**
     * This function selects distinct records from the database to be used
     * Called in setUnitTo() and setUnitFrom() - Page1Fragment
     */

    fun selectSQLStatement(distinct: Boolean, columns: Array<String>, selection: String?, selectionArgs: Array<String>?): ArrayList<String> {

        val db = dbHelper?.readableDatabase

        val cursor = db!!.query(
            distinct,
            DBReader.UnitEntry.TABLE_NAME,
            columns, selection,
            selectionArgs,
            null,
            null,
            null,
            null)

        val result = ArrayList<String>()
        while(cursor.moveToNext()){
            val selectedVal = cursor.getString(cursor.getColumnIndexOrThrow((columns[0]))
            )
            result.add(selectedVal)
        }
        cursor.close()
        return result
    }

    /**
     * Restore the state of the activity
     */
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }

    /**
     * Save the state of the activity
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }
}



