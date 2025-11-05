package com.example.weatherexam;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class HourActivity extends AppCompatActivity {
    public RecyclerView recyclerView;
    public HourAdapter hourAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        recyclerView = findViewById(R.id.recyclerView);
        hourAdapter = new HourAdapter(new ArrayList<>());
        int position = getIntent().getIntExtra("position", 0);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(hourAdapter);

        searchHourWeather(position);
    }

    private void searchHourWeather(int position) {
        WeatherApiService weatherApiService = WeatherApiClient.getApiClient();
        Call<WeatherResponse> call = weatherApiService.getApiService(
                WeatherApiClient.ApiKey,
                "58.00",
                "56.14",
                7
        );
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                List<HourItem> hourItemList = new ArrayList<>();
                for (WeatherResponse.hours hoursitem : response.body().forecasts.get(position).hours) {
                    hourItemList.add(new HourItem(hoursitem.hour + ":00", hoursitem.temp + "°C", hoursitem.condition + ""));
                }
                hourAdapter.UpdateData(hourItemList);
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
            }
        });
    }
}
