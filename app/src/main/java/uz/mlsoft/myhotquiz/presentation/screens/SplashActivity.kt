package uz.mlsoft.myhotquiz.presentation.screens

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import uz.mlsoft.myhotquiz.R
import uz.mlsoft.myhotquiz.data.local.MyPref

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private val myPref = MyPref.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent1 = Intent(this, UserActivity::class.java)
            val intent2 = Intent(this, MainActivity::class.java)
            if (myPref.isRegisterd) {
                startActivity(intent2)
            } else {
                startActivity(intent1)
            }
            finish()
        }, 4000)
    }
}