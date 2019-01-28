package ru.gb.android1_lession7;

public class CityWeather {

    private String name;
    private boolean visible;
    private int[] temp;
    private int[] humidity;
    private int[] pressure;
    private int[] wind;

    public CityWeather(String name) {
        this.name = name;
        visible = true;
    }

    public CityWeather(String name, boolean visible) {
        this.name = name;
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void loadWeather() {  // загрузка погоды для города, пока случайным образом
        temp = new int[24];
        humidity = new int[24];
        pressure = new int[24];
        wind = new int[24];
        for (int i = 0; i < 24; i++) {
            temp[i] = (int) (Math.random() * 10) - 5;
            humidity[i] = (int) (Math.random() * 80) + 20;
            pressure[i] = (int) (Math.random() * 50) + 725;
            wind[i] = (int) (Math.random() * 25) + 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getWind(int time) {
        return wind[time];
    }

    public int getHumidity(int time) {
        return humidity[time];
    }

    public int getPressure(int time) {
        return pressure[time];
    }

    public int getTemp(int time) {
        return temp[time];
    }
}

