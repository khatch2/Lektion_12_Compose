package com.example.lektion_12_compose

import android.os.Bundle
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.SaverScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.io.Serializable

class MutableStateFlowSaver<T: Any>: Saver<MutableStateFlow<T>, Bundle> {
    override fun restore(value: Bundle): MutableStateFlow<T> {
        val initialValue = value.getSerializable("initialValue") as T
        return MutableStateFlow(initialValue)
    }

    override fun SaverScope.save(value: MutableStateFlow<T>): Bundle {
        val bundle = Bundle()
        bundle.putSerializable("initialValue", value.value as Serializable)
        return bundle
    }
}


