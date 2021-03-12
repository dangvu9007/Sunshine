package adapter;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dang.sunshine.R;

import java.util.List;

import bussiness.DateTimeParse;
import fragment.DetailActivity;
import model.Weather;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {

    private List<Weather> list;
    private ListDummyData listDummyData;
    private Context context;

    public WeatherAdapter(Context context) {
        this.context= context;
        listDummyData = new ListDummyData();
        list = listDummyData.list7Day();
    }

    @NonNull
    @Override
    public WeatherAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherAdapter.ViewHolder holder, int position) {
        Weather weather = list.get(position);
        setDataToView(weather, holder, position);
    }

    private void setDataToView(Weather weather, ViewHolder holder, int position) {
        String dayOfWeek = "Tomorow";
        View view = holder.itemView;
        if (position != 0) {
            dayOfWeek = DateTimeParse.dayOfWeek(weather.getDate());
        }
        holder.img_ic_weather.setImageResource(weather.getThumbnailId());
        holder.tvDayOfWeek.setText(dayOfWeek);
        holder.tvTempHigh_Lv.setText(String.valueOf(weather.getTempHight()) + "\u00B0");
        holder.tvTempLow_Lv.setText(String.valueOf(weather.getTempLow()) + "\u00B0");
        holder.tvState_Lv.setText(weather.getState());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                Bundle bundle= new Bundle();
                bundle.putSerializable("weather",weather);
                intent.putExtra("bundle",bundle);
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View itemView;
        public TextView tvDayOfWeek, tvState_Lv, tvTempHigh_Lv, tvTempLow_Lv;
        public ImageView img_ic_weather;

        public View getItemView() {
            return itemView;
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            tvDayOfWeek = itemView.findViewById(R.id.tvDayOfWeek);
            tvState_Lv = itemView.findViewById(R.id.tvState_Lv);
            tvTempLow_Lv = itemView.findViewById(R.id.tvTempLow_Lv);
            tvTempHigh_Lv = itemView.findViewById(R.id.tvTempHight_Lv);
            img_ic_weather = itemView.findViewById(R.id.img_ic_weather);
        }

        public void setItemView(View itemView) {
            this.itemView = itemView;
        }

    }
}
