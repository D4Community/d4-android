package com.example.datastore.model

import android.util.Log
import androidx.datastore.core.DataStore
import com.example.datastore.UserPreferences
import com.example.datastore.copy
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PrefManager
@Inject constructor(
    private val userPreferences: DataStore<UserPreferences>
) {

    val userData: Flow<UserPreferenceData> = userPreferences.data.map {
        UserPreferenceData(
            it.startScreenCode
        )
    } //All your pref will be emitted here

    suspend fun setScreenCode(code: Int) {//edit your preferences with different methods
        try {
            userPreferences.updateData {
                it.copy { this.startScreenCode = code }
            }
        } catch (ioException: IOException) {
            Log.e("Pref", "Failed to update user preferences", ioException)
        }
    }
}