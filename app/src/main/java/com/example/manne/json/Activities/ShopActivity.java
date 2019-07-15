package com.example.manne.json.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;

import com.example.manne.json.Adapter.ShopAdapter;
import com.example.manne.json.Models.ShopData;
import com.example.manne.json.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShopActivity extends AppCompatActivity {

    @BindView(R.id.recyclerViewShop)
    RecyclerView recyclerView;
    ShopAdapter adapter;

    String imgUrl="https://image.flaticon.com/icons/png/512/149/149071.png";
    String imgUrl1="https://th-test-11.slatic.net/original/79e799f8d06f65b7b53a79dd4101b05c.jpg_340x340q80.jpg_.webp";
    String imgUrl2="https://th-test-11.slatic.net/original/79e799f8d06f65b7b53a79dd4101b05c.jpg_340x340q80.jpg_.webp";
    String imgUrl3="http://auction.graceland.com/ItemImages/000000/736_med.jpeg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_shop);

        ButterKnife.bind(this);
        adapter=new ShopAdapter(this);

        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        getList();

    }

    public void getList(){
        ArrayList<ShopData> shopData = new ArrayList<>();
        shopData.add(new ShopData(imgUrl, "Charlotte Henry", "3h ago", imgUrl1, imgUrl2, imgUrl3));
        shopData.add(new ShopData(imgUrl, "Charlotte Henry", "3h ago", imgUrl1, imgUrl2, imgUrl3));
        shopData.add(new ShopData(imgUrl, "Charlotte Henry", "3h ago", imgUrl1, imgUrl2, imgUrl3));
        shopData.add(new ShopData(imgUrl, "Charlotte Henry", "3h ago", imgUrl1, imgUrl2, imgUrl3));
        shopData.add(new ShopData(imgUrl, "Charlotte Henry", "3h ago", imgUrl1, imgUrl2, imgUrl3));

        adapter.setItems(shopData);
    }
}
