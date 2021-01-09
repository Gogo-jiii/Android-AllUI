package com.example.allui.tabview.transform;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

import org.jetbrains.annotations.NotNull;

public class FadeOutTransformation implements ViewPager2.PageTransformer{

    @Override
    public void transformPage(@NonNull @NotNull View page, float position) {
        page.setTranslationX(-position*page.getWidth());

        page.setAlpha(1-Math.abs(position));
    }
}