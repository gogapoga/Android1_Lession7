package ru.gb.android1_lession7;


import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {

    private String[] text;
    private int[] icons;
    private Drawable[] img;

    public WeatherAdapter(Resources resources, String[] text, int[] icon) {
        this.text = text;
        this.icons = icon;
        img = new Drawable[3];
        img[0] = resources.getDrawable(R.drawable.sun);
        img[0].setBounds(0, 0, 60, 60);
        img[1] = resources.getDrawable(R.drawable.cloud);
        img[1].setBounds(0, 0, 60, 60);
        img[2] = resources.getDrawable(R.drawable.cloud_r);
        img[2].setBounds(0, 0, 60, 60);
    }

    @Override
    public WeatherAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        Button v = (Button) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_time, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.button.setText(text[position]);
        holder.button.setCompoundDrawables(null, null, img[icons[position]], null);
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
