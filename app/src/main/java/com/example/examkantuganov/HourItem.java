package com.example.examkantuganov;

public class HourItem {
    public int time;
    public String temperature;
    public String condition;
    public HourItem (
            int time,
            String temperature,
            String condition) {
        this.time = time;
        this.temperature = temperature;
        this.condition = condition;
    }
}
