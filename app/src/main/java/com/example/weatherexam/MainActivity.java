package com.example.weatherexam;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public RecyclerView recyclerView;
    public WeatherAdapter weatherAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        weatherAdapter = new WeatherAdapter(new ArrayList<>());

        weatherAdapter.setOnItemClickListener(itemer -> {
            Intent intent = new Intent(MainActivity.this, HourActivity.class);

            int position = weatherAdapter.weatherItemList.indexOf(itemer);
            intent.putExtra("position", position);
            startActivity(intent);
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(weatherAdapter);

        searchWeather();
    }

    private void searchWeather() {
        WeatherApiService weatherApiService = WeatherApiClient.getApiClient();
        Call<WeatherResponse> call = weatherApiService.getApiService(
                WeatherApiClient.ApiKey, "58.00000", "56.14000", 7
        );
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                List<WeatherItem> itemList = new ArrayList<>();
                for (WeatherResponse.forecasts fore : response.body().forecasts) {
                    String temp = fore.parts.day.temp_avg;
                    String condition = fore.parts.day.condition;
                    itemList.add(new WeatherItem(temp, condition));
                }
                weatherAdapter.UpdateData(itemList);
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {

            }
        });
    }
}
