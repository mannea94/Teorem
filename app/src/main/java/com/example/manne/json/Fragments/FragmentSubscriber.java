package com.example.manne.json.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manne.json.Adapter.SubscriberAdapter;
import com.example.manne.json.Models.Subscriber;
import com.example.manne.json.Models.User;
import com.example.manne.json.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by manne on 08.7.2019.
 */

public class FragmentSubscriber extends Fragment{
    public Unbinder mUnBinder;
    @BindView(R.id.recyclerViewSubscribers)
    RecyclerView recyclerView;

    SubscriberAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subscriber, null);
        mUnBinder = ButterKnife.bind(this, view);
        adapter=new SubscriberAdapter(getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        getList();

        return view;

    }

    public void getList(){
        ArrayList<Subscriber> subscribers = new ArrayList<>();
        subscribers.add(new Subscriber("Mary Jane","https://cdn1.iconfinder.com/data/icons/business-users/512/circle-512.png"));
        subscribers.add(new Subscriber("Mary Jane","https://cdn1.iconfinder.com/data/icons/business-users/512/circle-512.png"));
        subscribers.add(new Subscriber("Mary Jane","https://cdn1.iconfinder.com/data/icons/business-users/512/circle-512.png"));
        subscribers.add(new Subscriber("Mary Jane","https://cdn1.iconfinder.com/data/icons/business-users/512/circle-512.png"));
        subscribers.add(new Subscriber("Mary Jane","https://cdn1.iconfinder.com/data/icons/business-users/512/circle-512.png"));
        subscribers.add(new Subscriber("Mary Jane","https://cdn1.iconfinder.com/data/icons/business-users/512/circle-512.png"));
        adapter.setItems(subscribers);
    }




    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnBinder.unbind();
    }

}
