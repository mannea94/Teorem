package com.example.manne.json.Adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manne.json.Models.Preview;
import com.example.manne.json.Models.ShopData;
import com.example.manne.json.R;
import com.example.manne.json.SharedPreferences;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by manne on 10.7.2019.
 */

public class AdAdapter extends RecyclerView.Adapter<AdAdapter.ViewHolder> {

    Context context;
    ArrayList<Preview> previews = new ArrayList<>();
    Preview previewModel = new Preview();

    public AdAdapter(Context context1)
    {
        context=context1;
//        previewModel=preview_;
    }

    public void setItems(ArrayList<Preview> preview){
        previews=preview;
    }

    @Override
    public AdAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_ad, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AdAdapter.ViewHolder holder, int position) {
            Preview preview = previews.get(position);
            holder.imageAd.setImageBitmap(BitmapFactory.decodeFile(preview.getImgPaths().get(0)));
            holder.nameAd.setText(preview.getName());
            holder.price.setText(preview.getPrice());
            holder.currency.setText(preview.getCurrency());
            holder.description.setText(preview.getDescription());
            holder.heart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences.addPreview(preview, context);
                    holder.heart.setImageResource(R.drawable.like_active3x3);
                    notifyDataSetChanged();
                }
            });


    }

    @Override
    public int getItemCount() {
        return previews.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.imageAd)
        ImageView imageAd;
        @BindView(R.id.nameAd)
        TextView nameAd;
        @BindView(R.id.price)
        TextView price;
        @BindView(R.id.currency)
        TextView currency;
        @BindView(R.id.description)
        TextView description;
        @BindView(R.id.heart)
        ImageView heart;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
