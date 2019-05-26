package com.umarfarisi.preservefieldstest2

import android.app.Application
import com.umarfarisi.preservefield.storage.FieldStorageSharedPreference
import com.umarfarisi.preservefield.storage.FieldStorageUtils

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        FieldStorageUtils.setDefaultFS(
            FieldStorageSharedPreference(
                this.applicationContext,
                "FIELD_STORAGE_SHARED_PREFERENCE_STORAGE_NAME"
            )
        )

        FieldStorageUtils.getDefaultFS().clear()
    }

}