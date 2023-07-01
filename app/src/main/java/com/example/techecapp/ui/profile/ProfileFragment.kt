package com.example.techecapp.ui.profile

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.techecapp.R
import com.example.techecapp.databinding.FragmentProfileBinding
import com.example.techecapp.util.Constants.SP_BASE
import com.example.techecapp.util.Constants.TOKEN


class ProfileFragment : Fragment() {
  private var _binding:FragmentProfileBinding?=null
    private val binding get()=_binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}