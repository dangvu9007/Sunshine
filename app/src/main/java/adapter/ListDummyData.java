package adapter;

import java.util.ArrayList;
import java.util.Date;

import bussiness.DateTimeParse;
import model.Weather;

public class ListDummyData {
    ArrayList<Weather> listWeather;

    public ListDummyData() {
        listWeather = new ArrayList<Weather>();
        dummyData();
    }

    public void dummyData() {
        Weather model;
        model = new Weather(DateTimeParse.DateParse("07/03/2021"), 24, 20, "Ha Noi", "rain");
        listWeather.add(model);
        model = new Weather(DateTimeParse.DateParse("08/03/2021"), 24, 21, "Ha Noi", "clouds");
        listWeather.add(model);
        model = new Weather(DateTimeParse.DateParse("09/03/2021"), 24, 21, "Ha Noi", "clouds");
        listWeather.add(model);
        model = new Weather(DateTimeParse.DateParse("10/03/2021"), 25, 20, "Ha Noi", "light clouds");
        listWeather.add(model);
        model = new Weather(DateTimeParse.DateParse("11/03/2021"), 25, 20, "Ha Noi", "light clouds");
        listWeather.add(model);
        model = new Weather(DateTimeParse.DateParse("12/03/2021"), 24, 20, "Ha Noi", "light clouds");
        listWeather.add(model);
        model = new Weather(DateTimeParse.DateParse("13/03/2021"), 25, 20, "Ha Noi", "rain");
        listWeather.add(model);
        model = new Weather(DateTimeParse.DateParse("14/03/2021"), 24, 20, "Ha Noi", "clear");
        listWeather.add(model);
        model = new Weather(DateTimeParse.DateParse("15/03/2021"), 24, 20, "Ha Noi", "rain");
        listWeather.add(model);
        model = new Weather(DateTimeParse.DateParse("16/03/2021"), 27, 21, "Ha Noi", "rain");
        listWeather.add(model);
        model = new Weather(DateTimeParse.DateParse("17/03/2021"), 26, 22, "Ha Noi", "light clouds");
        listWeather.add(model);
        model = new Weather(DateTimeParse.DateParse("18/03/2021"), 26, 21, "Ha Noi", "clouds");
        listWeather.add(model);
        model = new Weather(DateTimeParse.DateParse("19/03/2021"), 25, 22, "Ha Noi", "rain");
        listWeather.add(model);
        model = new Weather(DateTimeParse.DateParse("20/03/2021"), 28, 20, "Ha Noi", "clouds");
        listWeather.add(model);
    }

    public ArrayList<Weather> listAfterToday() {
        ArrayList<Weather> listAfter = new ArrayList<Weather>();
        Date currentTime = new Date();
        for (Weather weather : listWeather) {
            if (DateTimeParse.compareDate(weather.getDateTime(),currentTime)>0) {
                listAfter.add(weather);
            }
        }
        return listAfter;
    }

    public Weather getWeatherToDay() {
        Date currentTime = new Date();
        Weather wea = null;
        for (Weather weather : listWeather) {
            if (DateTimeParse.compareDate(weather.getDateTime(),currentTime)==0) {
                wea = weather;
            }
        }
        return wea;
    }
}
