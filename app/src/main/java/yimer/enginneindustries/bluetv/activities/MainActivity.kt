package yimer.enginneindustries.bluetv.activities

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import yimer.enginneindustries.bluetv.R

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}