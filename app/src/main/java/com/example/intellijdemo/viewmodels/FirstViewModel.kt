package com.example.intellijdemo.viewmodels

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FirstViewModel : ViewModel() {
    private val _label: MutableLiveData<String> by lazy { MutableLiveData<String>("Initial label") }

    val label: LiveData<String> = _label

    fun changeLabel() {
        _label.value = "New value"
    }

    fun saveState(state: Bundle) {
        _label.value?.let { state.putString("label", it) }
    }

    fun loadState(state: Bundle) {
        _label.value = state.getString("label", "Default value")
    }
}
