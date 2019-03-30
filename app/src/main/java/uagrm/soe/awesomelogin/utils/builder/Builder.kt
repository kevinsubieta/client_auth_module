package integgre.ma_volvo.business.patterns.builder



public interface Builder{

    fun putString(key: String, newValue: String)
    fun getString(key: String, defValue: String): String

    fun putInt(key: String, newValue: Int)
    fun getInt(key: String, defValue: Int): Int

    fun putLong(key: String, newValue: Long)
    fun getLong(key: String, defValue: Long): Long

    fun clear()

    fun putFloat(key: String, newValue: Float)
    fun getFloat(key: String, defValue: Float): Float

    fun putBoolean(key: String, newValue: Boolean?)
    fun getBoolean(key: String, defValue: Boolean?): Boolean

    fun putStringSet(key: String, newValue: Set<String>)
    fun getStringSet(key: String, defValue: Set<String>): Set<String>

    fun getAll(): Map<String, *>
    fun containsPreference(key: String): Boolean
    fun removeKey(key: String)

}