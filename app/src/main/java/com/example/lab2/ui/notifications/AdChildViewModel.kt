package com.example.lab2.ui.notifications


import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData

import com.example.lab2.BaseViewModel

import com.example.lab2.data.Child

class AdChildViewModel : BaseViewModel() {
    private val _child = MutableLiveData<Child>()
    private val _child1 = MutableLiveData<Child>()

    val child = _child
    val child1 = _child1

    override fun prepare(args: Bundle?) {
        super.prepare(args)
        child.value = Child(name="Test", points1 = 0, points2 = 0, avatar = "")
        child1.value = Child(name="Test2", points1 = 0, points2 = 0, avatar = "")
    }

    fun saveAddChild(){
        Log.i("saveAddChild", child.value.toString())
        Log.i("saveAddChild", child1.value.toString())
    }

}