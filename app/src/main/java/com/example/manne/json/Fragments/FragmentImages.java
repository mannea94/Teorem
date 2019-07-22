package com.example.manne.json.Fragments;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manne.json.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by manne on 22.12.2017.
 */

public class FragmentImages extends Fragment {
    public Unbinder unbinder;
    @BindView(R.id.imageFragment)
    ImageView imageFragment;


    public static FragmentImages newInstance(String imageUrl){
        Bundle args = new Bundle();
        args.putString("imageUrl", imageUrl);
        FragmentImages fragment = new FragmentImages();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_images, null);
        unbinder= ButterKnife.bind(this, view);

            if (getArguments() != null && getArguments().getString("imageUrl") != null) {
                imageFragment.setImageBitmap(BitmapFactory.decodeFile(getArguments().getString("imageUrl")));
//                Picasso.with(getActivity())
//                        .load(getArguments().getString("imageUrl"))
//                        .centerInside()
//                        .fit()
//                        .into(imageFragment);
            }
            else{
                imageFragment.setImageBitmap(BitmapFactory.decodeFile(""));
            }

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
