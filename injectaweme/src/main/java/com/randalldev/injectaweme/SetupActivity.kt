package com.randalldev.injectaweme

import android.accessibilityservice.AccessibilityService
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.text.TextUtils
import androidx.activity.ComponentActivity
import com.randalldev.injectaweme.databinding.ActivitySetupBinding
import com.randalldev.injectaweme.service.InjectAwemeAccessibilityService

class SetupActivity : ComponentActivity() {

    private val binding by lazy {
        ActivitySetupBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnEnableAccessibility.setOnClickListener {
            if (!isAccessibilitySettingsOn(InjectAwemeAccessibilityService::class.java)) {
                startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
            }
        }

        binding.btnStartInject.setOnClickListener {
            if (isAccessibilitySettingsOn(InjectAwemeAccessibilityService::class.java)) {
                Intent(Intent.ACTION_MAIN)
                    .apply {
                        component =
                            ComponentName("com.ss.android.ugc.aweme.lite", "com.ss.android.ugc.aweme.splash.SplashActivity")
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        startActivity(this)
                    }
            }
        }
    }
}

fun Context.isAccessibilitySettingsOn(clazz: Class<out AccessibilityService?>): Boolean {
    var accessibilityEnabled = false    // 判断设备的无障碍功能是否可用
    try {
        accessibilityEnabled =
            Settings.Secure.getInt(applicationContext.contentResolver, Settings.Secure.ACCESSIBILITY_ENABLED) == 1
    } catch (e: Settings.SettingNotFoundException) {
        e.printStackTrace()
    }
    val mStringColonSplitter = TextUtils.SimpleStringSplitter(':')
    if (accessibilityEnabled) {
        // 获取启用的无障碍服务
        val settingValue: String? =
            Settings.Secure.getString(applicationContext.contentResolver, Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES)
        if (settingValue != null) {
            // 遍历判断是否包含我们的服务
            mStringColonSplitter.setString(settingValue)
            while (mStringColonSplitter.hasNext()) {
                val accessibilityService = mStringColonSplitter.next()
                if (accessibilityService.equals("${packageName}/${clazz.canonicalName}", ignoreCase = true)) return true
            }
        }
    }
    return false
}