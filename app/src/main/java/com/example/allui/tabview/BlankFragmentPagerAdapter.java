package com.example.allui.tabview;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BlankFragmentPagerAdapter extends FragmentStateAdapter {

    public BlankFragmentPagerAdapter(Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @NotNull
    @Override
    public Fragment createFragment(int position) {
        switch(position) {
            case 0: return Frag3.newInstance();
            case 1: return Frag4.newInstance();
            case 2: return Frag5.newInstance();
            default: return Frag3.newInstance();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
