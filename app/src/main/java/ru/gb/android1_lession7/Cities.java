package ru.gb.android1_lession7;

import java.util.ArrayList;

public class Cities {

    private int selectedLanguage = 0;
    private CityWeather[] ArrayVisibleCity;
    private CityWeather[] ArrayInvisibleCity;
    private CityWeather[] arrayCity = {new CityWeather(selectedLanguage == 0 ? "Москва" : "Moscow"), new CityWeather(selectedLanguage == 0 ? "Воронеж" : "Voronezh"),
            new CityWeather(selectedLanguage == 0 ? "Брянск" : "Bryansk"), new CityWeather(selectedLanguage == 0 ? "Липецк" : "Lipetsk"), new CityWeather(selectedLanguage == 0 ? "Рязань" : "Ryazan"),
            new CityWeather(selectedLanguage == 0 ? "Новосибирск" : "Novosibirsk"), new CityWeather(selectedLanguage == 0 ? "Владивосток" : "Vladivostok"), new CityWeather(selectedLanguage == 0 ? "Хабаровск" : "Khabarovsk"),
            new CityWeather(selectedLanguage == 0 ? "Чита" : "Chita"), new CityWeather(selectedLanguage == 0 ? "Уфа" : "Ufa"), new CityWeather(selectedLanguage == 0 ? "Калуга" : "Kaluga"), new CityWeather(selectedLanguage == 0 ? "Тверь" : "Tver", false),
            new CityWeather(selectedLanguage == 0 ? "Чехов" : "Chekhov", false), new CityWeather(selectedLanguage == 0 ? "Подольск" : "Podolsk", false), new CityWeather(selectedLanguage == 0 ? "Тула" : "Tula", false), new CityWeather(selectedLanguage == 0 ? "Серпухов" : "Serpukhov", false)};

    public Cities(int selectedLanguage) {
        this.selectedLanguage = selectedLanguage;
    }

    public CityWeather[] getArrayVisibleCity() {
        ArrayList<CityWeather> res = new ArrayList<CityWeather>();
        for (CityWeather o : arrayCity) {
            if (o.isVisible()) res.add(o);
        }
        if (res.size() == 0) {
            arrayCity[0].setVisible(true);
            res.add(arrayCity[0]);
        }
        return res.toArray(new CityWeather[res.size()]);
    }

    public CityWeather[] getAllArrayCity() {
        return arrayCity;
    }
}
