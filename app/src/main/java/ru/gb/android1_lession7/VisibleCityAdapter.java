package ru.gb.android1_lession7;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

public class VisibleCityAdapter extends RecyclerView.Adapter<VisibleCityAdapter.ViewHolder> {

    private ArrayList<CityWeather> arrayList;
    private DeleteCities deleteCities;

    public VisibleCityAdapter(DeleteCities deleteCities, ArrayList<CityWeather> arrayList) {
        this.arrayList = arrayList;
        this.deleteCities = deleteCities;
    }

    @Override
    public VisibleCityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        Button v = (Button) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_city, parent, false);

        VisibleCityAdapter.ViewHolder vh = new VisibleCityAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(VisibleCityAdapter.ViewHolder holder, final int position) {
        holder.button.setText(arrayList.get(position).getName());
        holder.button.setTag(position);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteCities.delete(position);
            }

        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    interface DeleteCities {
        public void delete(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public Button button;

        public ViewHolder(Button v) {
            super(v);
            button = v;
        }
    }
}

