package uk.ac.stir.cs.assignment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

/**
 * This class will call for the splash screen to appear before load of the rest of the app
 */
class SplashScreen : AppCompatActivity() {
    private val splashTimer:Long=2000 // remain for 2 seconds
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)

        Handler().postDelayed({
            //Rest of application(main activity) will load when timer is finished
            startActivity(Intent(this,MainActivity::class.java))
            // Close the splash screen activity
            finish()
        }, splashTimer)
    }
}