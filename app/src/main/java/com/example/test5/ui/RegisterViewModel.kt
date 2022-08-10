package com.example.test5.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test5.model.ListItems
import com.example.test5.model.Model
import com.example.test5.model.Person
import com.example.test5.model.json
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {

    private val _parsedData = MutableStateFlow<List<ListItems>>(emptyList())
    val parsedData = _parsedData.asStateFlow()

    private val _isValid = MutableSharedFlow<Boolean>()
    val isValid = _isValid.asSharedFlow()

    fun parser() {
        viewModelScope.launch {
            val data = Gson().fromJson(json, Model::class.java)
            _parsedData.emit(data.content)
        }
    }

    fun check(person: Person){
        viewModelScope.launch {
            if (person.username.isEmpty() || person.email.isEmpty() || person.phone.toString().isEmpty() || person.fullName.isEmpty()){
                _isValid.emit(false)
            }else{
                _isValid.emit(true)
            }
        }
    }


}