package com.dang.sunshine;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import adapter.ListDummyData;
import fragment.DetailFragment;
import fragment.ListFragment;
import model.Weather;

public class MainActivity extends AppCompatActivity {

    private final String TAG_DETAIL = "fragmentDetail";
    private final String TAG_LIST = "fragmentList";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragment();
    }

    private void addFragment() {
        ListDummyData list = new ListDummyData();
        Weather weather = list.getWeatherToDay();
        FragmentManager fragmentManager = getSupportFragmentManager();

        DetailFragment detailFragment = DetailFragment.newInstance(weather,true);
        fragmentManager.beginTransaction().add(R.id.fragment_detail, detailFragment, TAG_DETAIL).commit();

        ListFragment listFragment = ListFragment.newInstance();
        fragmentManager.beginTransaction().add(R.id.frament_list,listFragment,TAG_LIST).commit();




    }
}