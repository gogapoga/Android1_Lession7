package ru.gb.android1_lession7;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

public class InvisibleCityAdapter extends RecyclerView.Adapter<InvisibleCityAdapter.ViewHolder>{
    private ArrayList<CityWeather> arrayList;
    private AddCities addCities;

    public InvisibleCityAdapter(AddCities addCities, ArrayList<CityWeather> arrayList) {
        this.arrayList = arrayList;
        this.addCities = addCities;
    }

    @Override
    public InvisibleCityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        Button v = (Button) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_city, parent, false);

        InvisibleCityAdapter.ViewHolder vh = new InvisibleCityAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(InvisibleCityAdapter.ViewHolder holder, final int position) {
        holder.button.setText(arrayList.get(position).getName());
        holder.button.setTag(position);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCities.add(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    interface AddCities {
        public void add(int position);
    }

        public static class ViewHolder extends RecyclerView.ViewHolder {

        public Button button;

        public ViewHolder(Button v) {
            super(v);
            button = v;
        }
    };
}
