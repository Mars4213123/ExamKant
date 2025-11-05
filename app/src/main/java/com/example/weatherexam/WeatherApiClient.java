package com.example.weatherexam;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherApiClient {
    public static final String ApiKey = "demo_yandex_weather_api_key_ca6d09349ba0";
    public static WeatherApiService getApiClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.weather.yandex.ru/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(WeatherApiService.class);
    }
}
