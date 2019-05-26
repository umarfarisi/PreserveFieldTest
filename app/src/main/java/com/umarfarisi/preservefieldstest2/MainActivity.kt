package com.umarfarisi.preservefieldstest2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Main Activity"

        btnChangeText.setOnClickListener {
            tvText.text = etText.text
        }

        btnGoToOtherPage.setOnClickListener {
            startActivity(Intent(this, OtherActivity::class.java))
        }

    }
}
