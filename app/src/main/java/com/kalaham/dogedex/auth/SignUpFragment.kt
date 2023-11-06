package com.kalaham.dogedex.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kalaham.dogedex.R
import com.kalaham.dogedex.databinding.FragmentLoginBinding
import com.kalaham.dogedex.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSignUpBinding.inflate(inflater)
        return binding.root
    }
}