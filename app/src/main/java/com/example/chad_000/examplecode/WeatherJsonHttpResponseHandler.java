package com.example.chad_000.examplecode;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class WeatherJsonHttpResponseHandler extends JsonHttpResponseHandler {

    public WeatherJsonHttpResponseHandler() {
        super();
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {
        try {
            // Pull out the first event on the public timeline
            JSONObject firstEvent = timeline.optJSONObject(0);
            String tweetText = firstEvent.getString("text");

            // Do something with the response
            System.out.println(tweetText);
        } catch(JSONException e) {

        }
    }
}
