package task2;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date {
    private final int day;
    private final int month;
    private final int year;
    private final long inSeconds;

    public Date(int year, int month, int day) {
        this.day = day;
        this.month = month;
        this.year = year;
        inSeconds = new GregorianCalendar(year, month, day).getTimeInMillis();
    }

    public Date(String date) {
        String[] dateArr = date.split(":");
        year = Integer.parseInt(dateArr[0]);
        month = Integer.parseInt(dateArr[1]);
        day = Integer.parseInt(dateArr[2]);
        inSeconds = new GregorianCalendar(year, month, day).getTimeInMillis();
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public long getInSeconds() {
        return inSeconds;
    }

    @Override
    public String toString() {
        return year + ":" + month + ":" + day;
    }
}
