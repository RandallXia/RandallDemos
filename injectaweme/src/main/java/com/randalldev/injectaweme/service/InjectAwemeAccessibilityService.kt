package com.randalldev.injectaweme.service

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.GestureDescription
import android.graphics.Path
import android.graphics.Point
import android.graphics.Rect
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ScreenUtils
import com.blankj.utilcode.util.TimeUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlin.random.Random

/**
 *
 * @author Randall.
 * @Date 2023-04-30.
 * @Time 10:48.
 */
class InjectAwemeAccessibilityService : AccessibilityService() {

    private var timestamp = TimeUtils.getNowMills()
    private var taskRunning = false

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        LogUtils.d(event.toString())
        event?.let { accessibilityEvent ->
            val randomGap = Random.nextFloat() * 20000
            when (accessibilityEvent.eventType) {
                AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED -> {
                    if (accessibilityEvent.packageName.equals("com.ss.android.ugc.aweme.lite")) {
                        when (accessibilityEvent.className) {
                            "android.widget.ScrollView" -> {

                                val nodeInfosByText = rootInActiveWindow?.findAccessibilityNodeInfosByText("去逛街")
                                nodeInfosByText?.firstOrNull()?.let { clickByNode(this, it) }
                                doAtLeast90sTask {
                                    /*val nodeWatchMore = rootInActiveWindow?.findAccessibilityNodeInfosByText("看更多")
                                    nodeWatchMore?.firstOrNull()?.let { clickByNode(this@InjectAwesomeAccessibilityService, it) }
                                    doAtLeast90sTask {
                                        val nodeWatchSomeCity = rootInActiveWindow?.findAccessibilityNodeInfosByText("去浏览")
                                        nodeWatchSomeCity?.firstOrNull()?.let { clickByNode(this@InjectAwesomeAccessibilityService, it) }
                                    }*/
                                }
                                //traverseView(rootInActiveWindow)
                            }

                            /*"androidx.recyclerview.widget.RecyclerView" -> {
                                //recursionViewTree(rootInActiveWindow)
                                GlobalScope.launch(Dispatchers.IO) {
                                    flow {
                                        repeat(50) {
                                            delay(2000)
                                            emit(it)
                                        }
                                    }.onCompletion {
                                        performGlobalAction(GLOBAL_ACTION_BACK)
                                    }.collect {
                                        scrollByNode(this@InjectAwesomeAccessibilityService)
                                    }
                                }
                            }*/

                            "android.widget.FrameLayout" -> {
                                if (TimeUtils.getNowMills() - timestamp > randomGap) {
                                    timestamp = TimeUtils.getNowMills()
                                    val viewpager =
                                        rootInActiveWindow.findAccessibilityNodeInfosByViewId("com.ss.android.ugc.aweme.lite:id/viewpager")

                                    //runTasks(accessibilityEvent)

                                    //recursionViewTree(rootInActiveWindow)

                                    if (!viewpager.isNullOrEmpty()) {
                                        val nodeInfo =
                                            viewpager.firstOrNull {
                                                it.contentDescription != null && it.contentDescription.equals(
                                                    "视频"
                                                )
                                            }
                                        nodeInfo?.performAction(AccessibilityNodeInfo.ACTION_SCROLL_FORWARD)
                                    } else {

                                    }
                                } else {

                                }
                            }

                            else -> {}
                        }

                    } else {

                    }
                }

                AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED -> {

                    val nodeInfosA5 =
                        rootInActiveWindow.findAccessibilityNodeInfosByViewId("com.ss.android.ugc.aweme:id/a-5")
                    if (!nodeInfosA5.isNullOrEmpty()) {
                        nodeInfosA5.forEach {
                            it.performAction(AccessibilityNodeInfo.ACTION_CLICK)
                        }
                    } else {

                    }
                    val nodeInfosHox =
                        rootInActiveWindow.findAccessibilityNodeInfosByViewId("com.ss.android.ugc.aweme:id/hox")
                    if (!nodeInfosHox.isNullOrEmpty()) {
                        nodeInfosHox.forEach {
                            it.parent.parent.performAction(AccessibilityNodeInfo.ACTION_CLICK)
                        }
                    } else {

                    }
                }

                else -> {}
            }
        }
    }

    private fun doAtLeast90sTask(afterCompleted: () -> Unit) {
        if (!taskRunning) {
            GlobalScope.launch(Dispatchers.IO) {
                flow {
                    delay(3000)
                    repeat(50) {
                        delay(2000)
                        emit(it)
                    }
                }
                    .onStart {
                        taskRunning = true
                    }
                    .onCompletion {
                        taskRunning = false
                        afterCompleted.invoke()
                    }.collect {
                        scrollByNode(this@InjectAwemeAccessibilityService)
                        if (it == 49) {
                            val action = performGlobalAction(GLOBAL_ACTION_BACK)
                            LogUtils.d("action perform result: $action")
                        }
                    }
            }
        }
    }

    private fun runTasks(event: AccessibilityEvent) {
        val nodeInfosByViewId =
            rootInActiveWindow.findAccessibilityNodeInfosByViewId("com.ss.android.ugc.aweme.lite:id/evv")
        if (!nodeInfosByViewId.isNullOrEmpty()) {
            clickByNode(this, nodeInfosByViewId[0])
        }
    }

    private fun traverseView(node: AccessibilityNodeInfo?) {
        if (node == null) {
            return
        }
        node.isClickable.let {
            LogUtils.d(AccessibilityNodeInfoWrapper(node).toString())
        }
        for (i in 0 until node.childCount) {
            val child = node.getChild(i)
            traverseView(child)
        }
        // 对当前节点进行操作
    }

    override fun onInterrupt() {
        LogUtils.w("accessibility was interrupted!")
    }

    private fun clickByNode(service: AccessibilityService?, nodeInfo: AccessibilityNodeInfo?): Boolean {
        if (service == null || nodeInfo == null) {
            return false
        }
        val rect = Rect()
        nodeInfo.getBoundsInScreen(rect)
        val x = rect.centerX()
        val y = rect.centerY()
        if (x < 0 || y < 0)
            return false
        Log.e("acc_", "要点击的像素点在手机屏幕位置::" + rect.centerX() + " " + rect.centerY())
        val point = Point(x, y)
        val builder = GestureDescription.Builder()
        val path = Path()
        path.moveTo(point.x.toFloat(), point.y.toFloat())
        builder.addStroke(GestureDescription.StrokeDescription(path, 0L, 100L))
        val gesture = builder.build()
        return service.dispatchGesture(gesture, object : GestureResultCallback() {
            override fun onCompleted(gestureDescription: GestureDescription) {
                super.onCompleted(gestureDescription)
                //                LogUtil.d(TAG, "dispatchGesture onCompleted: 完成...");
            }

            override fun onCancelled(gestureDescription: GestureDescription) {
                super.onCancelled(gestureDescription)
                //                LogUtil.d(TAG, "dispatchGesture onCancelled: 取消...");
            }
        }, null)
    }

    private fun scrollByNode(service: AccessibilityService?): Boolean {
        if (service == null) {
            return false
        }
        val rect = Rect()
        Log.e("acc_", "要点击的像素点在手机屏幕位置::" + rect.centerX() + " " + rect.centerY())

        val builder = GestureDescription.Builder()
        val path = Path()
        path.moveTo(ScreenUtils.getScreenWidth() * 0.4f, ScreenUtils.getScreenHeight() * 0.6f)
        path.lineTo(
            (ScreenUtils.getScreenWidth() * 0.4 * (Random.nextFloat() * 0.2 + 0.2)).toFloat(),
            (ScreenUtils.getScreenHeight() * 0.6 * (Random.nextFloat() * 0.2 + 0.2)).toFloat()
        )
        builder.addStroke(GestureDescription.StrokeDescription(path, 0L, 100L))
        val gesture = builder.build()
        return service.dispatchGesture(gesture, object : GestureResultCallback() {
            override fun onCompleted(gestureDescription: GestureDescription) {
                super.onCompleted(gestureDescription)
                //                LogUtil.d(TAG, "dispatchGesture onCompleted: 完成...");
            }

            override fun onCancelled(gestureDescription: GestureDescription) {
                super.onCancelled(gestureDescription)
                //                LogUtil.d(TAG, "dispatchGesture onCancelled: 取消...");
            }
        }, null)
    }

    private class AccessibilityNodeInfoWrapper(private val nodeInfo: AccessibilityNodeInfo) {

        val childCount: Int
            get() = nodeInfo.childCount

        fun getChild(index: Int): AccessibilityNodeInfo {
            return nodeInfo.getChild(index)
        }

        override fun toString(): String {
            val builder = StringBuilder()
            builder.append("View: ${nodeInfo.className} [${nodeInfo.text}]\n")
            builder.append("viewId: ${nodeInfo.viewIdResourceName}\n")
            builder.append("IsClickable: ${nodeInfo.isClickable}\n")
            builder.append("IsFocusable: ${nodeInfo.isFocusable}\n")
            builder.append("IsEditable: ${nodeInfo.isEditable}\n")
            builder.append("IsPassword: ${nodeInfo.isPassword}\n")
            builder.append("IsScrollable: ${nodeInfo.isScrollable}")
            return builder.toString()
        }
    }
}