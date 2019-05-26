package com.umarfarisi.preservefieldstest2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_other.*

class OtherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        title = "Other Activity"

        btnChangeText.setOnClickListener {
            tvText.text = etText.text
        }

    }
}
