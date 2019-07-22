package com.example.manne.json.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manne.json.Models.Subscriber;
import com.example.manne.json.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by manne on 10.7.2019.
 */

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    Context context;
    ArrayList<Subscriber> subscribers = new ArrayList<>();

    public NotificationAdapter(Context context1){
        context=context1;
    }

    public void setItems(ArrayList<Subscriber> subscriber){
        subscribers=subscriber;
    }

    @Override
    public NotificationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_notification, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NotificationAdapter.ViewHolder holder, int position) {
            Subscriber subscriber = subscribers.get(position);
        Picasso.with(context)
                .load(subscriber.getImgUrl())
                .fit()
                .into(holder.imageSubscriber);
        Picasso.with(context)
                .load(R.drawable.online_indicator)
                .into(holder.onlineIndicator);
        holder.subscriberName.setText(subscriber.name);
        holder.subscriberCom.setText(subscriber.message);
        holder.subscriberTime.setText(subscriber.time);
        if(position==1 || position ==2 || position==3 || position==5 || position==6 || position==7){
            holder.follow.setVisibility(View.GONE);
        }


    }

    @Override
    public int getItemCount() {
        return subscribers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.imageSubscriber)
        ImageView imageSubscriber;
        @BindView(R.id.onlineIndicator)
        ImageView onlineIndicator;
        @BindView(R.id.subscriberName)
        TextView subscriberName;
        @BindView(R.id.subscriberCom)
        TextView subscriberCom;
        @BindView(R.id.subscriberTime)
        TextView subscriberTime;
        @BindView(R.id.follow)
        TextView follow;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
