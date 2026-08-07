package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemViewModel : ViewModel() {
    private val _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>> get() = _items

    private val _selectedItem = MutableLiveData<Item>()
    val selectedItem: LiveData<Item> get() = _selectedItem

    init {
        _items.value = listOf(
            Item("Android", "A mobile operating system based on a modified version of the Linux kernel and other open-source software."),
            Item("Kotlin", "A cross-platform, statically typed, general-purpose programming language with type inference."),
            Item("Java", "A high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible."),
            Item("Python", "An interpreted, high-level and general-purpose programming language."),
            Item("Swift", "A general-purpose, multi-paradigm, compiled programming language developed by Apple Inc.")
        )
    }

    fun selectItem(item: Item) {
        _selectedItem.value = item
    }
}
