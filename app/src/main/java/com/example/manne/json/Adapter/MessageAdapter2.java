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

public class MessageAdapter2 extends RecyclerView.Adapter<MessageAdapter2.ViewHolder> {

    Context context;
    ArrayList<Subscriber> subscribers = new ArrayList<>();

    public MessageAdapter2(Context context1){
        context=context1;
    }

    public void setItems(ArrayList<Subscriber> subscriber){
        subscribers=subscriber;
    }

    @Override
    public MessageAdapter2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_messages_ver, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MessageAdapter2.ViewHolder holder, int position) {
            Subscriber subscriber = subscribers.get(position);
        Picasso.with(context)
                .load(subscriber.getImgUrl())
                .fit()
                .into(holder.imageView);

        holder.name.setText(subscriber.name);
        holder.time.setText(subscriber.time);
        holder.message.setText(subscriber.message);


    }

    @Override
    public int getItemCount() {
        return subscribers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.imageSubscriber)
        ImageView imageView;
        @BindView(R.id.subscriberName)
        TextView name;
        @BindView(R.id.subscriberTime)
        TextView time;
        @BindView(R.id.subscriberMessage)
        TextView message;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
