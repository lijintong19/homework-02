package DateTest;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TimeTest {
    public static void main(String[] args) {
        //LocalDate用于表示当天的日期，这里只有日期没有时间
        LocalDate today=LocalDate.now();
        System.out.println("今天的日期是："+today);

        /*
        * LocalDate类提供了很多获取年月日的信息
        * 其实例还包含很多其它的日期属性，通过调用这些方法就
        * 以很方便的得到需要的日期信息，不需要像之前一样需要依赖
        * Calendar类了*/
        int year=today.getYear();//获取年份
        int month=today.getMonthValue();//获取月份
        int day=today.getDayOfMonth();//获取日
        int day2=today.getDayOfYear();//获取一年中的第几天
        System.out.println("年："+year+",月："+month
        +",日："+day+",这是这一年中的第几天:"+day2);

        //我们还可以通过LocalDate.of()方法来创建任意日期，传入指定的年，月，日.
        LocalDate dateOfBirthday=LocalDate.of(1995,02,18);
        System.out.println("我的生日是"+dateOfBirthday);
    }
}

/*检查诸如想生日一样的周期性事件，java通过MonthDay这个类来完成
 * 这个类组合了月份和日，去掉了年，这意味着你可以用它来判断每年都
 * 会发生的事件。*/
 class MonthDateTest{
    public static void main(String[] args) {
        LocalDate today=LocalDate.now();
        LocalDate dateOfBirthday=LocalDate.of(1995,05,22);
        MonthDay birthday=MonthDay.of(dateOfBirthday.getMonthValue(),dateOfBirthday.getDayOfMonth());//获取月份，和日
        MonthDay currentMonthDay=MonthDay.from(today);
        if (currentMonthDay.equals(birthday)){
            System.out.println("祝你生日快乐！");
        }else{
            System.out.println("对不起今天不是你的生日！");
        }
    }
 }

/*
 * java8除了不变类型和线程安全的好处之外，还提供了更好的plusHours()方法替换ad()
 * ,并且是兼容的。注意这些方法返回一个全新的LocalTime实例，由于其不可变性，返回后
 * 一定要用变量赋值*/
 class TimeTest2{
     public static void main(String[] args) {
         //在java8中获取当前的时间没有日期。
         LocalTime time= LocalTime.now();
         System.out.println("当前的时间是："+time);

         //如何在现有的世间上增加小时
         LocalTime newTime=time.plusHours(2);//在现有的时间上增加两小时
         System.out.println("两小时后的时间是："+newTime);

         //计算一周之后的时间
         LocalDate today=LocalDate.now();
         LocalDate nextWeek=today.plus(1,ChronoUnit.WEEKS);
         System.out.println("现在的日期是："+today);
         System.out.println("一周之后的时间是："+nextWeek);
     }
 }

 //使用YearMonth类来演示信用卡到期日以及java8中判断闰年
class YearMonthTest{

     public static void leapYear(LocalDate today){
         if (today.isLeapYear()){
             System.out.println("今年是闰年！");
         }else {
             System.out.println("今年不是闰年！");
         }
     }

     public static void main(String[] args) {
         YearMonth currentYearMonth=YearMonth.now();
         System.out.println("当前月份："+currentYearMonth+",这个月有多少天:"+currentYearMonth.lengthOfMonth());
         YearMonth creditCardExpiry=YearMonth.of(2021,Month.FEBRUARY);
         System.out.println("你的信用卡还款日是："+creditCardExpiry);

         //java8中如何判断闰年
         LocalDate date=LocalDate.of(2019,4,22);
         leapYear(date);
     }
 }
