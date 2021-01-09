package com.example.allui.toolbar

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.allui.R
import kotlinx.android.synthetic.main.fragment_toolbar.view.*


class ToolbarFrag : Fragment() {

    private var rootView: View? = null
    private var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_toolbar, container, false)
        navController =
            activity?.let { Navigation.findNavController(it, R.id.fragmentContainerView) }

        setupToolbar()
        return rootView
    }

    private fun setupToolbar() {
        ToolbarManager.getInstance()
            .setupToolbar(activity, navController, null,rootView?.toolbar1, true)

        setupOverflowMenu()
    }

    private fun setupOverflowMenu() {
        rootView?.toolbar1?.inflateMenu(R.menu.toolbar_menu)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            rootView?.toolbar1?.overflowIcon = activity?.resources?.getDrawable(
                R.drawable.ic_more_vert,
                null
            )
        }
        rootView?.toolbar1?.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.one -> {
                    Toast.makeText(activity, "One", Toast.LENGTH_SHORT).show()
                }
                R.id.two -> {
                    Toast.makeText(activity, "Two", Toast.LENGTH_SHORT).show()
                }
                R.id.three -> {
                    Toast.makeText(activity, "Three", Toast.LENGTH_SHORT).show()
                }
            }
            false
        }
    }

}