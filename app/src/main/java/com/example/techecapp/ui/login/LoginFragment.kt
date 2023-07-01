package com.example.techecapp.ui.login

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.techecapp.R
import com.example.techecapp.databinding.FragmentLoginBinding
import com.example.techecapp.util.Constants
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding?=null
    private val binding get()=_binding!!
    private val auth=FirebaseAuth.getInstance()
    private lateinit var sp: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
        binding.logindBtn.setOnClickListener(){
            registerUser(it)
            //findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }
    }
    private fun setup(){
        sp=requireActivity().getSharedPreferences(Constants.SP_BASE, Context.MODE_PRIVATE)
        checkUser()

    }
    private fun checkUser(){
        val token=sp.getString(Constants.TOKEN,null)
        if(token==null){
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
        }
    }
    private fun registerUser(view: View){
        val email=binding.emailInput.text.toString().trim()
        val passw=binding.passwInput.text.toString().trim()
//        if(email.isNotEmpty() && passw.isNotEmpty()){
//            auth.createUserWithEmailAndPassword(email,passw).addOnCompleteListener {
//                if(it.isSuccessful){
//                    // Snackbar.make(it,"Email bos ola bilmez!", Snackbar.LENGTH_LONG).show()
//                    Toast.makeText(context, "Email Success", Toast.LENGTH_LONG).show()
//                    findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
//                }else{
//                    Toast.makeText(context, it.exception?.message, Toast.LENGTH_LONG).show()
//                }
//            }
//        }else{
//            Toast.makeText(context, "Email bos ola bilmez!", Toast.LENGTH_LONG).show()
//
//       }

        auth.signInWithEmailAndPassword(email,passw).addOnCompleteListener {

            if(it.isSuccessful){
                   // Snackbar.make(view,"Email bos ola bilmez!", Snackbar.LENGTH_LONG).show()
                    Toast.makeText(context, "Login Success", Toast.LENGTH_LONG).show()
                    findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                }else{
                    Toast.makeText(context, it.exception?.message, Toast.LENGTH_LONG).show()
                }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}