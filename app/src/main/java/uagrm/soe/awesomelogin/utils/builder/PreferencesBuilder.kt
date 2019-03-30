package integgre.ma_volvo.business.patterns.builder
import android.content.Context;
import kotlin.properties.Delegates


class PreferencesBuilder : Builder {
    private val preferences: Preferences by Delegates.notNull()

    override fun putString(key: String, newValue: String) {
        this.preferences.putString(key, newValue)
    }

    override fun getString(key: String, defValue: String): String {
        return this.preferences.getString(key, defValue)!!
    }

    override fun putInt(key: String, newValue: Int) {
        this.preferences.putInt(key, newValue)
    }

    override fun getInt(key: String, defValue: Int): Int {
        return this.preferences.getInt(key, defValue)
    }

    override fun putLong(key: String, newValue: Long) {
        this.preferences.putLong(key, newValue)
    }

    override fun getLong(key: String, defValue: Long): Long {
        return this.preferences.getLong(key, defValue)
    }

    override fun clear() {
        this.preferences.clear()
    }

    override fun putFloat(key: String, newValue: Float) {
        this.preferences.putFloat(key, newValue)
    }

    override fun getFloat(key: String, defValue: Float): Float {
        return this.preferences.getFloat(key, defValue)
    }

    override fun putBoolean(key: String, newValue: Boolean?) {
        this.preferences.putBoolean(key, newValue)
    }

    override fun getBoolean(key: String, defValue: Boolean?): Boolean {
        return this.preferences.getBoolean(key, defValue)
    }

    override fun putStringSet(key: String, newValue: Set<String>) {
        this.preferences.putStringSet(key, newValue)
    }

    override fun getStringSet(key: String, defValue: Set<String>): Set<String> {
        return this.preferences.getStringSet(key, defValue)!!
    }

    override fun getAll(): Map<String, *>{
        return this.preferences.getAll()!!
    }

    override fun containsPreference(key: String): Boolean {
        return this.preferences.containsPreference(key)
    }

    override fun removeKey(key: String) {
        this.preferences.removeKey(key)
    }

    companion object {
        fun build(context: Context, name: String): Preferences {
            return Preferences().initPrefs(context, name)
        }
    }

}


