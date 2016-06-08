package com.example.chad_000.examplecode;

import android.view.View;
import android.widget.TextView;

public class CurrentViewHolder extends ViewHolder {
    private TextView temp;
    private TextView text;

    public CurrentViewHolder(View v) {
        super(v);
        this.text = (TextView) v.findViewById(R.id.text);
        this.temp = (TextView) v.findViewById(R.id.temp);
    }

    public TextView getTemp() {
        return temp;
    }

    public TextView getText() {
        return text;
    }
}
