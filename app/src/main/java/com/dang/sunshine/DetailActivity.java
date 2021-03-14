package com.dang.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import fragment.DetailFragment;
import model.Weather;

public class DetailActivity extends AppCompatActivity {
    private static final String TAG_DETAIL ="fragmentDetail";
    public static final String KEY_BUNDLE ="bundle";
    public static final String KEY_DATA ="weather";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        addFragment();
    }

    public void addFragment() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(KEY_BUNDLE);
        Weather weather = (Weather) bundle.getSerializable(KEY_DATA);
        DetailFragment detailFragment = DetailFragment.newInstance(weather,false);
        getSupportFragmentManager().beginTransaction().add(R.id.frmDetail_container,detailFragment,TAG_DETAIL).commit();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(DetailActivity.this,MainActivity.class);
        setResult(RESULT_OK,intent);
        startActivityForResult(intent,1);
    }
}