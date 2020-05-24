import DateTest.DateUtils;

import java.util.Date;
import java.util.Scanner;

public class DateTest {
    public static void main(String[] args) {
        System.out.println("请正确输入一个日期（按照yyyy-MM-dd）的格式：");
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();

        Date date=new Date();

        DateUtils.toString1(date);
    }
}
