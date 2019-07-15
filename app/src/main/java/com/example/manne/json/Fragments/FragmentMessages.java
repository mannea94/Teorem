package com.example.manne.json.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.manne.json.Adapter.ArticleAdapter;
import com.example.manne.json.Adapter.MessageAdapter;
import com.example.manne.json.Adapter.MessageAdapter2;
import com.example.manne.json.Models.Subscriber;
import com.example.manne.json.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by manne on 08.7.2019.
 */

public class FragmentMessages extends Fragment{
    public Unbinder mUnBinder;
    @BindView(R.id.recyclerViewMessageHor)
    RecyclerView recyclerView;
    @BindView(R.id.recyclerViewMessageVer)
    RecyclerView recyclerView2;
    MessageAdapter adapter;
    MessageAdapter2 adapter2;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_messages, null);
        mUnBinder = ButterKnife.bind(this, view);

        adapter=new MessageAdapter(getContext());
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);
        recyclerView.setAdapter(adapter);
        getList();

        adapter2=new MessageAdapter2(getContext());
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView2.setAdapter(adapter2);
        getList2();

        return view;
    }

    public void getList(){
        ArrayList<Subscriber> subscribers = new ArrayList<>();
        subscribers.add(new Subscriber("https://image.flaticon.com/icons/png/512/149/149071.png"));
        subscribers.add(new Subscriber("https://image.flaticon.com/icons/png/512/149/149071.png"));
        subscribers.add(new Subscriber("https://image.flaticon.com/icons/png/512/149/149071.png"));
        subscribers.add(new Subscriber("https://image.flaticon.com/icons/png/512/149/149071.png"));
        subscribers.add(new Subscriber("https://image.flaticon.com/icons/png/512/149/149071.png"));
        subscribers.add(new Subscriber("https://image.flaticon.com/icons/png/512/149/149071.png"));
        subscribers.add(new Subscriber("https://image.flaticon.com/icons/png/512/149/149071.png"));
        adapter.setItems(subscribers);
    }

    public void getList2(){
        ArrayList<Subscriber> subscribers = new ArrayList<>();
        subscribers.add(new Subscriber("Mary Jane", "23 min","Thank you very much", "https://image.flaticon.com/icons/png/512/149/149071.png"));
        subscribers.add(new Subscriber("Mary Jane", "23 min", "Thank you very much", "https://image.flaticon.com/icons/png/512/149/149071.png"));
        subscribers.add(new Subscriber("Mary Jane", "23 min", "Thank you very much", "https://image.flaticon.com/icons/png/512/149/149071.png"));
        subscribers.add(new Subscriber("Mary Jane", "23 min", "Thank you very much", "https://image.flaticon.com/icons/png/512/149/149071.png"));
        subscribers.add(new Subscriber("Mary Jane", "23 min", "Thank you very much", "https://image.flaticon.com/icons/png/512/149/149071.png"));
        subscribers.add(new Subscriber("Mary Jane", "23 min", "Thank you very much", "https://image.flaticon.com/icons/png/512/149/149071.png"));
        adapter2.setItems(subscribers);
    }





    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnBinder.unbind();
    }

}
