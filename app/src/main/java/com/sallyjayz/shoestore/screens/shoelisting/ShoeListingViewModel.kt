package com.sallyjayz.shoestore.screens.shoelisting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sallyjayz.shoestore.R
import com.sallyjayz.shoestore.model.Shoe

class ShoeListingViewModel(shoe: Shoe): ViewModel() {

    private val _shoeDetails = MutableLiveData<Shoe>()
    val shoeDetails: LiveData<Shoe>
        get() = _shoeDetails

    /*private val _shoeName = MutableLiveData<String>()
    val name: LiveData<String>
        get() = _shoeName

    private val _shoeSize = MutableLiveData<Double>()
    val size: LiveData<Double>
        get() = _shoeSize

    private val _shoeCompany = MutableLiveData<String>()
    val company: LiveData<String>
        get() = _shoeCompany

    private val _shoeDescription = MutableLiveData<String>()
    val description: LiveData<String>
        get() = _shoeDescription*/

    private lateinit var imageList: MutableList<Int>

    init {
//        resetImageList()
        shoeListDetails(shoe.name, shoe.size, shoe.company, shoe.description)
    }

    private fun shoeListDetails(name: String, size: Double, company: String, description: String) {
        if ("{${shoeDetails.value}}".isNotBlank())
            imageList = mutableListOf(
                R.drawable.best_running_shoes,
                R.drawable.drink_cup_shoes,
                R.drawable.fluevog_shoes,
                R.drawable.moon_shoes,
                R.drawable.netha_goldberg,
                R.drawable.nina_shoes,
                R.drawable.pump_shoes,
                R.drawable.sport_shoes,
                R.drawable.super_shoes,
                R.drawable.versace_fashion)
        _shoeDetails.value = Shoe(name, size, company, description, imageList)
    }

    /*private fun resetImageList() {
        imageList = mutableListOf(
            R.drawable.best_running_shoes,
            R.drawable.drink_cup_shoes,
            R.drawable.fluevog_shoes,
            R.drawable.moon_shoes,
            R.drawable.netha_goldberg,
            R.drawable.nina_shoes,
            R.drawable.pump_shoes,
            R.drawable.sport_shoes,
            R.drawable.super_shoes,
            R.drawable.versace_fashion
        )
    }*/

}

/*class ShoeListingViewModel(name: String, size: Double, company: String,
                           description: String): ViewModel() {

    private val _shoeDetails = MutableLiveData<Shoe>()
    val shoeDetails: LiveData<Shoe>
        get() = _shoeDetails

private val _shoeName = MutableLiveData<String>()
    val name: LiveData<String>
        get() = _shoeName

    private val _shoeSize = MutableLiveData<Double>()
    val size: LiveData<Double>
        get() = _shoeSize

    private val _shoeCompany = MutableLiveData<String>()
    val company: LiveData<String>
        get() = _shoeCompany

    private val _shoeDescription = MutableLiveData<String>()
    val description: LiveData<String>
        get() = _shoeDescription


    private lateinit var imageList: MutableList<Int>

    init {
        resetImageList()
        shoeListDetails(name, size, company, description)
    }

    private fun shoeListDetails(name: String, size: Double, company: String, description: String) {
        if ("{${shoeDetails.value}}".isNotBlank())
            imageList = mutableListOf(
                R.drawable.best_running_shoes,
                R.drawable.drink_cup_shoes,
                R.drawable.fluevog_shoes,
                R.drawable.moon_shoes,
                R.drawable.netha_goldberg,
                R.drawable.nina_shoes,
                R.drawable.pump_shoes,
                R.drawable.sport_shoes,
                R.drawable.super_shoes,
                R.drawable.versace_fashion)
            _shoeDetails.value = Shoe(name, size, company, description, imageList)
    }

private fun resetImageList() {
        imageList = mutableListOf(
            R.drawable.best_running_shoes,
            R.drawable.drink_cup_shoes,
            R.drawable.fluevog_shoes,
            R.drawable.moon_shoes,
            R.drawable.netha_goldberg,
            R.drawable.nina_shoes,
            R.drawable.pump_shoes,
            R.drawable.sport_shoes,
            R.drawable.super_shoes,
            R.drawable.versace_fashion
        )
    }


}*/
