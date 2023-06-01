package com.randalldev.demos

import android.app.Application
import com.blankj.utilcode.util.Utils

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
    }
}