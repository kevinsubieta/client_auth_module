package integgre.ma_volvo.business.patterns.builder


import android.content.Context;
import android.content.SharedPreferences;
import kotlin.properties.Delegates

class Preferences {

    var sharedPreferences: SharedPreferences by Delegates.notNull()
    var editor: SharedPreferences.Editor by Delegates.notNull()


    fun initPrefs(context: Context, prefsName: String): Preferences {
        sharedPreferences = context.getSharedPreferences(prefsName, Context.MODE_PRIVATE)
        return this
    }

    fun putString(key: String, newValue: String) {
        editor = sharedPreferences.edit()
        editor.putString(key, newValue)
        editor.apply()
    }

    fun getString(key: String, defValue: String): String? {
        return sharedPreferences.getString(key, defValue)
    }

    fun putInt(key: String, newValue: Int) {
        editor = sharedPreferences.edit()
        editor.putInt(key, newValue)
        editor.apply()
    }

    fun getInt(key: String, defValue: Int): Int {
        return sharedPreferences.getInt(key, defValue)
    }

    fun putFloat(key: String, newValue: Float) {
        editor = sharedPreferences.edit()
        editor.putFloat(key, newValue)
        editor.apply()
    }

    fun putLong(key: String, newValue: Long) {
        editor = sharedPreferences.edit()
        editor.putLong(key, newValue)
        editor.apply()
    }

    fun getLong(key: String, defValue: Long): Long {
        return sharedPreferences.getLong(key, defValue)
    }

    fun clear() {
        editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    fun getFloat(key: String, defValue: Float): Float {
        return sharedPreferences.getFloat(key, defValue)
    }

    fun putBoolean(key: String, newValue: Boolean?) {
        editor = sharedPreferences.edit()
        editor.putBoolean(key, newValue!!)
        editor.apply()
    }

    fun getBoolean(key: String, defValue: Boolean?): Boolean {
        return sharedPreferences.getBoolean(key, defValue!!)
    }

    fun putStringSet(key: String, newValue: Set<String>) {
        editor = sharedPreferences.edit()
        editor.putStringSet(key, newValue)
        editor.apply()
    }

    fun getStringSet(key: String, defValue: Set<String>): Set<String>? {
        return sharedPreferences.getStringSet(key, defValue)
    }

    fun getAll(): MutableMap<String, *>? {
        return sharedPreferences.all
    }

    fun containsPreference(key: String): Boolean {
        return sharedPreferences.contains(key)
    }

    fun removeKey(key: String) {
        editor = sharedPreferences.edit()
        editor.remove(key)
        editor.apply()
    }
}