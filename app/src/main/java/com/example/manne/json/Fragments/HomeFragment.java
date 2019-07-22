package com.example.manne.json.Fragments;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.manne.json.Activities.FirstActivity;
import com.example.manne.json.Activities.MessageNotificationActivity;
import com.example.manne.json.Activities.ShopActivity;
import com.example.manne.json.Activities.ValidationActivity;
import com.example.manne.json.Adapter.AdAdapter;
import com.example.manne.json.Adapter.ArticleAdapter2;
import com.example.manne.json.Adapter.ButtonAdapter;
import com.example.manne.json.Adapter.MessageAdapter2;
import com.example.manne.json.Models.Preview;
import com.example.manne.json.Models.Subscriber;
import com.example.manne.json.Models.User;
import com.example.manne.json.R;
import com.example.manne.json.SharedPreferences;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import kotlin.BuilderInference;

/**
 * Created by manne on 08.7.2019.
 */

public class HomeFragment extends Fragment{
    public Unbinder mUnBinder;

//    @BindView(R.id.buttonMessNot)
//    Button messNot;
//    @BindView(R.id.buttonValidation)
//    Button button;
    @BindView(R.id.messageIcon)
    ImageView messageIcon;
    @BindView(R.id.recyclerViewButton)
    RecyclerView recyclerView;
    @BindView(R.id.recyclerViewArticle2)
            RecyclerView recyclerView2;

    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefresh;

//    @BindView(R.id.imageProduct)
//    ImageView imageProduct;

    @BindView(R.id.recyclerViewAd)
    RecyclerView recyclerViewAd;
    AdAdapter adAdapter;

    ButtonAdapter adapter;
    ArticleAdapter2 adapter2;

    String imgUrl="https://www.google.com/search?rlz=1C2CHZL_enMK710MK710&biw=1366&bih=667&tbm=isch&sa=1&ei=gu8uXbT6F4_HwAKgwp1Y&q=red+color+background&oq=red+color+backgro&gs_l=img.3..35i39j0i19l9.17126.21102..21747...0.0..0.700.2649.1j2j4-1j2j1......0....1..gws-wiz-img.EHseKqJzs2Q#imgrc=rHOJFbbdPfivQM:";

//    @BindView(R.id.buttonShop)
//    Button shopButton;
//    @BindView(R.id.logoutButton)
//    Button logoutButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, null);
        mUnBinder = ButterKnife.bind(this, view);

        messageIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MessageNotificationActivity.class);
                startActivity(intent);
            }
        });

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(), ValidationActivity.class);
//                startActivity(intent);
//            }
//        });
        adapter=new ButtonAdapter(getContext());
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);
        recyclerView.setAdapter(adapter);
        getList();

        adapter2=new ArticleAdapter2(getContext());
        recyclerView2.setHasFixedSize(true);
        LinearLayoutManager horizontalLayoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(horizontalLayoutManager2);
        recyclerView2.setAdapter(adapter2);
        getList2();

        refreshImage();

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefresh.setRefreshing(true);
                refreshImage();
            }
        });


//        shopButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(), ShopActivity.class);
//                startActivity(intent);
//            }
//        });

//        logoutButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                User user = new User();
//                user.setUsername("");
//                SharedPreferences.addUser(user, getActivity());
//                Intent intent = new Intent(getActivity(), FirstActivity.class);
//                startActivity(intent);
//                getActivity().finish();
//            }
//        });

        return view;
    }


    public void getList(){
        ArrayList<Subscriber> subscribers = new ArrayList<>();
        subscribers.add(new Subscriber("Men"));
        subscribers.add(new Subscriber("Woman"));
        subscribers.add(new Subscriber("Mixed"));
        subscribers.add(new Subscriber("Adult accessories"));
        subscribers.add(new Subscriber("Children"));
        adapter.setItems(subscribers);
    }

    public void getList2(){
        ArrayList<Subscriber> subscribers = new ArrayList<>();
        subscribers.add(new Subscriber(imgUrl));
        subscribers.add(new Subscriber(imgUrl));
        subscribers.add(new Subscriber(imgUrl));
        subscribers.add(new Subscriber(imgUrl));
        subscribers.add(new Subscriber(imgUrl));
        adapter2.setItems(subscribers);
    }

    public void refreshImage(){
        Preview preview = new Preview();
        preview = SharedPreferences.getPreview(getActivity());
//        imageProduct.setImageBitmap(BitmapFactory.decodeFile(preview.getImgPaths().get(0)));
        adAdapter=new AdAdapter(getContext());
        recyclerViewAd.setHasFixedSize(true);
        recyclerViewAd.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewAd.setAdapter(adAdapter);
        adAdapter.notifyDataSetChanged();
        getList3();
        swipeRefresh.setRefreshing(false);
    }

    public void getList3(){
        ArrayList<Preview> previews = new ArrayList<>();
//        adAdapter=new AdAdapter(getContext());
        Preview preview = new Preview();
        preview = SharedPreferences.getPreview(getActivity());
        previews.add(new Preview(preview.getImgPaths(), preview.name, preview.price, preview.currency, preview.description));
        adAdapter.setItems(previews);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnBinder.unbind();
    }

}
