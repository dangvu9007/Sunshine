package bussiness;

import org.joda.time.DateTimeComparator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeParse {
    static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public static Date DateParse(String strDate) {
        Date date = null;
        try {
            date = format.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String dayOfWeek(Date date) {
        format.applyPattern("EEEE");
        return format.format(date);
    }

    public static String today() {
        Date date = new Date();
        format.applyPattern("MMMM dd");
        return "Today," + format.format(date);
    }

    public static String date(Date date){
        format.applyPattern("EEEE, MMMM d");
        return format.format(date);

    }

    public static int compareDate(Date date1,Date date2){
        DateTimeComparator comparator = DateTimeComparator.getDateOnlyInstance();
        return comparator.compare(date1,date2);
    }
}
