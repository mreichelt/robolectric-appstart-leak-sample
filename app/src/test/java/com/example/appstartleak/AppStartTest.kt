package com.example.appstartleak

import android.app.Application
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

var onCreateCalled = false
private class App : Application() {
    override fun onCreate() {
        super.onCreate()
        onCreateCalled = true
    }
}

@RunWith(RobolectricTestRunner::class)
@Config(minSdk = 25, application = App::class)
class AppStartTest {

    @Test
    fun checkAppStart() {
        assertTrue(onCreateCalled)
        onCreateCalled = false

        val runtime = Runtime.getRuntime()
        runtime.gc()
        val used = (runtime.totalMemory() - runtime.freeMemory()) / 1024.0 / 1024.0
        println("Used heap Size = $used MB")
    }

}
