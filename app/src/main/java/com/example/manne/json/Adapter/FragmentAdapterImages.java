package com.example.manne.json.Adapter;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.manne.json.Fragments.FragmentImages;
import com.example.manne.json.Models.Preview;


import java.util.ArrayList;

/**
 * Created by manne on 22.12.2017.
 */

public class FragmentAdapterImages extends FragmentPagerAdapter {
    public FragmentAdapterImages(FragmentManager fm, ArrayList<String> preview_) {
        super(fm);
        preview.imgPaths= preview_;
    }

    public Preview preview = new Preview();

    @Override
    public Fragment getItem(int position) {
        return FragmentImages.newInstance(preview.imgPaths.get(position));
    }

    @Override
    public int getCount() {
        return preview.imgPaths.size();
    }
}
