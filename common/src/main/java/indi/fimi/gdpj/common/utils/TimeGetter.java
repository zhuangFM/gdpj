package indi.fimi.gdpj.common.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeGetter {
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static String getCurrentTimeStr(){
        return FORMAT.format(new Date());
    }

    public static String getCurrentDateStr(){
        return FORMAT.format(new Date());
    }

    public static Date getCurrentTime(){
        Date result = null;
        try {
            result = FORMAT.parse(getCurrentTimeStr());
        } catch (ParseException e) {
            result = new Date();
            e.printStackTrace();
        }
        return result;
    }

    public static Date getCurrentDate(){
        Date result = null;
        try {
            result = FORMAT.parse(getCurrentDateStr());
        } catch (ParseException e) {
            result = new Date();
            e.printStackTrace();
        }
        return result;
    }
//    public static void main(String[] args){
//        System.out.println(getCurrentDate());
//    }

}
