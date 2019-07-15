package com.example.manne.json.Activities;

import android.content.Context;
import android.media.Image;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;

import com.example.manne.json.Adapter.MainFragmentAdapter;
import com.example.manne.json.Fragments.AddFragment;
import com.example.manne.json.Fragments.FavouriteFragment;
import com.example.manne.json.Fragments.HomeFragment;
import com.example.manne.json.Fragments.SearchFragment;
import com.example.manne.json.Fragments.UserFragment;
import com.example.manne.json.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainFragmentsActivity extends AppCompatActivity {

    @BindView(R.id.viewPager3)
    ViewPager viewPager;
    @BindView(R.id.tabLayout2)
    TabLayout tabLayout;

    String [] images;
    String [] images2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_fragments);
        ButterKnife.bind(this);
        images  = new String[]{"home_active3x", "search_active3x", "add_active3x", "favorite_active3x", "user_active3x"};
        images2 = new String[]{"home_inactive3x", "search_inactive3x", "add_inactive3x", "favorite_inactive3x", "user_inactive3x"};
//        String [] images  = {"home_active3x", "search_active3x", "add_active3x", "favorite_active3x", "user_active3x"};
//        String [] images2 = {"home_inactive3x", "search_inactive3x", "add_inactive3x", "favorite_inactive3x", "user_inactive3x"};
        setViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        setUpViewTabs();
        tabLayout.getTabAt(0).setIcon(R.drawable.home_active3x);
        getTabLayout();


    }

    public void setViewPager(ViewPager viewPager){
        MainFragmentAdapter adapter = new MainFragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment(), "Home");
        adapter.addFragment(new SearchFragment(), "Search");
        adapter.addFragment(new AddFragment(), "Add");
        adapter.addFragment(new FavouriteFragment(), "Favorite");
        adapter.addFragment(new UserFragment(), "User");
        viewPager.setAdapter(adapter);
    }

    public void setUpViewTabs(){
        tabLayout.getTabAt(0).setIcon(R.drawable.home_inactive3x);
        tabLayout.getTabAt(1).setIcon(R.drawable.search_inactive3x);
        tabLayout.getTabAt(2).setIcon(R.drawable.add_inactive3x);
        tabLayout.getTabAt(3).setIcon(R.drawable.favorite_inactive3x);
        tabLayout.getTabAt(4).setIcon(R.drawable.user_inactive3x);
    }

//    public int getDrawableId(Context context, String name){
//        return context.getResources().getIdentifier(name,"drawable", context.getPackageName());
//    }

    public void getTabLayout() {

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int index = tab.getPosition();

//                for(int i=0; i<=4; i++){
//                    if(i==index){
//                        int imageArray[] = new int[5];
//                        imageArray[i] = getDrawableId(getApplicationContext(),"R.drawable." + images[i]);
//                        tabLayout.getTabAt(i).setIcon(imageArray[i]);
//                    }
//                }
//
                if(index==0){
                    tabLayout.getTabAt(index).setIcon(R.drawable.home_active3x);
                }
                if(index==1){
                    tabLayout.getTabAt(index).setIcon(R.drawable.search_active3x);
                }
                if(index==2){
                    tabLayout.getTabAt(index).setIcon(R.drawable.add_active3x);
                }
                if(index==3){
                    tabLayout.getTabAt(index).setIcon(R.drawable.favorite_active3x);
                }
                if(index==4){
                    tabLayout.getTabAt(index).setIcon(R.drawable.user_active3x);
                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int index = tab.getPosition();

//                for(int i=0; i<=4; i++){
//                   if(i==index) {
//                       int imageArray[] = new int[5];
//                       imageArray[i] = getDrawableId(getApplicationContext(), "R.drawable." + images2[i]);
//                       tabLayout.getTabAt(i).setIcon(imageArray[i]);
//                   }
//
//                }

                if(index==0){
                    tabLayout.getTabAt(index).setIcon(R.drawable.home_inactive3x);
                }
                if(index==1){
                    tabLayout.getTabAt(index).setIcon(R.drawable.search_inactive3x);
                }
                if(index==2){
                    tabLayout.getTabAt(index).setIcon(R.drawable.add_inactive3x);
                }
                if(index==3){
                    tabLayout.getTabAt(index).setIcon(R.drawable.favorite_inactive3x);
                }
                if(index==4){
                    tabLayout.getTabAt(index).setIcon(R.drawable.user_inactive3x);
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }



}
