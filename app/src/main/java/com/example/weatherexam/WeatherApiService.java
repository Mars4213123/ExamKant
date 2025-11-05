package com.example.weatherexam;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface WeatherApiService {
    @GET("v2/forecast")
    Call<WeatherResponse> getApiService(
            @Header("X-Yandex-Weather-Key") String ApiKey,
            @Query("lat") String lat,
            @Query("lon") String lon,
            @Query("limit") int limit
    );
}
