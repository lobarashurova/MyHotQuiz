package uz.mlsoft.myhotquiz.data.local

import android.content.Context
import android.content.SharedPreferences
import uz.mlsoft.myhotquiz.R

class MyPref private constructor(context: Context) {

    private val SHARED_PREF = "shared_pref"
    private val NAME = "name"
    private val IsREGISTERED = "registered"
    private val IMAGE = "image"


    private val sharedPreference: SharedPreferences =
        context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)

    private val editor: SharedPreferences.Editor = sharedPreference.edit()


    var name: String?
        get() = sharedPreference.getString(NAME, "")
        set(value) = editor.putString(NAME, value).apply()


    var isRegisterd: Boolean
        get() = sharedPreference.getBoolean(IsREGISTERED, false)
        set(value) = editor.putBoolean(IsREGISTERED, value).apply()

    var image: Int
        get() = sharedPreference.getInt(IMAGE, R.drawable.boy)
        set(value) = sharedPreference.edit().putInt(IMAGE, value).apply()


    fun clearData(){
        isRegisterd=false
        name=null
        image=0
    }
    companion object {
        private lateinit var instance: MyPref

        fun init(context: Context) {
            instance = MyPref(context)
        }

        fun getInstance() = instance
    }
}