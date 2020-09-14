package com.matthewcannefax.fragmentandapipractice.ui.main;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.navigation.NavController;

public class MainViewModel extends ViewModel {

    private Fragment currentFragment;
    private NavController navController;

    public void setNavController(NavController navController) {
        this.navController = navController;
    }

    public NavController getNavController() {
        return navController;
    }

    public void setCurrentFragment(Fragment currentFragment) {
        this.currentFragment = currentFragment;
    }

    public Fragment getCurrentFragment() {
        return currentFragment;
    }
}