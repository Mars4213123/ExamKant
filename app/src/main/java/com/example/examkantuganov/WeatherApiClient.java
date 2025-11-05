package com.example.examkantuganov;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherApiClient {
    public static final String ApiKey = "f47f568c-15c1-49e5-8bfa-a02267ae7b11";
    public static WeatherApiService getApiClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.weather.yandex.ru/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(WeatherApiService.class);
    }
}
