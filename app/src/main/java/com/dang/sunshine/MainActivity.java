package com.dang.sunshine;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import java.util.Objects;

import adapter.ListDummyData;
import fragment.DetailFragment;
import fragment.ListFragment;
import model.Weather;

public class MainActivity extends AppCompatActivity{

    private final String TAG_DETAIL = "fragmentDetail";
    private final String TAG_LIST = "fragmentList";
    private final int REQUEST_BACK = 113;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar();
        addFragment();
    }

    private void actionBar() {
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

    }

    private void addFragment() {
        ListDummyData list = new ListDummyData();
        Weather weather = list.getWeatherToDay();
        FragmentManager fragmentManager = getSupportFragmentManager();

        DetailFragment detailFragment = DetailFragment.newInstance(weather, true);
        fragmentManager.beginTransaction().add(R.id.fragment_detail, detailFragment, TAG_DETAIL).commit();

        ListFragment listFragment = ListFragment.newInstance();
        fragmentManager.beginTransaction().add(R.id.frament_list, listFragment, TAG_LIST).commit();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       if (requestCode==1){
           if (resultCode == RESULT_OK) {

           }
       }
    }

}