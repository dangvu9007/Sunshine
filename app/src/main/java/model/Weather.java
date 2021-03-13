package model;

import com.dang.sunshine.R;

import java.io.Serializable;
import java.util.Date;

public class Weather implements Serializable {
    private Date dateTime;
    private int tempHight;
    private int tempLow;
    private String region;
    private String state;

    public Weather() {
    }

    public Weather(Date dateTime, int tempHight, int tempLow, String region, String state) {
        this.dateTime = dateTime;
        this.tempHight = tempHight;
        this.tempLow = tempLow;
        this.region = region;
        this.state = state;
    }


    public Date getDateTime() {
        return dateTime;
    }

    public void setDate(Date Date) {
        this.dateTime = Date;
    }

    public int getTempHight() {
        return tempHight;
    }

    public void setTempHight(int tempHight) {
        this.tempHight = tempHight;
    }

    public int getTempLow() {
        return tempLow;
    }

    public void setTempLow(int tempLow) {
        this.tempLow = tempLow;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getThumbnailId() {
        int thumbId=0;
        switch (state){
            case "clear":
                thumbId= R.drawable.ic_clear;
                break;
            case "clouds":
                thumbId=R.drawable.ic_cloudy;
                break;
            case "light clouds":
                thumbId= R.drawable.ic_light_clouds;
                break;
            case "rain":
                thumbId=R.drawable.ic_rain;
                break;

        }
        return thumbId;
    }

    public int getThumbnailArtId() {
        int thumbId=0;
        switch (state){
            case "clear":
                thumbId= R.drawable.art_clear;
                break;
            case "clouds":
                thumbId=R.drawable.art_clouds;
                break;
            case "light clouds":
                thumbId= R.drawable.art_light_clouds;
                break;
            case "rain":
                thumbId=R.drawable.art_rain;
                break;

        }
        return thumbId;
    }
}
