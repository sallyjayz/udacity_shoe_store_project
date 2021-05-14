package com.sallyjayz.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.sallyjayz.shoestore.R
import com.sallyjayz.shoestore.databinding.FragmentInstructionBinding
import com.sallyjayz.shoestore.model.Shoe

class InstructionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        val binding: FragmentInstructionBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_instruction, container, false)

        val shoe = Shoe("", 0.0, "", "")

        binding.shopBtn.setOnClickListener {
            findNavController().navigate(InstructionFragmentDirections
                .actionInstructionFragmentToShoeListingFragment(shoe))
        }

        return binding.root
    }
}