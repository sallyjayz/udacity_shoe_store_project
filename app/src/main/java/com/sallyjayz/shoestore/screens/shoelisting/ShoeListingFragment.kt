package com.sallyjayz.shoestore.screens.shoelisting

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.updatePadding
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.textview.MaterialTextView
import com.sallyjayz.shoestore.R
import com.sallyjayz.shoestore.databinding.FragmentShoeListingBinding
import com.sallyjayz.shoestore.model.Shoe
import timber.log.Timber


class ShoeListingFragment : Fragment() {

    private lateinit var viewModel: ShoeListingViewModel

    private lateinit var binding: FragmentShoeListingBinding

//    private val args by navArgs<ShoeListingFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_listing, container, false
        )

        /*val shoeArgs = ShoeListingFragmentArgs.fromBundle(requireArguments())

        val nameOfShoes = shoeArgs.shoeName
        val sizeOfShoes = shoeArgs.shoeSize.toDouble()
        val companyOfShoes = shoeArgs.shoeCompany
        val descOfShoes = shoeArgs.shoeDescription


        val factory = ShoeListingViewModelFactory(
            nameOfShoes,
            sizeOfShoes,
            companyOfShoes,
            descOfShoes
        )*/

        val shoeArgs = ShoeListingFragmentArgs.fromBundle(requireArguments())

        val nameOfShoes = shoeArgs.currentShoeDetail.name
        val sizeOfShoes = shoeArgs.currentShoeDetail.size
        val companyOfShoes = shoeArgs.currentShoeDetail.company
        val descOfShoes = shoeArgs.currentShoeDetail.description

        val shoe = Shoe(nameOfShoes, sizeOfShoes, companyOfShoes, descOfShoes)


        val factory = ShoeListingViewModelFactory(
            shoe
        )
        viewModel = ViewModelProvider(this, factory).get(ShoeListingViewModel::class.java)
        
        binding.shoelisting = viewModel
        binding.lifecycleOwner = this

        viewModel.shoeDetails.observe(viewLifecycleOwner, { shoe ->
            /*val shoes: MutableList<Shoe> = mutableListOf(
                shoe
            )*/

            val nameInput = MaterialTextView(requireContext())
            nameInput.setLayoutParams(
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            )
            nameInput.textSize = 25.0F
            nameInput.updatePadding(bottom = 16)
            val nameString = shoe.name
            nameInput.text = getString(R.string.nameInput, nameString)

            val sizeInput = MaterialTextView(requireContext())
            sizeInput.setLayoutParams(
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            )
//            sizeInput.text = shoe.size.toString()
            sizeInput.textSize = 25.0F
            sizeInput.updatePadding(bottom = 16)
            val sizeString = shoe.size
            sizeInput.text = getString(R.string.sizeInput, sizeString)

            val companyInput = MaterialTextView(requireContext())
            companyInput.setLayoutParams(
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            )

            companyInput.textSize = 25.0F
            companyInput.updatePadding(bottom = 16)
            val companyString = shoe.company
            companyInput.text = getString(R.string.companyInput, companyString)

            val descInput = MaterialTextView(requireContext())
            descInput.setLayoutParams(
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            )

            descInput.textSize = 25.0F
            descInput.updatePadding(bottom = 32)
            val descString = shoe.description
            descInput.text = getString(R.string.descInput, descString)

            val imageOne = ImageView(requireContext())
            imageOne.setLayoutParams(
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            )
            imageOne.setImageResource(shoe.images[0])

            val imageTwo = ImageView(requireContext())
            imageTwo.setLayoutParams(
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            )
            imageTwo.setImageResource(shoe.images[1])

            val imageThree = ImageView(requireContext())
            imageThree.setLayoutParams(
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            )
            imageThree.setImageResource(shoe.images[2])

            val imageFour = ImageView(requireContext())
            imageFour.setLayoutParams(
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            )
            imageFour.setImageResource(shoe.images[3])

            val imageFive = ImageView(requireContext())
            imageFive.setLayoutParams(
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            )
            imageFive.setImageResource(shoe.images[4])

            val imageSix = ImageView(requireContext())
            imageSix.setLayoutParams(
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            )
            imageSix.setImageResource(shoe.images[5])

            val imageSeven = ImageView(requireContext())
            imageSeven.setLayoutParams(
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            )
            imageSeven.setImageResource(shoe.images[6])

            val imageEight = ImageView(requireContext())
            imageEight.setLayoutParams(
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            )
            imageEight.setImageResource(shoe.images[7])

            val imageNine = ImageView(requireContext())
            imageNine.setLayoutParams(
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            )
            imageNine.setImageResource(shoe.images[8])

            val imageTen = ImageView(requireContext())
            imageTen.setLayoutParams(
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            )
            imageTen.setImageResource(shoe.images[9])


            binding.linearlayout.addView(nameInput)
            binding.linearlayout.addView(sizeInput)
            binding.linearlayout.addView(companyInput)
            binding.linearlayout.addView(descInput)
            binding.linearlayout.addView(imageOne)
            binding.linearlayout.addView(imageTwo)
            binding.linearlayout.addView(imageThree)
            binding.linearlayout.addView(imageFour)
            binding.linearlayout.addView(imageFive)
            binding.linearlayout.addView(imageSix)
            binding.linearlayout.addView(imageSeven)
            binding.linearlayout.addView(imageEight)
            binding.linearlayout.addView(imageNine)
            binding.linearlayout.addView(imageTen)


        })




        /*val shoeDetailFragmentArgs by navArgs<ShoeDetailFragmentArgs>()


        Timber.d("$shoeDetailFragmentArgs.shoeName")*/

        /*viewModel.shoe.observe(viewLifecycleOwner, { shoe ->
            val shoes: MutableList<Shoe> = mutableListOf(
                shoe
            )

            Timber.d("$shoes")
        })*/

//        Timber.d("${shoeDetailFragmentArgs.shoeName}")



        binding.fab.setOnClickListener {
            findNavController().navigate(
                ShoeListingFragmentDirections.actionShoeListingFragmentToShoeDetailFragment()
            )
        }
        return binding.root
    }
}