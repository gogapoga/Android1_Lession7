package ru.gb.android1_lession7;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class CitiesFragment extends Fragment {

    private RecyclerView cities;
    private CheckBox par;
    private CityWeather[] arrayCity;
    private OnCityListener cityListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        cityListener = (OnCityListener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        cityListener = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cities, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //установка параметров checkBox-ов
        par = (CheckBox) getActivity().findViewById(R.id.checkWind);
        par.setChecked(((MyApplication) getActivity().getApplication()).isShowWind());
        par.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ((MyApplication) getActivity().getApplication()).setShowWind(((CheckBox) getActivity().findViewById(R.id.checkWind)).isChecked());
                cityListener.changeCheckBox();
            }
        });
        par = (CheckBox) getActivity().findViewById(R.id.checkHumidity);
        par.setChecked(((MyApplication) getActivity().getApplication()).isShowHumidity());
        par.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ((MyApplication) getActivity().getApplication()).setShowHumidity(((CheckBox) getActivity().findViewById(R.id.checkHumidity)).isChecked());
                cityListener.changeCheckBox();
            }
        });
        par = (CheckBox) getActivity().findViewById(R.id.checkPressure);
        par.setChecked(((MyApplication) getActivity().getApplication()).isShowPressure());
        par.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ((MyApplication) getActivity().getApplication()).setShowPressure(((CheckBox) getActivity().findViewById(R.id.checkPressure)).isChecked());
                cityListener.changeCheckBox();
            }
        });
        //
        arrayCity = ((MyApplication) getActivity().getApplication()).getCities().getArrayVisibleCity();
        String[] text = new String[arrayCity.length];
        for (int i = 0; i < arrayCity.length; i++) {
            text[i] = arrayCity[i].getName();
        }
        cities = (RecyclerView) getActivity().findViewById(R.id.cities);
        cities.setBackgroundResource(((MyApplication) getActivity().getApplication()).getStyle().getBackground());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        cities.setLayoutManager(layoutManager);
        CityAdapter adapter = new CityAdapter(cityListener, text);
        cities.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        par = null;
        cities = null;
        arrayCity = null;
        super.onDestroyView();
    }

    public interface OnCityListener {
        public void selectedCity(int index);
        public void changeCheckBox();
    }
}
