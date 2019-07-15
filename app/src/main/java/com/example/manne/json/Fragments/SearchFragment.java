package com.example.manne.json.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.manne.json.Adapter.FragmentAdapter;
import com.example.manne.json.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by manne on 08.7.2019.
 */

public class SearchFragment extends Fragment{
    public Unbinder mUnBinder;
    @BindView(R.id.viewPager2)
    ViewPager pager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    FragmentAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_fragment, null);
        mUnBinder = ButterKnife.bind(this, view);

        setUpViewPager(pager);
        tabLayout.setupWithViewPager(pager);

        return view;


    }

    public void setUpViewPager(ViewPager viewPager){
        FragmentAdapter adapter = new FragmentAdapter(getChildFragmentManager());
        adapter.addFragment(new FragmentArticle(), "Article");
        adapter.addFragment(new FragmentSubscriber(), "Subscriber");
        pager.setAdapter(adapter);
    }




    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnBinder.unbind();
    }

}
