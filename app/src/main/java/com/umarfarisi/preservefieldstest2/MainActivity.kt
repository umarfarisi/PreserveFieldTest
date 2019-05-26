package com.umarfarisi.preservefieldstest2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.umarfarisi.preservefield.PreserveField
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val fullClassPath = this::class.java.name
    private val preserveField: PreserveField = PreserveField()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getter: PreserveField.Getter = preserveField.clearDataAndGetFields(savedInstanceState != null)
        val text: String? = getter.get(fullClassPath + "text", null)

        text?.let(tvText::setText)

        title = "Main Activity"

        btnChangeText.setOnClickListener {
            tvText.text = etText.text
        }

        btnGoToOtherPage.setOnClickListener {
            startActivity(Intent(this, OtherActivity::class.java))
        }

    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        preserveField
            .putField(fullClassPath + "text", tvText.text.toString())
            .save()
    }

}
