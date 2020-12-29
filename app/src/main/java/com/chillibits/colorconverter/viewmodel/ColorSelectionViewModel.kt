/*
 * Copyright © Marc Auberer 2020. All rights reserved
 */

package com.chillibits.colorconverter.viewmodel

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import com.chillibits.colorconverter.model.Color
import com.chillibits.colorconverter.repository.ColorRepository
import com.chillibits.colorconverter.shared.toDbo
import com.chillibits.colorconverter.tools.ColorNameTools

class ColorSelectionViewModel@ViewModelInject constructor(
    application: Application,
    private val repository: ColorRepository,
    private val cnt: ColorNameTools
): AndroidViewModel(application) {

    // Variables as objects
    val colors = repository.getAll()
    var selectedColor: Color? = null

    fun update() = selectedColor?.run { repository.update(this.toDbo()) }
    fun delete() {
        selectedColor?.run { repository.delete(this.toDbo()) }
        selectedColor = null
    }
}