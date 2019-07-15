package com.example.manne.json.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import com.example.manne.json.Adapter.ArticleAdapter;
import com.example.manne.json.Models.Subscriber;
import com.example.manne.json.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by manne on 08.7.2019.
 */

public class FragmentArticle extends Fragment{
    public Unbinder mUnBinder;
    @BindView(R.id.recyclerViewArticle)
    RecyclerView recyclerView;
    ArticleAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_article, null);
        mUnBinder = ButterKnife.bind(this, view);
        adapter=new ArticleAdapter(getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        recyclerView.setAdapter(adapter);
        getList();

        return view;
    }

    public void getList(){
        ArrayList<Subscriber> subscribers = new ArrayList<>();
        subscribers.add(new Subscriber("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcScrOSw32PsZ9O2EVpooahh4B7PG2nh38jn2Y3dvMuGZUzuU2xIqg"));
        subscribers.add(new Subscriber("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcScrOSw32PsZ9O2EVpooahh4B7PG2nh38jn2Y3dvMuGZUzuU2xIqg"));
        subscribers.add(new Subscriber("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcScrOSw32PsZ9O2EVpooahh4B7PG2nh38jn2Y3dvMuGZUzuU2xIqg"));
        subscribers.add(new Subscriber("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcScrOSw32PsZ9O2EVpooahh4B7PG2nh38jn2Y3dvMuGZUzuU2xIqg"));
        subscribers.add(new Subscriber("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcScrOSw32PsZ9O2EVpooahh4B7PG2nh38jn2Y3dvMuGZUzuU2xIqg"));
        subscribers.add(new Subscriber("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcScrOSw32PsZ9O2EVpooahh4B7PG2nh38jn2Y3dvMuGZUzuU2xIqg"));
        adapter.setItems(subscribers);
    }





    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnBinder.unbind();
    }

}
