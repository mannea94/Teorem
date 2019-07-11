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

public class Fragment3 extends Fragment{
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
    @BindView(R.id.textView5)
    TextView textView5;
    @BindView(R.id.textView6)
    TextView textView6;
    @BindView(R.id.textView7)
    TextView textView7;

    @BindView(R.id.textF3)
    TextView textF3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3, null);
        mUnBinder = ButterKnife.bind(this, view);
        textF3.setText("15.90 CHF \nPer Month");
        textView.setText("- Ultra customizable with more a choice background every 6 months ot according to the seasons");
        textView1.setText("- No ads");
        textView2.setText("- 50 ads maximum");
        textView3.setText("- Maximum 8 photos");
        textView4.setText("- 20 HL per month to use at choice");
        textView5.setText("- Customizing shortcuts");
        textView6.setText("- Info about event");
        textView7.setText("- Online ads non stop");
        return view;
    }




    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnBinder.unbind();
    }

}
