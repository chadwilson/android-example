package com.example.chad_000.examplecode;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chad_000.examplecode.data.Weather;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loopj.android.http.*;

import cz.msebera.android.httpclient.Header;


public class MainActivityFragment extends Fragment {
    private static final String URL = "https://query.yahooapis.com/v1/public/yql" +
            "?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22nome%2C%20ak%22)"
            + "&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";

    private ObjectMapper mapper;
    private RestClient restClient = new RestClient();
    private AsyncHttpClient client = new AsyncHttpClient();
    private Weather weather = null;

    public MainActivityFragment() {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        client.get(URL, null, getResponseHandler());

        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        WeatherAdapter adapter = new WeatherAdapter(weather);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    public AsyncHttpResponseHandler getResponseHandler() {
        return new BaseJsonHttpResponseHandler<Weather>() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, String rawJsonResponse, Weather response) {
                Log.d("onSuccess", "JSON received from server is: " + rawJsonResponse);

                weather = response;
                setupRecyclerView();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, String rawJsonData, Weather errorResponse) {
                throw new RuntimeException("Cannot load data from Yahoo Weather");
            }

            @Override
            protected Weather parseResponse(String rawJsonData, boolean isFailure) throws Throwable {
                Log.d("parseResponse", "JSON received from server is: " + rawJsonData);
                Log.d("parseResponse", "Request URI was: " + getRequestURI());

                return mapper.readValues(new JsonFactory().createParser(rawJsonData), Weather.class).next();
            }

        };
    }
}
