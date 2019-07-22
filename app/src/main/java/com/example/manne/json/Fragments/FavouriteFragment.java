package com.example.manne.json.Fragments;

import android.content.Intent;
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

import com.example.manne.json.Activities.ValidationActivity;
import com.example.manne.json.Adapter.AdAdapter;
import com.example.manne.json.Models.Preview;
import com.example.manne.json.R;
import com.example.manne.json.SharedPreferences;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by manne on 08.7.2019.
 */

public class FavouriteFragment extends Fragment{
    public Unbinder mUnBinder;

    @BindView(R.id.buttonValidation)
    Button button;
    @BindView(R.id.recyclerViewAd)
    RecyclerView recyclerView;
    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefresh;
    AdAdapter adAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.favourite_fragment, null);
        mUnBinder = ButterKnife.bind(this, view);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ValidationActivity.class);
                startActivity(intent);
            }
        });

        swipeRef();

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefresh.setRefreshing(true);
                swipeRef();
            }
        });

        return view;
    }


    public void swipeRef(){
        adAdapter=new AdAdapter(getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adAdapter);
        adAdapter.notifyDataSetChanged();
        getList();
        swipeRefresh.setRefreshing(false);
    }

    public void getList(){
        ArrayList<Preview> previews = new ArrayList<>();
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
