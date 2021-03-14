package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dang.sunshine.DetailActivity;
import com.dang.sunshine.R;

import Interface.MyClicklistener;
import adapter.WeatherAdapter;
import model.Weather;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment implements MyClicklistener{
   private WeatherAdapter weatherAdapter;
   private RecyclerView recyclerView;
    public ListFragment() {
        weatherAdapter = new WeatherAdapter(getActivity(),this::onclick);
    }

    public WeatherAdapter getWeatherAdapter() {
        return weatherAdapter;
    }

    public static ListFragment newInstance() {
        ListFragment fragment = new ListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView =view.findViewById(R.id.rcvWeather);
        recyclerView.setAdapter(weatherAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onclick(Weather weather) {
        Intent intent = new Intent(getContext(), DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(DetailActivity.KEY_DATA, weather);
        intent.putExtra(DetailActivity.KEY_BUNDLE, bundle);
        startActivityForResult(intent,1);
    }
}