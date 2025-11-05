package com.example.weatherexam;

public class HourItem {
    public String time;
    public String temperature;
    public String condition;
    public HourItem (
            String time,
            String temperature,
            String condition) {
        this.time = time;
        this.temperature = temperature;
        this.condition = condition;
    }
}
