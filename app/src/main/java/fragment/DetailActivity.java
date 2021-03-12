package fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.dang.sunshine.R;

import model.Weather;

public class DetailActivity extends AppCompatActivity {
    private final String TAG_DETAIL ="fragmentDetail";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        addFragment();
    }

    public void addFragment() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        Weather weather = (Weather) bundle.getSerializable("weather");
        DetailFragment detailFragment = DetailFragment.newInstance(weather,false);
        getSupportFragmentManager().beginTransaction().add(R.id.frmDetail_container,detailFragment,TAG_DETAIL).commit();

    }
}