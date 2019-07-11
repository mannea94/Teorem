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

public class Fragment4 extends Fragment{
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
    @BindView(R.id.textF4)
    TextView textF4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment4, null);
        mUnBinder = ButterKnife.bind(this, view);
        textF4.setText("49.90 CHF \nPer Month");
        textView.setText("- 70 advertisements and 30 HL per month");
        textView1.setText("- Selection per TOP TREND articles");
        textView2.setText("- Market tab independent of others");
        textView3.setText("- Possibility to include a website");
        textView4.setText("- Info about EVENTS");
        textView5.setText("- Customizing shortcuts");
        textView6.setText("- Website on the UT profil");
        textView7.setText("- Promotion of their articles as advertisements or creation of special content that will be highlighted on the app");
        return view;
    }




    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnBinder.unbind();
    }

}
