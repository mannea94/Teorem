package com.example.manne.json.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.manne.json.Activities.FirstActivity;
import com.example.manne.json.Adapter.ShopAdapter;
import com.example.manne.json.Models.ShopData;
import com.example.manne.json.Models.User;
import com.example.manne.json.R;
import com.example.manne.json.SharedPreferences;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by manne on 08.7.2019.
 */

public class UserFragment extends Fragment{
    public Unbinder mUnBinder;

    @BindView(R.id.recyclerViewShop)
    RecyclerView recyclerView;

    @BindView(R.id.imageSettings)
    ImageView settings;

    @BindView(R.id.spinner2)
    Spinner spinner;

    @BindView(R.id.layoutSettings)
    LinearLayout layoutSettings;

    @BindView(R.id.singOut)
    Button singOut;


    MaterialDialog materialDialog;
    ShopAdapter adapter;

    String imgUrl="https://image.flaticon.com/icons/png/512/149/149071.png";
    String imgUrl1="https://th-test-11.slatic.net/original/79e799f8d06f65b7b53a79dd4101b05c.jpg_340x340q80.jpg_.webp";
    String imgUrl2="https://th-test-11.slatic.net/original/79e799f8d06f65b7b53a79dd4101b05c.jpg_340x340q80.jpg_.webp";
    String imgUrl3="http://auction.graceland.com/ItemImages/000000/736_med.jpeg";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_fragment, null);
        mUnBinder = ButterKnife.bind(this, view);
        layoutSettings.setVisibility(View.GONE);
        adapter = new ShopAdapter(getContext());

        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        getList();

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                layoutSettings.setVisibility(View.VISIBLE);
                List<String> list = new ArrayList<>();
                list.add("English");
                list.add("Deutch");
                list.add("Italian");
                list.add("French");

                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(),
                        android.R.layout.simple_spinner_item, list);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                spinner.setAdapter(dataAdapter);



//                    AlertDialog.Builder builderSingle = new AlertDialog.Builder(getContext());
//                    builderSingle.setTitle("Select language");
//
//                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.select_dialog_singlechoice);
//                    arrayAdapter.add("English");
//                    arrayAdapter.add("Deutsch");
//                    arrayAdapter.add("Italian");
//                    arrayAdapter.add("French");
//
//                    builderSingle.setNegativeButton("No", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                        }
//                    });
//
//                    builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            String strName = arrayAdapter.getItem(which);
//                            AlertDialog.Builder builderInner = new AlertDialog.Builder(getContext());
//                            builderInner.setTitle("Your language is");
//                            builderInner.setMessage(strName);
//                            builderInner.show();
//                        }
//                    });
//
//                    builderSingle.show();
//


                singOut.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder myBuilder = new AlertDialog.Builder(getContext());
                        myBuilder.setMessage("Are you sure that you want to sign out?");
//                        myBuuilder.setTitle("Enter your E-mail");


                        myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                User user = new User();
                                user.setUsername("");
                                SharedPreferences.addUser(user, getActivity());
                                Intent intent = new Intent(getActivity(), FirstActivity.class);
                                startActivity(intent);
                                getActivity().finish();
                            }
                        });
                        myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        myBuilder.create().show();
                    }
                });




        //                materialDialog = new MaterialDialog.Builder(getContext())
//                        .title("Title")
//                        .autoDismiss(false)
//                        .show();
//                materialDialog.setCanceledOnTouchOutside(true);

    }
        });


        return view;
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




    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnBinder.unbind();
    }

}
