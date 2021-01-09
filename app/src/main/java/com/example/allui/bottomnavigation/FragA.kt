package com.example.allui.bottomnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.allui.R
import kotlinx.android.synthetic.main.fragment_frag_a.view.*


class FragA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_frag_a, container, false)

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