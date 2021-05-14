package com.sallyjayz.shoestore.screens.shoelisting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sallyjayz.shoestore.model.Shoe
import com.sallyjayz.shoestore.screens.shoedetail.ShoeDetailViewModel
import java.lang.IllegalArgumentException

class ShoeListingViewModelFactory (private val shoe: Shoe) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShoeListingViewModel::class.java)) {
            return ShoeListingViewModel(shoe) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

/*class ShoeListingViewModelFactory (private val name: String, private val size: Double,
                                   private val company: String,
                                   private val description: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShoeListingViewModel::class.java)) {
            return ShoeListingViewModel(name, size, company, description) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}*/
