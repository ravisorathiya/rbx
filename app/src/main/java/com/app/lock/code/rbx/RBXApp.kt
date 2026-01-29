package com.app.lock.code.rbx

import android.app.Application
import com.app.lock.code.rbx.util.DataUtil

class RBXApp : Application() {


    override fun onCreate() {
        super.onCreate()

        DataUtil.init(this)
    }
}