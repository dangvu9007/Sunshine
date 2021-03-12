package fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dang.sunshine.R;

import bussiness.DateTimeParse;
import model.Weather;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_WEATHER = "weather";
    private static final String ARG_MAIN = "isMainActivity";
    private Weather mWeather;
    private boolean mMain;

    public DetailFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(Weather weather,boolean isMainActivity) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putBoolean(ARG_MAIN,isMainActivity);
        args.putSerializable(ARG_WEATHER, weather);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mWeather = (Weather) getArguments().getSerializable(ARG_WEATHER);
            mMain = getArguments().getBoolean(ARG_MAIN);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapToView(view);
    }

    private void mapToView(View view) {
        TextView tvToDay, tvtemperatureHight, tvtemperatureLow, tvRegion, tvState;
        ImageView imgArt;

        tvToDay = view.findViewById(R.id.tvToDay);
        tvtemperatureHight = view.findViewById(R.id.tvtemperatureHight);
        tvtemperatureLow = view.findViewById(R.id.tvtemperatureLow);
        tvRegion = view.findViewById(R.id.tvRegion);
        tvState = view.findViewById(R.id.tvState);
        imgArt = view.findViewById(R.id.imgArt);

        if (mMain) {
            tvToDay.setText(DateTimeParse.today());
        } else {
            tvToDay.setText(DateTimeParse.date(mWeather.getDate()));
            view.setBackgroundColor(getActivity().getResources().getColor(R.color.white));
            tvtemperatureHight.setTextColor(getActivity().getResources().getColor(R.color.black));
            tvtemperatureLow.setTextColor(getActivity().getResources().getColor(R.color.black));
            tvState.setTextColor(getActivity().getResources().getColor(R.color.black));
            tvToDay.setTextColor(getActivity().getResources().getColor(R.color.black));
            tvRegion.setTextColor(getActivity().getResources().getColor(R.color.black));
        }
        tvtemperatureHight.setText(String.valueOf(mWeather.getTempHight())+"\u00B0");
        tvtemperatureLow.setText(String.valueOf(mWeather.getTempLow())+"\u00B0");
        tvState.setText(mWeather.getState());
        tvRegion.setText(mWeather.getRegion());
        imgArt.setImageResource(mWeather.getThumbnailArtId());

    }

}