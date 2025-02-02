package com.lighttigerxiv.simple.mp.compose.screens.setup.color_schemes.dark

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import com.lighttigerxiv.simple.mp.compose.data.variables.Settings
import com.lighttigerxiv.simple.mp.compose.settings.SettingsVM
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SetupDarkColorSchemesScreenVM(application: Application) : AndroidViewModel(application) {
    val context = application

    private val preferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)

    private val _selectedTheme = MutableStateFlow(preferences.getString(Settings.DARK_COLOR_SCHEME, Settings.Values.ColorSchemes.BLUE)!!)
    val selectedTheme = _selectedTheme.asStateFlow()

    fun applyColorScheme(colorScheme: String, settingsVM: SettingsVM) {

        settingsVM.updateDarkColorSchemeSetting(colorScheme)
        _selectedTheme.update { colorScheme }
    }
}