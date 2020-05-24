package DateTest;


import java.util.Calendar;
//这一部分主要列出了日历类的常用方法
public class CalendarDemo {
    public static void main(String[] args) {

        //使用默认时区和区域设置获取日历
        Calendar c=Calendar.getInstance();

        int y=c.get(c.YEAR);          //获取当前年
        int m=c.get(c.MONTH)+1;       //获取当前月份需要加1
        int d=c.get(c.DATE);          //获取当前日
        int h=c.get(c.HOUR);          //获取当前小时
        int M=c.get(c.MINUTE);        //获取当前分钟
        int s=c.get(c.SECOND);        //获取当前秒
        int week=c.get(c.DAY_OF_WEEK);//获取周几       注意：1-表示的是星期日
        System.out.println(y+"年-"+m+"月-"+
                d+"日,"+h+"时："+M+"分钟："+s+"秒,"+"星期"+week);
    }
}
