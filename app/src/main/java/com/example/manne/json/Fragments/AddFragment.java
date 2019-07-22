package com.example.manne.json.Fragments;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.manne.json.Activities.PreviewActivity;
import com.example.manne.json.Adapter.FragmentAdapterImages;
import com.example.manne.json.Models.ImagePath;
import com.example.manne.json.Models.Preview;
import com.example.manne.json.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.app.Activity.RESULT_OK;
import static android.support.v4.content.PermissionChecker.checkSelfPermission;

/**
 * Created by manne on 08.7.2019.
 */

public class AddFragment extends Fragment{
    public Unbinder mUnBinder;
    @BindView(R.id.largeImage)
    ImageView largeImage;
    @BindView(R.id.imageLarge)
    ImageView uploadImage;
    @BindView(R.id.uploadImage)
    TextView uploadText;

    @BindView(R.id.category)
    EditText category;
    @BindView(R.id.nameAd)
    EditText nameAd;
    @BindView(R.id.describePrecision)
    EditText description;
//    @BindView(R.id.addPrice1)
//    EditText price1;
//    @BindView(R.id.addPrice2)
//    EditText price2;
//    @BindView(R.id.addCurrency1)
//    EditText currency1;
//    @BindView(R.id.addCurrency1)
//    EditText currency2;

    @BindView(R.id.switchBarColor)
    Switch barVegan;

    @BindView(R.id.switchBarNew)
    Switch newBar;
    @BindView(R.id.switchBarLikeNew)
    Switch likeNewBar;
    @BindView(R.id.switchBarGoodShape)
    Switch goodShapeBar;
    @BindView(R.id.switchBarGoodCondition)
    Switch goodConditionBar;

    @BindView(R.id.addNote)
    EditText addNote;
    @BindView(R.id.size)
    EditText size;

    @BindView(R.id.switchBarCity)
    Switch cityBar;

    @BindView(R.id.addCity)
    EditText addCity;

    @BindView(R.id.switchBarFixedPrice)
    Switch fixedPriceBar;
    @BindView(R.id.switchBarNegotiable)
    Switch negotiableBar;
    @BindView(R.id.switchBarMakeOffer)
    Switch makeOfferBar;

    @BindView(R.id.addPrice1)
    EditText addPrice1;
    @BindView(R.id.addCurrency1)
    EditText addCurrency1;

    @BindView(R.id.addPrice2)
    EditText addPrice2;
    @BindView(R.id.addCurrency2)
    EditText addCurrency2;

    @BindView(R.id.previewButton)
    Button preview;

    Preview previewModel;

    final static int PERMISSION_REQUEST=0;
    final static int REQUEST_LOAD_IMAGE=1;

