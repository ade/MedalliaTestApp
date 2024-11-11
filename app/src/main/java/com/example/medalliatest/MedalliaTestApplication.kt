package com.example.medalliatest

import android.app.Application
import android.util.Log
import com.medallia.digital.mobilesdk.MDExternalError
import com.medallia.digital.mobilesdk.MDLogLevel
import com.medallia.digital.mobilesdk.MDResultCallback
import com.medallia.digital.mobilesdk.MedalliaDigital

//TODO Add api key here.
private const val MEDALLIA_API_KEY = ""

class MedalliaTestApplication: Application() {
	override fun onCreate() {
		super.onCreate()
		MedalliaDigital.init(this, MEDALLIA_API_KEY, object : MDResultCallback {
			override fun onSuccess() {
				MedalliaDigital.setLogLevel(MDLogLevel.DEBUG)
				Log.v("MedalliaTestApplication", "INIT MEDALLIA SDK SUCCESS")
			}

			override fun onError(mdExternalError: MDExternalError) {
				Log.e("MedalliaTestApplication", "INIT MEDALLIA SDK ERROR: '${mdExternalError.message}'")
			}
		})
	}
}