package com.example.manne.json.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.manne.json.Api.RestApi;
import com.example.manne.json.Models.DataResponse;
import com.example.manne.json.Models.User;
import com.example.manne.json.Models.UserInfo;
import com.example.manne.json.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    User user;
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.loginButton)
    Button login;
    @BindView(R.id.forgotPass)
    TextView forgotPass;
    @BindView(R.id.iconLogin)
    ImageView iconLogin;
    RestApi api;
    MaterialDialog mDialog;
    UserInfo userInfo;
    DataResponse dataResponse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    api=new RestApi(this);
    user=new User();
    userInfo=new UserInfo();


        iconLogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onBackPressed();
        }
    });



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!username.getText().toString().isEmpty() && !password.getText().toString().isEmpty()) {
                    user.setUsername(username.getText().toString());
                    user.setPassword(password.getText().toString());

                    api.getApiService().postUserInfo(user).enqueue(new Callback<DataResponse>() {
                    @Override
                    public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                        if(response.isSuccessful()){
                            dataResponse=response.body();
                            userInfo.setFirstname(dataResponse.getInfo().getFirstname());
                            userInfo.setFirstname(dataResponse.getInfo().getLastName());
                            userInfo.setEmail(dataResponse.getInfo().getEmail());
                            userInfo.setId(dataResponse.getInfo().getId());
                            Intent intent = new Intent(MainActivity.this, ValidationActivity.class);
                            startActivity(intent);

                            Log.e("TAG","successful");

                        }
                        else{
                            try {
                                JSONObject object = null;
                                try {
                                    object = new JSONObject(response.errorBody().string());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                String  message = object.getString("message");
                                mDialog = new MaterialDialog.Builder(MainActivity.this)
                                        .title(message)
                                        .autoDismiss(false)
                                        .show();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }



        Log.e("TAG","error");
                }

                    @Override
                    public void onFailure(Call<DataResponse> call, Throwable t) {


//                        if(username.getText().toString().equals(dataResponse.getInfo().getUsername())){
//                            mDialog = new MaterialDialog.Builder(MainActivity.this)
//                                    .title("User not found")
//                                    .show();
//                        }
//                        else{
//                            mDialog = new MaterialDialog.Builder(MainActivity.this)
//                                    .title("Wrong password")
//                                    .show();
//                        }
    }
});
                }
                else{
                    Toast.makeText(MainActivity.this, "Please insert username and password", Toast.LENGTH_SHORT).show();
                }
            }

        });

        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog = new MaterialDialog.Builder(MainActivity.this)
                        .title("Title")
                        .content("Email")
                        .inputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS)
                        .inputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS)
                        .input(R.string.email, 0, (dialog, input) -> {
                          /*  if (!Patterns.EMAIL_ADDRESS.matcher(input.toString()).matches()) {
                               // DisplayUtil.doErrorToast(MainActivity.this, getString(R.string.valid_email));
                            } else {
                             //   userInfo.setEmail(input.toString());
                              //  dialog.dismiss();
                             //   mPresenter.forgotPassword(mUser);
                            }*/
                        })
                        .positiveText("Reset")
                        .negativeText("cancel")
                        .autoDismiss(false)
                        .show();
                mDialog.setCanceledOnTouchOutside(false);
            }
        });

//        forgotPass.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder myBuuilder = new AlertDialog.Builder(MainActivity.this);
//                myBuuilder.setMessage("An e-mail will be sent with a code resetting your password  ");
//                myBuuilder.setTitle("Enter your E-mail");
//                EditText editDialog = new EditText(MainActivity.this);
//                editDialog.setInputType(InputType.TYPE_NUMBER_VARIATION_PASSWORD);
//                myBuuilder.setView();
//                myBuuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//                myBuuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });
//                myBuuilder.create().show();
//            }
//        });



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}


