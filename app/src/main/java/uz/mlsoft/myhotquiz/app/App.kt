package uz.mlsoft.myhotquiz.app

import android.app.Application
import uz.mlsoft.myhotquiz.data.local.MyPref
import uz.mlsoft.myhotquiz.data.room.UserDb

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        UserDb.init(this)
        MyPref.init(this)
    }
}