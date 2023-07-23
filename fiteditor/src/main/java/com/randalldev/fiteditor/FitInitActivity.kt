package com.randalldev.fiteditor

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.blankj.utilcode.util.LogUtils
import com.garmin.fit.examples.DecodeExample
import com.randalldev.fiteditor.ui.theme.DemosTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FitInitActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && !Environment.isExternalStorageManager()) {
            val uri: Uri = Uri.parse("package:" + BuildConfig.LIBRARY_PACKAGE_NAME)
            startActivity(Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION, uri))
        }

        LogUtils.d(filesDir)

        lifecycleScope.launch(Dispatchers.IO) {
            DecodeExample.main(arrayOf("${Environment.getExternalStorageDirectory().path}/Download/230610080848.fit", "2023-06-10 08:08:48", "2023-07-23 08:08:48"))
        }

        setContent {
            DemosTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
    }
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
    DemosTheme {
        Greeting("Android")
    }
}