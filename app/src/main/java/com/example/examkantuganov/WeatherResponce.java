package com.example.examkantuganov;

import java.util.List;

public class WeatherResponce {
    public List<Forecasts> Forecasts;
    public class Forecasts {
        public Parts Parts;
        public Hours Hours;
    }
    public class Hours {
        public int Hour;
        public String temp;
        public String condition;
    }
    public class Parts {
        public Day Day;
    }
    public class Day {
        public String temp_avg;
        public String condition;
    }
}
