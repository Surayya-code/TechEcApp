package com.example.techecapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.techecapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

      setup()
    }

    private fun setup(){
        with(binding){
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

            val navController=navHostFragment.navController
            bottomNavBar.setupWithNavController(navController)
           // bottomNavigationView.setupWithNavController(navController)

            navHostFragment.navController.addOnDestinationChangedListener{_,destination,_->
                when(destination.id){
                    R.id.splashFragment->binding.bottomNavBar.visibility= View.GONE
                    R.id.loginFragment -> binding.bottomNavBar.visibility = View.GONE

                    else->binding.bottomNavBar.visibility= View.VISIBLE
                }

            }

        }
    }
}