package com.example.manne.json.Activities;

import android.app.Fragment;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;

import com.example.manne.json.Adapter.FragmentAdapter;
import com.example.manne.json.Adapter.SubscriberAdapter;
import com.example.manne.json.Fragments.FragmentArticle;
import com.example.manne.json.Fragments.FragmentSubscriber;
import com.example.manne.json.Models.User;
import com.example.manne.json.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends AppCompatActivity {
    @BindView(R.id.viewPager2)
    ViewPager pager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    FragmentAdapter adapter;

//    @BindView(R.id.recyclerViewSubscribers)
//    RecyclerView recyclerView;

    SubscriberAdapter adapter2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);




        setUpViewPager(pager);
        tabLayout.setupWithViewPager(pager);

    }

    public void setUpViewPager(ViewPager viewPager){
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentArticle(), "Article");
        adapter.addFragment(new FragmentSubscriber(), "Subscriber");
        pager.setAdapter(adapter);
    }

//    public void getList(){
//        ArrayList<User> users = new ArrayList<>();
//        users.add(new User("Mary Jane"));
//        users.add(new User("Mary Jane"));
//
//    }

}
