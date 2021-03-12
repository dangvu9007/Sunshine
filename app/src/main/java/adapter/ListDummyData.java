package adapter;

import java.text.SimpleDateFormat;
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
    }

    public ArrayList<Weather> list7Day() {
        ArrayList<Weather> list7Day = new ArrayList<Weather>();
        Date date = new Date();
        for (Weather weather : listWeather) {
            if (weather.getDate().after(date)) {
                list7Day.add(weather);
            }
        }
        return list7Day;
    }

    public Weather getWeatherToDay() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        Weather wea=null;
        int cp=0;
        for (Weather weather : listWeather) {
            cp=weather.getDate().compareTo(date);
            if (weather.getDate().compareTo(date)==1) {
                wea= weather;
            }
        }
        return wea;
    }
}
