package com.example.manne.json.Activities;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.manne.json.Fragments.Fragment1;
import com.example.manne.json.Fragments.Fragment2;
import com.example.manne.json.Fragments.Fragment3;
import com.example.manne.json.Fragments.Fragment4;
import com.example.manne.json.Adapter.MyPageAdapter;
import com.example.manne.json.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubscriptionActivity extends AppCompatActivity {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.SliderDots)
    LinearLayout sliderDotspanel;
    @BindView(R.id.iconLogin)
    ImageView iconLogin;
    @BindView(R.id.validateButton)
    Button validateButton;
    private int dotscount;
    private ImageView[] dots;
    MyPageAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_subscription);
        ButterKnife.bind(this);

        iconLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubscriptionActivity.this, ShopCreationActivity.class);
                startActivity(intent);
            }
        });


        viewPagerAdapter =  new MyPageAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.addFragment(new Fragment1());
        viewPagerAdapter.addFragment(new Fragment2());
        viewPagerAdapter.addFragment(new Fragment3());
        viewPagerAdapter.addFragment(new Fragment4());
        viewPager.setAdapter(viewPagerAdapter);
//        setUpViewPager(viewPager);

        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for(int i = 0; i < dotscount; i++){

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    //    public void setUpViewPager(ViewPager viewPager){
//        MyPageAdapter adapter = new MyPageAdapter(this.getSupportFragmentManager());
//        adapter.addFragment(new Fragment1());
//        adapter.addFragment(new Fragment2());
//        adapter.addFragment(new Fragment3());
//        adapter.addFragment(new Fragment4());
//        viewPager.setAdapter(adapter);
//    }
}
