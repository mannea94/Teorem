package com.example.manne.json.Activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.example.manne.json.Adapter.FragmentAdapter;
import com.example.manne.json.Fragments.FragmentMessages;
import com.example.manne.json.Fragments.FragmentNotifications;
import com.example.manne.json.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MessageNotificationActivity extends AppCompatActivity {

    @BindView(R.id.viewPager2)
    ViewPager viewPager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_message_notification);
        ButterKnife.bind(this);

        setViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void setViewPager(ViewPager viewPager){
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentMessages(), "Messages");
        adapter.addFragment(new FragmentNotifications(),"Notifications");
        viewPager.setAdapter(adapter);
    }
}
