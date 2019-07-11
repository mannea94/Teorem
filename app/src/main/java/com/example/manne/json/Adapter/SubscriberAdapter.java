package com.example.manne.json.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manne.json.Activities.SearchActivity;
import com.example.manne.json.Models.Subscriber;
import com.example.manne.json.Models.User;
import com.example.manne.json.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by manne on 10.7.2019.
 */

public class SubscriberAdapter extends RecyclerView.Adapter<SubscriberAdapter.ViewHolder> {

    Context context;
    ArrayList<Subscriber> subscribers = new ArrayList<>();

    public SubscriberAdapter(Context context1){
        context=context1;
    }

    public void setItems(ArrayList<Subscriber> subscriber){
        subscribers=subscriber;
    }

    @Override
    public SubscriberAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_subscription, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SubscriberAdapter.ViewHolder holder, int position) {
            Subscriber subscriber = subscribers.get(position);
        Picasso.with(context)
                .load(subscriber.getImgUrl())
                .fit()
                .into(holder.imageView);

            holder.subscriberName.setText(subscriber.name);
    }

    @Override
    public int getItemCount() {
        return subscribers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.imageSubscriber)
        ImageView imageView;
        @BindView(R.id.subscriberName)
        TextView subscriberName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
