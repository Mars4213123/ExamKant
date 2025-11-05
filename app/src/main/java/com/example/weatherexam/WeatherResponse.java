package com.example.weatherexam;

import java.util.List;

public class WeatherResponse {
    public List<forecasts> forecasts;
    public static class forecasts {
        public parts parts;
        public List<hours> hours;
    }
    public static class hours {
        public int hour;
        public String temp;
        public String condition;
    }
    public static class parts {
        public day day;
    }
    public static class day {
        public String temp_avg;
        public String condition;
    }
}
