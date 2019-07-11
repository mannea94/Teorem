package com.example.manne.json.Api;

import com.example.manne.json.Models.DataResponse;
import com.example.manne.json.Models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by manne on 04.7.2019.
 */

public interface ApiService {
    @POST("api/v1/login")
    Call<DataResponse> postUserInfo( @Body User user);
    @POST("api/v1/user")
    Call<DataResponse> postUserRegister (@Body User user);

//    @POST("api/v1/user/fb")
//    Call<DataResponse>  postFacebookLogin (@Body User user);


}