    String picturePath="";
    ArrayList<String> imagesPath = new ArrayList<>();
    ArrayList<ImagePath> imagePaths = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_fragment, null);
        mUnBinder = ButterKnife.bind(this, view);
        addCity.setVisibility(View.GONE);
        addPrice1.setVisibility(View.GONE);
        addCurrency1.setVisibility(View.GONE);
        addPrice2.setVisibility(View.GONE);
        addCurrency2.setVisibility(View.GONE);
        previewModel=new Preview();
        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                View view = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                Spinner spinner = (Spinner) view.findViewById(R.id.spinnerCategory);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                        android.R.layout.simple_spinner_item,
                        getResources().getStringArray(R.array.category));
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(!spinner.getSelectedItem().toString().equalsIgnoreCase("Choose category...")){
                            category.setText(spinner.getSelectedItem().toString());
                            dialog.dismiss();
                        }
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        size.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                View view = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                Spinner spinner = (Spinner) view.findViewById(R.id.spinnerCategory);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                        android.R.layout.simple_spinner_item,
                        getResources().getStringArray(R.array.size));
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(!spinner.getSelectedItem().toString().equalsIgnoreCase("Choose size...")){
                            size.setText(spinner.getSelectedItem().toString());
                            dialog.dismiss();
                        }
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        newBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newBar.isChecked()){
                    likeNewBar.setChecked(false);
                    goodShapeBar.setChecked(false);
                    goodConditionBar.setChecked(false);
                }
            }
        });

        likeNewBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(likeNewBar.isChecked()){
                    goodShapeBar.setChecked(false);
                    goodConditionBar.setChecked(false);
                    newBar.setChecked(false);
                }
            }
        });

        goodShapeBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(goodShapeBar.isChecked()){
                    goodConditionBar.setChecked(false);
                    newBar.setChecked(false);
                    likeNewBar.setChecked(false);
                }
            }
        });


        goodConditionBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(goodConditionBar.isChecked()){
                    newBar.setChecked(false);
                    likeNewBar.setChecked(false);
                    goodShapeBar.setChecked(false);
                }
            }
        });




        cityBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cityBar.isChecked()){
                    addCity.setVisibility(View.VISIBLE);
                }
                else{
                    addCity.setVisibility(View.GONE);
                }
            }
        });

        fixedPriceBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(fixedPriceBar.isChecked()){
                    negotiableBar.setChecked(false);
                    makeOfferBar.setChecked(false);
                    addPrice2.setVisibility(View.GONE);
                    addCurrency2.setVisibility(View.GONE);
                    addPrice1.setVisibility(View.VISIBLE);
                    addCurrency1.setVisibility(View.VISIBLE);
                }
                else{
                    addPrice1.setVisibility(View.GONE);
                    addCurrency1.setVisibility(View.GONE);
                }
            }
        });

        negotiableBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(negotiableBar.isChecked()){
                    fixedPriceBar.setChecked(false);
                    addPrice1.setVisibility(View.GONE);
                    addCurrency1.setVisibility(View.GONE);
                    addPrice2.setVisibility(View.VISIBLE);
                    addCurrency2.setVisibility(View.VISIBLE);



                }
                else{
                    addPrice2.setVisibility(View.GONE);
                    addCurrency2.setVisibility(View.GONE);
                }
            }
        });

        makeOfferBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(makeOfferBar.isChecked()){
                    fixedPriceBar.setChecked(false);
                    addPrice1.setVisibility(View.GONE);
                    addCurrency1.setVisibility(View.GONE);
                }

            }
        });

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && getContext().checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST);
        }

        largeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, REQUEST_LOAD_IMAGE);
            }
        });


        preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!nameAd.getText().toString().isEmpty() && !description.getText().toString().isEmpty()){
                    previewModel.setImgPath(picturePath);

                    if(barVegan.isChecked()){
                        previewModel.setVegan("Vegan");
                    }
                    else{
                        previewModel.setVegan("");
                    }
                    previewModel.setName(nameAd.getText().toString());
                    previewModel.setDescription(description.getText().toString());

                    if(fixedPriceBar.isChecked()){
                        previewModel.setPrice(addPrice1.getText().toString());
                        previewModel.setCurrency(addCurrency1.getText().toString());
                    }
                    else if(negotiableBar.isChecked()){
                        previewModel.setPrice(addPrice2.getText().toString());
                        previewModel.setCurrency(addCurrency2.getText().toString());
                    }
                    else{
                        previewModel.setPrice("");
                        previewModel.setCurrency("");
                    }

                    previewModel.setSize(size.getText().toString());
                    Intent intent = new Intent(getContext(), PreviewActivity.class);
                    intent.putExtra("EXTRA_PREVIEW", previewModel);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getContext(), "Please fill your name and description", Toast.LENGTH_SHORT).show();
                }


            }
        });


        return view;
    }




    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case PERMISSION_REQUEST:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getContext(), "Permission granted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getContext(), "Permission not granted", Toast.LENGTH_SHORT).show();
                    getActivity().fileList();
                }


        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case REQUEST_LOAD_IMAGE:
                if(resultCode == RESULT_OK){
                    Uri selected_image = data.getData();
                    String [] filePathColumn = {MediaStore.Images.Media.DATA};
                    Cursor cursor = getActivity().getContentResolver().query(selected_image, filePathColumn, null, null, null);
                    cursor.moveToFirst();
//                    int [] index;
//                    for(int i = 0; i<filePathColumn.length; i++ ){
//                        index = new int[]{cursor.getColumnIndex(filePathColumn[i])};
//
//                    }
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    picturePath = cursor.getString(columnIndex);
                    imagesPath.add(picturePath);
                    previewModel.setImgPaths(imagesPath);
                    cursor.close();
                    largeImage.setImageBitmap(BitmapFactory.decodeFile(picturePath));
                    uploadText.setVisibility(View.GONE);
                }

        }
    }




    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnBinder.unbind();
    }

}
