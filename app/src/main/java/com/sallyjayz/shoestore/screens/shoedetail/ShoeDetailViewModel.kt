package com.sallyjayz.shoestore.screens.shoedetail

import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sallyjayz.shoestore.model.Shoe
import timber.log.Timber

class ShoeDetailViewModel(): ViewModel() {

    private val _saveDetail = MutableLiveData<Boolean>()
    val saveDetail: LiveData<Boolean>
        get() = _saveDetail

    private val _clearDetail = MutableLiveData<Boolean>()
    val clearDetail: LiveData<Boolean>
        get() = _clearDetail

    /*private val _editableName = MutableLiveData<String>()
    val editableName:LiveData<String>
        get() = _editableName

    private val _editableSize = MutableLiveData<Int>()
    val editableSize:LiveData<Int>
        get() = _editableSize

    private val _editableCompany = MutableLiveData<String>()
    val editableCompany:LiveData<String>
        get() = _editableCompany

    private val _editableDescription = MutableLiveData<String>()
    val editableDescription:LiveData<String>
        get() = _editableDescription*/

    var editableName = MutableLiveData<String>()

    var editableSize = MutableLiveData<String>()

    var editableCompany = MutableLiveData<String>()

    var editableDescription = MutableLiveData<String>()

    init {
//        _editableSize.value = 0
        _saveDetail.value = false
        _clearDetail.value = false
    }

    fun save() {
//        _editableName.value = _editableName.value
//        _editableSize.value = _editableSize.value
//        _editableCompany.value = _editableCompany.value
//        _editableDescription.value = _editableDescription.value
        _saveDetail.value = true
    }

    fun clear() {
        _clearDetail.value = true
    }


    /*var nameTextWatcher : TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            Timber.d("$s")
        }

        override fun afterTextChanged(s: Editable?) {

        }

    }*/
}