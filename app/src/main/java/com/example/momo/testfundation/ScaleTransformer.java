package com.example.momo.testfundation;

import android.view.View;


/**
 * Created by wangsiyuan on 2017/7/26.
 */
public class ScaleTransformer implements GalleryLayoutManager.ItemTransformer {

    private int mOffset = 20;

    @Override
    public void transformItem(GalleryLayoutManager layoutManager, View item, float fraction) {
        item.setPivotX(item.getWidth() / 2.0f);
        item.setPivotY(item.getHeight() / 2.0f);
        float scale;
        scale = 1.5f - 0.5f * Math.abs(fraction);
        item.setScaleX(scale);
        item.setScaleY(scale);
        item.setTranslationX(mOffset * fraction);
    }
}
