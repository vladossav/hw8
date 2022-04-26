package com.example.hw8

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    val employees = MutableLiveData(Employee.getMockEmployees())
}