package com.example.jiaming.dataretrive;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
public interface APIInterface {
    @GET("1/photos")
    Call<List<Albums>> doGetList();
}
