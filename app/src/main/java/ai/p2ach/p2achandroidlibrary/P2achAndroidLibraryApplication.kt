package ai.p2ach.p2achandroidlibrary

import ai.p2ach.p2achandroidlibrary.utils.Log
import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger


class P2achAndroidLibraryApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        Logger.addLogAdapter(AndroidLogAdapter())
    }

}