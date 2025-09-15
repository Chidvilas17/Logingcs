package com.example.firebaseauthdemoapp.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class UserPreferencesRepository(private val context: Context) {

    private object PreferencesKeys {
        val IS_GUEST = booleanPreferencesKey("is_guest")
    }

    val isGuestUser: Flow<Boolean> = context.dataStore.data
        .map { preferences ->
            preferences[PreferencesKeys.IS_GUEST] ?: false
        }

    suspend fun updateGuestStatus(isGuest: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.IS_GUEST] = isGuest
        }
    }
}
