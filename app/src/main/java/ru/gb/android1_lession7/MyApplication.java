package ru.gb.android1_lession7;

import android.app.Application;

import java.util.Locale;

public class MyApplication extends Application { //класс для сохранения ключевых параметров при переходе из активити в активити
    private boolean showWind = true;
    private boolean showHumidity = true;
    private boolean showPressure = true;
    private int selectedCity = 0;
    private int selectedLanguage = 0;
    private int selectedStyle = 0;
    private Style style = new Day();
    private boolean settingListCities = false;

    public Cities getCities() {
        return cities;
    }

    public void setCities(Cities cities) {
        this.cities = cities;
    }

    private Cities cities;

    public boolean isSettingListCities() {
        return settingListCities;
    }

    public void setSettingListCities(boolean settingListCities) {
        this.settingListCities = settingListCities;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        String str = Locale.getDefault().getLanguage();
        if (Locale.getDefault().getLanguage().equals("en")) {
            selectedLanguage = 1;
        }
        if ((Locale.getDefault().getLanguage().equals("ru"))) {
            selectedLanguage = 0;
        }
        cities = new Cities(selectedLanguage);
    }

    public int getSelectedCity() {
        return selectedCity;
    }

    public void setSelectedCity(int selectedCity) {
        this.selectedCity = selectedCity;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public int getSelectedStyle() {
        return selectedStyle;
    }

    public void setSelectedStyle(int selectedStyle) {
        this.selectedStyle = selectedStyle;
    }

    public int getSelectedLanguage() {
        return selectedLanguage;
    }

    public void setSelectedLanguage(int selectedLanguage) {
        this.selectedLanguage = selectedLanguage;
    }

    public boolean isShowHumidity() {
        return showHumidity;
    }

    public void setShowHumidity(boolean showHumidity) {
        this.showHumidity = showHumidity;
    }

    public boolean isShowPressure() {
        return showPressure;
    }

    public void setShowPressure(boolean showPressure) {
        this.showPressure = showPressure;
    }

    public Boolean isShowWind() {
        return showWind;
    }

    public void setShowWind(boolean showWind) {
        this.showWind = showWind;
    }
}
