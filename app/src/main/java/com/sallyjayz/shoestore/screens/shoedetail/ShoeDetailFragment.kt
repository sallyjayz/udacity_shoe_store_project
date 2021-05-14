package com.sallyjayz.shoestore.screens.shoedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.sallyjayz.shoestore.R
import com.sallyjayz.shoestore.databinding.FragmentShoeDetailBinding
import com.sallyjayz.shoestore.model.Shoe
import timber.log.Timber

class ShoeDetailFragment : Fragment() {

    private lateinit var viewModel: ShoeDetailViewModel
    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false
        )

        viewModel = ViewModelProvider(this).get(ShoeDetailViewModel::class.java)

        binding.shoeDetailViewModel = viewModel
        binding.lifecycleOwner = this

        var nameOfShoe = ""
        var sizeOfShoe = ""
        var companyOfShoe = ""
        var descriptionOfShoe = ""

        viewModel.editableName.observe(viewLifecycleOwner, Observer {
            Timber.i(it.toString())
            nameOfShoe = it.toString()
        })

        viewModel.editableSize.observe(viewLifecycleOwner, Observer {
//            Timber.d(it.toInt())
            sizeOfShoe = it.toString()
        })

        viewModel.editableCompany.observe(viewLifecycleOwner, Observer {
            Timber.i(it.toString())
            companyOfShoe = it.toString()
        })

        viewModel.editableDescription.observe(viewLifecycleOwner, Observer {
            Timber.i(it.toString())
            descriptionOfShoe = it.toString()
        })



//        viewModel.list.observe(viewLifecycleOwner, Observer {
//            Timber.d(it.toString())
//        })

//        viewModel.isUserInputFieldEmpty.observe(viewLifecycleOwner, Observer {
//            if (it == true) {
////                Toast.makeText(ShoeDetailFragment::class.java, "No Notes Detected",Toast.LENGTH_SHORT).show()
//                Timber.d("No Shoes Inputted")
//            }
//        })


        /*binding.cancel.setOnClickListener {
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListingFragment())
        }*/

        /*binding.save.setOnClickListener {
            findNavController().navigate(ShoeDetailFragmentDirections
                .actionShoeDetailFragmentToShoeListingFragment(nameOfShoe, Integer.valueOf(sizeOfShoe),
                    companyOfShoe, descriptionOfShoe))
        }*/

        viewModel.saveDetail.observe(viewLifecycleOwner, Observer { isSaved ->
            if (isSaved) {
                /*val nameOfShoe = viewModel.editableName.value?:""
                val sizeOfShoe = viewModel.editableSize.value?:0
                val companyOfShoe = viewModel.editableCompany.value?:""
                val descriptionOfShoe = viewModel.editableDescription.value?:""*/
//                Timber.d("$nameOfShoe $sizeOfShoe $companyOfShoe $descriptionOfShoe")
                val shoe = Shoe(nameOfShoe, sizeOfShoe.toDouble(), companyOfShoe, descriptionOfShoe)

                findNavController().navigate(ShoeDetailFragmentDirections
                    .actionShoeDetailFragmentToShoeListingFragment(shoe))
            }
        })

        viewModel.clearDetail.observe(viewLifecycleOwner, Observer { isCleared ->
            if (isCleared) {
                val shoe = Shoe("", 0.0, "", "")
                findNavController().navigate(ShoeDetailFragmentDirections
                    .actionShoeDetailFragmentToShoeListingFragment(shoe))
            }
        })

        return binding.root
    }

}