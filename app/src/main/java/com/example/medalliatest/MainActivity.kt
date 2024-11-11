package com.example.medalliatest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.medalliatest.ui.theme.MedalliaTestTheme
import com.medallia.digital.mobilesdk.MDExternalError
import com.medallia.digital.mobilesdk.MDResultCallback
import com.medallia.digital.mobilesdk.MedalliaDigital

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			MedalliaTestTheme {
				Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
					Box(modifier = Modifier.fillMaxSize()) {
						Button(modifier = Modifier.align(Alignment.Center), onClick = ::showForm) {
							Text("Show Form")
						}
					}
				}
			}
		}
	}
}

fun showForm() {
	MedalliaDigital.showForm("5996", object: MDResultCallback {
		override fun onSuccess() {
			Log.d("MedalliaTestApplication", "Form was shown successfully")
		}

		override fun onError(mdExternalError: MDExternalError) {
			Log.e("MedalliaTestApplication", "Error showing form: ${mdExternalError.message}")
		}
	})
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
	Text(
		text = "Hello $name!",
		modifier = modifier
	)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
	MedalliaTestTheme {
		Greeting("Android")
	}
}