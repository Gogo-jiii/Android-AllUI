package com.example.allui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.HashSet;
import java.util.Set;

public class NavigationHandler {

    private static NavigationHandler instance = null;
    private Set<Integer> topLevelDestinations;
    private AppBarConfiguration appBarConfiguration;

    private NavigationHandler() {
    }

    public static NavigationHandler getInstance() {
        if (null == instance) {
            instance = new NavigationHandler();
        }
        return instance;
    }

    void setupNavigation(AppCompatActivity activity, NavController navController) {
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                setToolbarTitle(destination);
            }
        });

        setTopLevelDestinations();
        NavigationUI.setupActionBarWithNavController(activity, navController, appBarConfiguration);
    }

    private void setTopLevelDestinations() {
        topLevelDestinations = new HashSet<>();
        topLevelDestinations.add(R.id.dashboardFragment);
        //topLevelDestinations.add(R.id.fragB);
        appBarConfiguration = new AppBarConfiguration.Builder(topLevelDestinations)
                .build();
    }

    private void setToolbarTitle(NavDestination destination) {
        if (destination.getLabel().equals("fragment_dashboard"))
            destination.setLabel("Dashboard");
        else if (destination.getLabel().equals("ToolbarFragment"))
            destination.setLabel("Toolbar Fragment");
    }
}
