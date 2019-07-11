package com.example.manne.json.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.manne.json.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by manne on 08.7.2019.
 */

public class Fragment1 extends Fragment{
    public Unbinder mUnBinder;

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.textView1)
    TextView textView1;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.textView3)
    TextView textView3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, null);
        mUnBinder = ButterKnife.bind(this, view);
        textView.setText("-Maximum 10 advertisements");
        textView1.setText("-Thematic advertisement mode and co.(HOME + ads last picture(4th Photo and Market Place Central");
        textView2.setText("-Ads online 14 days and reactivate the put back online");
        textView3.setText("-Maximum 3 photos per article");
        return view;
    }




    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnBinder.unbind();
    }

}
