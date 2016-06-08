package com.example.chad_000.examplecode;


import android.view.View;
import android.widget.TextView;

public class ForecastViewHolder extends ViewHolder {
    private TextView day;
    private TextView text;
    private TextView high;
    private TextView low;


    public ForecastViewHolder(View v) {
        super(v);
        this.text = (TextView) v.findViewById(R.id.text);
        this.day = (TextView) v.findViewById(R.id.day);
        this.high = (TextView) v.findViewById(R.id.high);
        this.low = (TextView) v.findViewById(R.id.low);
    }

    public TextView getDay() {
        return day;
    }

    public TextView getText() {
        return text;
    }

    public TextView getHigh() {
        return high;
    }

    public TextView getLow() {
        return low;
    }
}
