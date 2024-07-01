package ru.itis.homework2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> findNavController().navigate(R.id.homeFragment)
                R.id.searchFragment -> findNavController().navigate(R.id.searchFragment)
                R.id.settingsFragment -> findNavController().navigate(R.id.settingsFragment)
                R.id.notificationsFragment -> findNavController().navigate(R.id.notificationsFragment)
                R.id.profileFragment -> findNavController().navigate(R.id.profileFragment)
            }
            true
        }

        return view
    }
}