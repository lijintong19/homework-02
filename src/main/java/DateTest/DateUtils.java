package DateTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    //指定日期的转换格式
   private static final String YYYYMMDD="yyyy-MM-dd";

    //将字符串转成日期
    public static Date parseDate(String strDate){
        return parseDate(strDate,null);
    }
    public static Date parseDate(String strDate,String pattern){
        Date date =null;
        try {
                if (pattern==null){
                    pattern=YYYYMMDD;
                }
                SimpleDateFormat format=new SimpleDateFormat(pattern);
                date=format.parse(strDate);
        }catch (Exception e){
            e.printStackTrace();
        }
        return date;
    }

    //将日期转换成指定的格式
    public static String formatDate(Date date){
        return formatDate(date,null);
    }
    public static String formatDate(Date date,String pattern){
        String strDate=null;
        try{
            if(pattern==null){
                pattern=YYYYMMDD;
            }
            SimpleDateFormat format =new SimpleDateFormat(pattern);
            strDate=format.format(date);
        }catch (Exception e){
            e.printStackTrace();
        }
        return strDate;
    }


   //获取年份
    public static int getYear(Date date){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        int year=calendar.get(calendar.YEAR);
        return year;
    }

    //获取月份
    public static int getMonth(Date date){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        int month=calendar.get(calendar.MONTH);
        return month+1;
    }

    //获取日
    public static int getDay(Date date){
        Calendar c=Calendar.getInstance();
        c.setTime(date);
        int day=c.get(c.DAY_OF_MONTH);
        return day;
    }

    //获取星期数
    public static int getWeek(Date date){
        Calendar c=Calendar.getInstance();
        c.setTime(date);
        int week=c.get(c.DAY_OF_WEEK);
        return week;
    }
    public static String getW(Date date){
        String[] arr={"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
        int week=getWeek(date);
        return arr[week-1];
    }

    //判断是第几季度
    public static String getSeason(Date date){
        String season=null;
        Calendar c=Calendar.getInstance();
        c.setTime(date);
        int month=c.get(Calendar.MONTH);
        switch(month){
            case Calendar.JANUARY:
            case Calendar.FEBRUARY:
            case Calendar.MARCH:
                season="第一季度";
                break;
            case Calendar.APRIL:
            case Calendar.MAY:
            case Calendar.JUNE:
                season="第二季度";
                break;
            case Calendar.JULY:
            case Calendar.AUGUST:
            case Calendar.SEPTEMBER:
                season="第三季度";
                break;
            case Calendar.OCTOBER:
            case Calendar.NOVEMBER:
            case Calendar.DECEMBER:
                season="第四季度";
                break;
            default:
                break;
        }
        return season;
    }

    //判断是一年中的第几天
    public static int getDayOfYear(Date date){
        int[] leapYear={0,31,60,91,121,152,182,213,244,274,305,335,366};//闰年
        int[] commonYear={0,31,59,90,120,151,181,212,243,273,304,334,365};//平年

        Calendar c=Calendar.getInstance();
        c.setTime(date);
        int Year=c.get(c.YEAR);//获取年份
        int Month=c.get(c.MONTH)+1;//获取月份
        int day=c.get(c.DAY_OF_MONTH);//获取日
        int sumDays=0;
            //判断是否为闰年
            if((Year%4==0&&Year%100!=0)||Year%400==0){
                sumDays=leapYear[Month-1]+day;
            }else{//当前年份不是闰年
                sumDays=commonYear[Month-1]+day;
            }
        return sumDays;
    }

    //输出具体的信息
    public static void toString1(Date date){
        System.out.println("年："+getYear(date)+",月："+getMonth(date)
        +",日："+getDay(date)+",星期:"+getW(date)+",季度："+getSeason(date)+",这一天是这一年中的第："+getDayOfYear(date)+"天");
    }
}
