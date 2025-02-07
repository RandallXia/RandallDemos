package com.randalldev.demos

import android.app.Application
import android.view.accessibility.AccessibilityEvent
import cn.coderpig.cp_fast_accessibility.FastAccessibilityService
import com.blankj.utilcode.util.Utils
import com.randalldev.injectcoupon.service.InjectCouponAccessibilityService

/**
 *
 * @author Randall.
 * @Date 2023-03-30.
 * @Time 11:03.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Utils.init(this)

        FastAccessibilityService.init(
            this, InjectCouponAccessibilityService::class.java, arrayListOf(
                AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED,
                AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED,
                AccessibilityEvent.TYPE_VIEW_CLICKED,
            )
        )
    }
}