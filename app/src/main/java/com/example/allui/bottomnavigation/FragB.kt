package com.example.allui.bottomnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.allui.R
import kotlinx.android.synthetic.main.fragment_frag_a.view.*

class FragB : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_frag_b, container, false)

        val navController =
            activity?.let { Navigation.findNavController(it, R.id.fragmentContainerBottomNav) }
        val appbarConfiguration =
            ToolbarManager.getInstance().setTopLevelDestinationsBottomNavigation()
        ToolbarManager.getInstance().setupToolbar(
            activity, navController, appbarConfiguration, rootView.toolbar4, false
        )
        return rootView
    }

}