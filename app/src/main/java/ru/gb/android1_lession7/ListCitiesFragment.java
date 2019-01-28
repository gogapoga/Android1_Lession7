package ru.gb.android1_lession7;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ListCitiesFragment extends Fragment implements VisibleCityAdapter.DeleteCities, InvisibleCityAdapter.AddCities {

    private ArrayList<CityWeather> arrayVisibleCity = new ArrayList<CityWeather>();
    private ArrayList<CityWeather> arrayInvisibleCity = new ArrayList<CityWeather>();
    private RecyclerView visible_cities;
    private RecyclerView invisible_cities;
    private VisibleCityAdapter visibleAdapter;
    private InvisibleCityAdapter invisibleAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_cities, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        CityWeather[] arrayCity = ((MyApplication) getActivity().getApplication()).getCities().getAllArrayCity();
        for (int i = 0; i < arrayCity.length; i++) {
            if (arrayCity[i].isVisible()) arrayVisibleCity.add(arrayCity[i]);
            else arrayInvisibleCity.add(arrayCity[i]);
        }
        visible_cities = (RecyclerView) getActivity().findViewById(R.id.visible_cities);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        visible_cities.setLayoutManager(layoutManager);
        visibleAdapter = new VisibleCityAdapter(this, arrayVisibleCity);
        visible_cities.setAdapter(visibleAdapter);
        invisible_cities = (RecyclerView) getActivity().findViewById(R.id.invisible_cities);
        layoutManager = new LinearLayoutManager(getActivity());
        invisible_cities.setLayoutManager(layoutManager);
        invisibleAdapter = new InvisibleCityAdapter(this, arrayInvisibleCity);
        invisible_cities.setAdapter(invisibleAdapter);
    }

    @Override
    public void onDestroyView() {
        visible_cities = null;
        invisible_cities = null;
        super.onDestroyView();
    }

    public void add(int position) {
        CityWeather obj = arrayInvisibleCity.get(position);
        arrayVisibleCity.add(obj);
        arrayInvisibleCity.remove(position);
        obj.setVisible(true);
        invisibleAdapter.notifyDataSetChanged();
        visibleAdapter.notifyDataSetChanged();
    }

    public void delete(int position) {
        CityWeather obj = arrayVisibleCity.get(position);
        arrayInvisibleCity.add(obj);
        arrayVisibleCity.remove(position);
        obj.setVisible(false);
        invisibleAdapter.notifyDataSetChanged();
        visibleAdapter.notifyDataSetChanged();
    }
}
