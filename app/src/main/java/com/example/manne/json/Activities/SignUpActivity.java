package com.example.manne.json.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


import com.example.manne.json.Api.RestApi;
import com.example.manne.json.Models.DataResponse;
import com.example.manne.json.Models.User;
import com.example.manne.json.Models.UserInfo;
import com.example.manne.json.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    @BindView(R.id.first_name)
    EditText first_name;
    @BindView(R.id.last_name)
    EditText last_name;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.city)
    EditText city;
    @BindView(R.id.prefix)
    EditText prefix;
    @BindView(R.id.phone_number)
    EditText phone;
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.confirm_pass)
    EditText confirm_pass;
    @BindView(R.id.signUpButton)
    Button signup;
    @BindView(R.id.iconLogin)
    ImageView iconLogin;
    User user;
    RestApi api;
    DataResponse dataResponse;
    UserInfo userInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
        user = new User();
        userInfo=new UserInfo();
        api=new RestApi(this);

        iconLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(!first_name.getText().toString().isEmpty() && !last_name.getText().toString().isEmpty() && !email.getText().toString().isEmpty() && !city.getText().toString().isEmpty() && !phone.getText().toString().isEmpty() && !username.getText().toString().isEmpty() &&!password.getText().toString().isEmpty()) {
//                }
                   /* user.setFirstName(first_name.getText().toString());
                    user.setLastName(last_name.getText().toString());
                    user.setEmail(email.getText().toString());
                    user.setPhoneNumber(phone.getText().toString());
                    user.setUsername(username.getText().toString());
                    user.setCity(city.getText().toString());
                    user.setPassword(password.getText().toString());
                    user.setDateOfBirth("22222");
                    */

                user.setFirstName("First Name");
                user.setLastName("last");
                user.setEmail("manneea94@outlook.com");
                user.setPhoneNumber("234235");
                user.setUsername("mane");
                user.setCity("Skopje");
                user.setPassword("mane");
                user.setDateOfBirth("22222");


                api.getApiService().postUserRegister(user).enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if (response.isSuccessful()){
                    Log.d("TAG","Successful");
                }else {
                    Log.d("TAG","Error");
                }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                Log.d("TAG","Failure");
            }
        });
             /*       api.getApiService().postUserRegister(user).enqueue(new Callback<DataResponse>() {
                        @Override
                        public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                            if(response.isSuccessful()){
                                Toast.makeText(SignUpActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                                dataResponse=response.body();
                                Toast.makeText(SignUpActivity.this,dataResponse.getMessage(),Toast.LENGTH_SHORT).show();
                                userInfo.setFirstname(dataResponse.getInfo().getFirstname());
                                userInfo.setLastname(dataResponse.getInfo().getLastname());
                                userInfo.setEmail(dataResponse.getInfo().email);
                                userInfo.setCity(dataResponse.getInfo().city);
                                userInfo.setUsername(dataResponse.getInfo().username);
                                userInfo.setPhoneNumber(dataResponse.getInfo().phoneNumber);
                                userInfo.setPassword(dataResponse.getInfo().password);
                                userInfo.setDateOfBirth(dataResponse.getInfo().dateOfBirth);
                            }
                            else{
                             //   Toast.makeText(SignUpActivity.this,dataResponse.getMessage(),Toast.LENGTH_SHORT).show();
                                Toast.makeText(SignUpActivity.this, "Error", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<DataResponse> call, Throwable t) {
                            Toast.makeText(SignUpActivity.this, "failure", Toast.LENGTH_SHORT).show();
                        }
                    });*/


            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
