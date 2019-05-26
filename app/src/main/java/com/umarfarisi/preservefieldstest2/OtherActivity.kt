package com.umarfarisi.preservefieldstest2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.umarfarisi.preservefield.PreserveField
import kotlinx.android.synthetic.main.activity_other.*

class OtherActivity : AppCompatActivity() {

    private val fullClassPath = this::class.java.name
    private val preserveField: PreserveField = PreserveField()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        val getter: PreserveField.Getter = preserveField.clearDataAndGetFields(savedInstanceState != null)
        val text1: String? = getter.get(fullClassPath + "text1", null)
        val text2: String? = getter.get(fullClassPath + "text2", null)
        val text3: String? = getter.get(fullClassPath + "text3", null)

        text1?.let(tvText1::setText)
        text2?.let(tvText2::setText)
        text3?.let(tvText3::setText)

        title = "Other Activity"

        btnChangeText.setOnClickListener {
            tvText1.text = etText1.text
            tvText2.text = etText2.text
            tvText3.text = etText3.text
        }

    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        preserveField
            .putField(fullClassPath + "text1", tvText1.text.toString())
            .putField(fullClassPath + "text2", tvText2.text.toString())
            .putField(fullClassPath + "text3", tvText3.text.toString())
            .save()
    }

}
