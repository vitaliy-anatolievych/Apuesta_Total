package com.doriangrei.apueastawinapp.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.doriangrei.apueastawinapp.controller.LocalStorageController
import com.doriangrei.apueastawinapp.model.Level

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val prefs = application.getSharedPreferences(
        LocalStorageController.MAIN_STORAGE,
        Application.MODE_PRIVATE
    )

    private val storageController = LocalStorageController(prefs)

    private val _levelsData = MutableLiveData<ArrayList<Level>>()
    val levelsData: LiveData<ArrayList<Level>>
        get() = _levelsData

    fun getLevels() {
        _levelsData.value = storageController.getLevels()
    }

    fun saveProgress(levels: ArrayList<Level>) {
        storageController.saveResults(levels)
    }

}