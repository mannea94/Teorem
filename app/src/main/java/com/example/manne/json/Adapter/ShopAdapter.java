package com.example.manne.json.Adapter;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manne.json.Models.ShopData;
import com.example.manne.json.Models.Subscriber;
import com.example.manne.json.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by manne on 10.7.2019.
 */

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {

    Context context;
    ArrayList<ShopData> shopData = new ArrayList<>();

    public ShopAdapter(Context context1){
        context=context1;
    }

    public void setItems(ArrayList<ShopData> subscriber){
        shopData=subscriber;
    }

    @Override
    public ShopAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_shop, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ShopAdapter.ViewHolder holder, int position) {
            ShopData shopDatas = shopData.get(position);
            Picasso.with(context)
                    .load(shopDatas.getImgUrl())
                    .into(holder.userImage);
            holder.name.setText(shopDatas.getName());
            holder.time.setText(shopDatas.getTime());
        Picasso.with(context)
                .load(shopDatas.getImgUrl1())
                .into(holder.image1);
        Picasso.with(context)
                .load(shopDatas.getImgUrl2())
                .into(holder.image2);
        Picasso.with(context)
                .load(shopDatas.getImgUrl3())
                .into(holder.image3);

    }

    @Override
    public int getItemCount() {
        return shopData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.userName)
        ImageView userImage;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.time)
        TextView time;
        @BindView(R.id.image1)
        ImageView image1;
        @BindView(R.id.image2)
        ImageView image2;

        @BindView(R.id.image3)
        ImageView image3;



        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
