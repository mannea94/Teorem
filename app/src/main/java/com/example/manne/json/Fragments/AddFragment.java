package com.example.manne.json.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.manne.json.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by manne on 08.7.2019.
 */

public class AddFragment extends Fragment{
    public Unbinder mUnBinder;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_fragment, null);
        mUnBinder = ButterKnife.bind(this, view);

        return view;
    }




    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnBinder.unbind();
    }

}