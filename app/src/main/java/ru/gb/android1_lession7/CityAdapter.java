package ru.gb.android1_lession7;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {

    private String[] text;
    CitiesFragment.OnCityListener cityListener;

    public CityAdapter(CitiesFragment.OnCityListener cityListener, String[] text) {
        this.cityListener = cityListener;
        this.text = text;
    }

    @Override
    public CityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        Button v = (Button) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_city, parent, false);

        CityAdapter.ViewHolder vh = new CityAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(CityAdapter.ViewHolder holder, final int position) {
        holder.button.setText(text[position]);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cityListener.selectedCity(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return text.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public Button button;

        public ViewHolder(Button v) {
            super(v);
            button = v;
        }
    }
}
