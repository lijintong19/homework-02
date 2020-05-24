package DateTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/*作业要求：按指定要求格式化一个日期*/
public class DateFormatDemo {
    public static void main(String[] args) {
        //创建日期对象
        Date date=new Date();

        SimpleDateFormat sdf=new SimpleDateFormat();

        //使用默认格式输出
        String str=sdf.format(date);
        System.out.println("默认格式输出："+str);


        System.out.println("=========================================================");
        //使用自定义格式输出
        //SimpleDateFormat sdf1=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        //SimpleDateFormat sdf1=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 Ea");
        //SimpleDateFormat sdf1=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒SSS毫秒 Ea");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str1=sdf1.format(date);
        System.out.println("自定义格式："+str1);
        System.out.println("=========================================================");
        //将字符串转换成日期
        String str2="1995-02-18 14:00:00";

        try {
            //将字符串转换成日期
            Date date1=sdf1.parse(str2);
            System.out.println("将字符串转换成日期："+date1);//字符串的格式要和SimpleDateFormat中的格式匹配
            System.out.println("=========================================================");
            //将数字转换为日期
            long ms=date1.getTime();
            System.out.println(ms);
            date1.setTime(ms);
            System.out.println("将数字转换成日期"+date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
