package com.example.chad_000.examplecode;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chad_000.examplecode.data.*;

public class WeatherAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Weather weather;

    public WeatherAdapter(Weather weather) {
        this.weather = weather;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.current_card, parent, false);
            return new CurrentViewHolder(v);
        }

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.forecast_card, parent, false);
        return new ForecastViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Channel channel = weather.getQuery().getResults().getChannel();
        Item item = channel.getItem();
        Condition condition = item.getCondition();
        String tempUnit = channel.getUnits().getTemperature();

        if (holder.getItemViewType() == 0) {
            CurrentViewHolder viewHolder = (CurrentViewHolder) holder;
            viewHolder.getTemp().setText(condition.getTemp() + " " + tempUnit);
            viewHolder.getText().setText(condition.getText());
        } else {
            ForecastViewHolder viewHolder = (ForecastViewHolder) holder;

            int index = position - 1;
            Forecast forecast = item.getForecasts().get(index);

            viewHolder.getHigh().setText(forecast.getHigh() + " " + tempUnit);
            viewHolder.getLow().setText(forecast.getLow() + " " + tempUnit);
            viewHolder.getDay().setText(forecast.getDay());
            viewHolder.getText().setText(forecast.getText());
        }
    }

    @Override
    public int getItemCount() {
        return 1 + weather.getQuery().getResults().getChannel().getItem().getForecasts().size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
