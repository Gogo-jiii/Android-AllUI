package com.example.allui.tabview

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.allui.R
import com.example.allui.tabview.transform.*
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_tab_view.view.*


class TabViewFragment : Fragment() {

    private var rootView: View? = null
    var titleArray = arrayOf("Frag3", "Frag4", "Frag5")
    var iconArray = arrayOf(R.drawable.ic_android, R.drawable.ic_baseline_home, R.drawable.ic_baseline_group)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_tab_view, container, false)

        val navController =
            activity?.let { Navigation.findNavController(it, R.id.fragmentContainerTabView) }
        ToolbarManager.getInstance().setupToolbar(
            activity, navController, null,rootView?.toolbar3, false
        )

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPagerAndTablayout()
    }

    private fun setupViewPagerAndTablayout() {
        var blankFragmentPagerAdapter =
            BlankFragmentPagerAdapter(this)
        rootView?.viewPager?.adapter = blankFragmentPagerAdapter

        //Tab title
        rootView?.viewPager?.let {
            rootView?.tabLayout?.let { it1 ->
                TabLayoutMediator(
                    it1, it
                ) { tab: TabLayout.Tab, position: Int ->
                    tab.text = titleArray[position]
                    tab.setIcon(iconArray[position])
                }.attach()
            }
        }

        rootView?.viewPager?.setPageTransformer(PopTransformation())
    }
}