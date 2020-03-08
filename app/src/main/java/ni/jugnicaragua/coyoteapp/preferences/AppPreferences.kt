package ni.jugnicaragua.coyoteapp.preferences

import android.content.Context
import android.content.SharedPreferences

class AppPreferences(context: Context){
    private val mPref: SharedPreferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    private var mEditor: SharedPreferences.Editor? = null
    private var mBulkUpdate = false

    enum class Key {
        dias, fecha, firstTime, cookies
    }

    fun put(key: Key, `val`: Any) {
        doEdit()
        when (`val`) {
            is String -> mEditor!!.putString(key.name, `val`)
            is Int -> mEditor!!.putInt(key.name, `val`)
            is Double -> mEditor!!.putString(key.name, `val`.toString())
            is Boolean -> mEditor!!.putBoolean(key.name, `val`)
            is Float -> mEditor!!.putFloat(key.name, `val`)
            is Long -> mEditor!!.putLong(key.name, `val`)
            is HashSet<*> -> {
                val hashSet: HashSet<String> = hashSetOf()
                `val`.forEach {
                    hashSet.add(it as String)
                }
                mEditor!!.putStringSet(key.name, hashSet)
            }
            else -> throw IllegalArgumentException("The PreferenceManager can't obtain value outside the expected range.")
        }
        doCommit()
    }

    fun get(key: Key, defaultValue: Any): Any {
        return when (defaultValue) {
            is String -> mPref.getString(key.name, defaultValue) as String
            is Int -> mPref.getInt(key.name, defaultValue)
            is Double -> mPref.getString(key.name, defaultValue.toString()) as String
            is Boolean -> mPref.getBoolean(key.name, defaultValue)
            is Float -> mPref.getFloat(key.name, defaultValue)
            is Long -> mPref.getLong(key.name, defaultValue)
            is HashSet<*> -> mPref.getStringSet(key.name, HashSet()) as HashSet<*>
            else -> throw IllegalArgumentException("The PreferenceManager can't obtain value outside the expected range.")
        }
    }

    fun remove(vararg keys: Key) {
        doEdit()
        for (key in keys) {
            mEditor!!.remove(key.name)
        }
        doCommit()
    }

    fun clear() {
        doEdit()
        mEditor!!.clear()
        doCommit()
    }

    fun edit() {
        mBulkUpdate = true
        mEditor = mPref.edit()
    }

    fun commit() {
        mBulkUpdate = false
        mEditor!!.commit()
        mEditor = null
    }

    private fun doEdit() {
        if (!mBulkUpdate && mEditor == null) {
            mEditor = mPref.edit()
        }
    }

    private fun doCommit() {
        if (!mBulkUpdate && mEditor != null) {
            mEditor!!.commit()
            mEditor = null
        }
    }
}
