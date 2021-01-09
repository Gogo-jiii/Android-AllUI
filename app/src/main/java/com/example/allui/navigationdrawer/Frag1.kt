package com.example.allui.navigationdrawer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.allui.R
import kotlinx.android.synthetic.main.fragment_frag1.view.*


class Frag1 : Fragment() {

    private var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_frag1, container, false)

        navController = activity?.let { Navigation.findNavController(it, R.id.fragmentNavDrawerContainerView) }

        view.btnGoto2ndFrag.setOnClickListener {
            navController?.navigate(R.id.action_frag1_to_frag2)
        }
        return view
    }

}