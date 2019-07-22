package com.example.manne.json.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.manne.json.Adapter.FragmentAdapterImages;
import com.example.manne.json.Models.Preview;
import com.example.manne.json.R;
import com.example.manne.json.SharedPreferences;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PreviewActivity extends AppCompatActivity {

//    @BindView(R.id.imageArticle)
//    ImageView imageArticle;
    @BindView(R.id.textVegan)
    TextView textVegan;
    @BindView(R.id.textName)
    TextView textName;
    @BindView(R.id.textDescription)
    TextView textDescription;
    @BindView(R.id.textPrice)
    TextView textPrice;
    @BindView(R.id.textCurrency)
    TextView textCurrency;
    @BindView(R.id.textSize)
    TextView textSize;
    @BindView(R.id.buttonSave)
    Button saveButton;

    @BindView(R.id.SliderDots)
    LinearLayout sliderDotspanel;

    private int dotscount;
    private ImageView[] dots;

    FragmentAdapterImages adapterImages;

    @BindView(R.id.pagerImages)
    ViewPager pager;

    Preview preview;

    String customImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_preview);
        ButterKnife.bind(this);

        setUpViewPager(pager);
        getDots();
        Intent intent = getIntent();
        if(intent.hasExtra("EXTRA_PREVIEW")){
            preview = (Preview) intent.getSerializableExtra("EXTRA_PREVIEW");
            for(int i=0; i<preview.getImgPaths().size(); i++){
                customImg=preview.imgPaths.get(i);
            }
//            imageArticle.setImageBitmap(BitmapFactory.decodeFile(customImg));
//            imageArticle.setImageBitmap(BitmapFactory.decodeFile(preview.getImgPath()));
//            Picasso.with(this).load(preview.getImgPath()).into(imageArticle);
            textVegan.setText(preview.getVegan());
            textName.setText(preview.getName());
            textDescription.setText(preview.getDescription());
            textPrice.setText(preview.getPrice());
            textCurrency.setText(preview.getCurrency());
            textSize.setText(preview.getSize());
        }

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(PreviewActivity.this);
                builder.setMessage("The announcement is likely to be controlled by our moderation service. In case of problems, we will contact you directly by message. Thank you for your understanding.");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        preview = (Preview) intent.getSerializableExtra("EXTRA_PREVIEW");
                        SharedPreferences.addPreview(preview, PreviewActivity.this);
                        dialog.dismiss();
                        finish();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }

    public void setUpViewPager(ViewPager viewPager){
        FragmentAdapterImages adapterImages = new FragmentAdapterImages(this.getSupportFragmentManager(), getList());
        dotscount = adapterImages.getCount();
        if(dotscount==0){
            Toast.makeText(this, "Please insert a photo", Toast.LENGTH_SHORT).show();
        }
        pager.setAdapter(adapterImages);
    }

    ArrayList<String> getList(){
        Intent intent = getIntent();
        if(intent.hasExtra("EXTRA_PREVIEW")){
            preview = (Preview) intent.getSerializableExtra("EXTRA_PREVIEW");
        }
        return preview.imgPaths;
    }

   public void getDots(){
//       dotscount = adapterImages.getCount();

       dots = new ImageView[dotscount];

       for(int i = 0; i < dotscount; i++){

           dots[i] = new ImageView(this);
           dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));

           LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

           params.setMargins(8, 0, 8, 0);

           sliderDotspanel.addView(dots[i], params);

       }

       dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

       pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

           }

           @Override
           public void onPageSelected(int position) {
               for(int i = 0; i< dotscount; i++){
                   dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
               }

               dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

           }

           @Override
           public void onPageScrollStateChanged(int state) {

           }
       });
   }

}
