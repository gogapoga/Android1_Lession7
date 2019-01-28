package ru.gb.android1_lession7;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class CityWeatherFragment extends Fragment {

    private RecyclerView timeweather;
    private String[] text;
    private int[] icons;

    public static CityWeatherFragment newInstance(int citySelected) {
        CityWeatherFragment cityWeatherFragment = new CityWeatherFragment();
        Bundle args = new Bundle();
        args.putInt(ParamShow.CityWeather.toString(), citySelected);
        cityWeatherFragment.setArguments(args);
        return cityWeatherFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_city_weather, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        CityWeather city = ((MyApplication) getActivity().getApplication()).getCities().getArrayVisibleCity()[getArguments().getInt(ParamShow.CityWeather.toString())];
        city.loadWeather();
        text = new String[24];
        icons = new int[24];
        for (int i = 0; i < 24; i++) {
            StringBuilder str = new StringBuilder(getString(R.string.wordTime));
            str.append(i);
            str.append(":00\n");
            str.append(getString(R.string.wordTemperature));
            int t = city.getTemp(i);
            if (t > 0) str.append("+");
            str.append(t);
            str.append(getString(R.string.wordC));
            t = city.getHumidity(i);
            if (((MyApplication) getActivity().getApplication()).isShowHumidity()) {
                str.append("\n");
                str.append(getString(R.string.wordHumidity));
                str.append(": ");
                str.append(t);
                str.append("%");
            }
            if (((MyApplication) getActivity().getApplication()).isShowWind()) {
                str.append("\n");
                str.append(getString(R.string.wordWind));
                str.append(": ");
                str.append(city.getWind(i));
                str.append(getString(R.string.wordMC));
            }
            if (((MyApplication) getActivity().getApplication()).isShowPressure()) {
                str.append("\n");
                str.append(getString(R.string.wordPressure));
                str.append(": ");
                str.append(city.getPressure(i));
                str.append(getString(R.string.wordMMPTST));
            }
            text[i] = str.toString();
            if (t < 40) icons[i] = 0;
            else if (t > 80) icons[i] = 2;
            else icons[i] = 1;
        }
        timeweather = (RecyclerView) getActivity().findViewById(R.id.timeweather);
        timeweather.setBackgroundResource(((MyApplication) getActivity().getApplication()).getStyle().getBackground());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        timeweather.setLayoutManager(layoutManager);
        WeatherAdapter adapter = new WeatherAdapter(getResources(), text, icons);
        timeweather.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        timeweather = null;
        text = null;
        icons = null;
        super.onDestroyView();
    }
}
