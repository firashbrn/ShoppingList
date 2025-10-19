package com.example.shoppinglist.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel (){
    private val _name = mutableStateOf("Magfira Shabrina")
    val name : State<String> = _name

    private val _description = mutableStateOf("Mahasiswi Sistem Informasi")
    val description: State<String> = _description


    fun updateName (newName: String){
        _name.value = newName
    }

    fun updateDescription(newDesc: String){
        _description.value = newDesc
    }
}
