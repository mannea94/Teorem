package com.example.manne.json.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.manne.json.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by manne on 08.7.2019.
 */

public class Fragment2 extends Fragment{
    public Unbinder mUnBinder;

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.textView1)
    TextView textView1;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.textF2)
    TextView textF2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, null);
        mUnBinder = ButterKnife.bind(this, view);
        textF2.setText("9.90 CHF \nPer Month");
        textView.setText("- Customizable shop");
        textView1.setText("- Maximum 25 listings with 5 photos");
        textView2.setText("- Advertising only on home");
        textView3.setText("- 3 HL per week");
        textView4.setText("- Online ads for 30 consecutive days");
        return view;
    }




    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnBinder.unbind();
    }

}
