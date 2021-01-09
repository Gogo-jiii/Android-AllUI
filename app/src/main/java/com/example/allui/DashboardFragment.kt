package com.example.allui

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.allui.dialogfragment.MyDialogFragment
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_dashboard.view.*

class DashboardFragment : Fragment(), View.OnClickListener {

    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        navController =
            activity?.let { Navigation.findNavController(it, R.id.fragmentContainerView) }

        view.btnToolbarGraph.setOnClickListener(this)
        view.btnNavDrawer.setOnClickListener(this)
        view.btnTabView.setOnClickListener(this)
        view.btnBottomNavigation.setOnClickListener(this)
        view.btnDialogFragment.setOnClickListener(this)
        view.btnMenus.setOnClickListener(this)
        return view
    }

    override fun onClick(view: View?) {
        if (view == btnToolbarGraph) {
            navController?.navigate(R.id.action_dashboardFragment_to_toolbarFrag)
        } else if (view == btnNavDrawer) {
            navController?.navigate(R.id.action_dashboardFragment_to_navigationDrawerActivity2)
        } else if (view == btnTabView) {
            navController?.navigate(R.id.action_dashboardFragment_to_tabViewActivity)
        } else if (view == btnBottomNavigation) {
            navController?.navigate(R.id.action_dashboardFragment_to_bottomNavigationActivity)
        } else if (view == btnDialogFragment) {
            navController?.navigate(R.id.action_dashboardFragment_to_myDialogFragment)
        } else if (view == btnMenus) {
            navController?.navigate(R.id.action_dashboardFragment_to_menuFragment)
        }
    }
}