package com.example.allui.menu

import android.os.Bundle
import android.view.*
import android.view.ContextMenu.ContextMenuInfo
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.allui.R
import com.example.allui.toolbar.ToolbarManager
import kotlinx.android.synthetic.main.fragment_menu.*
import kotlinx.android.synthetic.main.fragment_menu.view.*


class MenuFragment : Fragment(), View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    private lateinit var rootView: View
    var menu: Menu? = null
    var actionMode: ActionMode? = null
    private var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_menu, container, false)

        navController =
            activity?.let { Navigation.findNavController(it, R.id.fragmentContainerView) }

        setupToolbar()

        rootView.btnChangeMenu.setOnClickListener(this)
        rootView.btnFloatingContextMenu.setOnClickListener(this)
        rootView.btnActionModeContextMenu.setOnClickListener(this)
        rootView.btnPopupMenu.setOnClickListener(this)

        return rootView
    }

    private fun setupToolbar() {
        ToolbarManager.getInstance()
            .setupToolbar(activity, navController, null, rootView?.toolbar, true)
        (activity as AppCompatActivity?)!!.setSupportActionBar(rootView.toolbar)
        setHasOptionsMenu(true)
    }

    override fun onClick(view: View?) {
        if (view == rootView.btnChangeMenu) {
            menu!!.clear()
            val menuInflater: MenuInflater? = activity?.getMenuInflater()
            menuInflater?.inflate(R.menu.optionsmenu, menu)
        } else if (view == rootView.btnFloatingContextMenu) {
            registerForContextMenu(btnFloatingContextMenu)
            activity?.openContextMenu(btnFloatingContextMenu)
        } else if (view == rootView.btnActionModeContextMenu) {
            actionMode = activity?.startActionMode(actionModeCallback)
            requireView().isSelected = true
        } else if (view == rootView.btnPopupMenu) {
            val popup = activity?.let { PopupMenu(it, btnPopupMenu) }
            popup?.setOnMenuItemClickListener(this)
            val inflater = popup?.menuInflater
            inflater?.inflate(R.menu.toolbar_menu, popup.menu)
            popup?.show()
        }
    }

    //Options menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        this.menu = menu
        val menuInflater: MenuInflater? = activity?.getMenuInflater()
        menuInflater?.inflate(R.menu.toolbar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.one -> {
                Toast.makeText(activity, "one clicked", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.two -> {
                Toast.makeText(activity, "two clicked", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.three -> {
                Toast.makeText(activity, "three clicked", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        if (false) { //disable item a1 according to some condition
            menu.findItem(R.id.three).isVisible = false
        }
        return super.onPrepareOptionsMenu(menu)
    }

    //Floating context menu
    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater? = activity?.menuInflater
        inflater?.inflate(R.menu.toolbar_menu, menu)
        menu.setHeaderTitle("Select The Action")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.one -> {
                Toast.makeText(activity, "one clicked", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.two -> {
                Toast.makeText(activity, "two clicked", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.three -> {
                item.isChecked = !item.isChecked
                Toast.makeText(activity, "three clicked", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }

    //Action Mode Context menu
    private val actionModeCallback: ActionMode.Callback = object : ActionMode.Callback {
        // Called when the action mode is created; startActionMode() was called
        override fun onCreateActionMode(actionMode: ActionMode, menu: Menu): Boolean {
            // Inflate a menu resource providing context menu items
            val inflater = actionMode.menuInflater
            inflater.inflate(R.menu.toolbar_menu, menu)
            return true
        }

        // Called each time the action mode is shown. Always called after onCreateActionMode, but
        // may be called multiple times if the mode is invalidated.
        override fun onPrepareActionMode(actionMode: ActionMode, menu: Menu): Boolean {
            return false // Return false if nothing is done
        }

        // Called when the user selects a contextual menu item
        override fun onActionItemClicked(actionMode: ActionMode, menuItem: MenuItem): Boolean {
            when (menuItem.itemId) {
                R.id.one -> {
                    Toast.makeText(activity, "one clicked", Toast.LENGTH_SHORT).show()
                    actionMode.finish() // Action picked, so close the CAB
                    return true
                }
                R.id.two -> {
                    Toast.makeText(activity, "two clicked", Toast.LENGTH_SHORT).show()
                    actionMode.finish() // Action picked, so close the CAB
                    return true
                }
                R.id.three -> {
                    Toast.makeText(activity, "three clicked", Toast.LENGTH_SHORT).show()
                    actionMode.finish() // Action picked, so close the CAB
                    return true
                }
            }
            return false
        }

        // Called when the user exits the action mode
        override fun onDestroyActionMode(actionMode: ActionMode) {
            var actionMode: ActionMode? = actionMode
            actionMode = null
        }
    }

    //Pop menu
    override fun onMenuItemClick(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.one -> {
                Toast.makeText(activity, "one clicked", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.two -> {
                Toast.makeText(activity, "two clicked", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.three -> {
                if (item.isChecked) item.isChecked = false else item.isChecked = true
                Toast.makeText(activity, "three clicked", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return false
    }
}