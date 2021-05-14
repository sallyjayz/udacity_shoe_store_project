package com.sallyjayz.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.sallyjayz.shoestore.R
import com.sallyjayz.shoestore.databinding.FragmentLoginBinding

class LoginScreenFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )

        binding.newLoginBtn.setOnClickListener{
            findNavController().navigate(LoginScreenFragmentDirections
                .actionLoginScreenFragmentToWelcomeScreenFragment())
        }

        binding.existingLoginBtn.setOnClickListener{
            findNavController().navigate(LoginScreenFragmentDirections
                .actionLoginScreenFragmentToWelcomeScreenFragment())
        }

        return binding.root
    }
}