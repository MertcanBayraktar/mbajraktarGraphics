package com.example.graphix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.graphix.ui.main.MainFragment
import com.example.graphix.ui.main.KortesianView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }


    }
}