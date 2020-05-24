package regexTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*作业要求：写正则表达式小程序，在给定的地址中使用正则表达式提取国家，省份，
* 城市，区，街道，门牌号。
* 给定地址1:中华人民共和国吉林省长春市二道区临河街万兴小区4栋2门
* 给定地址2:中华人民共和国河北省石家庄市武林区砂石街河东小区8栋1单元
* output
* 使用正则表达式提取：国家，省份，城市，区，街道，门号
* 输出：
* 中华人民共和国
* 吉林省
* 长春市
* 二道区
* 临河街
* 万兴小区4栋2门*/

public class RegexDemo {
    public static void main(String[] args) {
        String test1="中华人民共和国吉林省长春市二道区临河街万兴小区4栋2门";
        String test2="中华人民共和国河北省石家庄市武林区砂石街河东小区8栋1单元";
        //
        Pattern pattern=Pattern.compile("(?<nation>[^国]+国)(?<province>[^省]+省)(?<city>[^市]+市)(?<country>[^区]+区)(?<town>[^街]+街)(?<village>.*)");
        Matcher mc=pattern.matcher(test1);
        System.out.println("使用正则表达式提取：国家，省份，城市，区，街道，门号");
        System.out.println("输出：");
        while (mc.find()){
            System.out.println(mc.group("nation"));
            System.out.println(mc.group("province"));
            System.out.println(mc.group("city"));
            System.out.println(mc.group("country"));
            System.out.println(mc.group("town"));
            System.out.println(mc.group("village"));
        }
    }
}
