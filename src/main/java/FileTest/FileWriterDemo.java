package FileTest;

import java.io.*;

/*作业要求：文件的读取和写入，文本文件逐行读取逐行写入，数据量要超过10万行数据*/

public class FileWriterDemo {

    //逐行读取的方法
    public static void readFile(String filePath)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
        for (String line=br.readLine();line!=null;line=br.readLine()){
            System.out.println(line);
        }
        br.close();
    }

    //逐行写入的方法
    public static void writeFile(String filepath){
        FileWriter fileWriter=null;
        try{
            fileWriter=new FileWriter(filepath,true);
            for(int i=0;i<=100000;i++){
                fileWriter.write(i+"今天天气不错！"+"\r\n");
            }
            fileWriter.close();
            System.out.println("写入成功");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("写入失败");
        }
    }

    //测试
    public static void main(String[] args) {
        String filPath="D:\\FileTest.txt";
        //写入数据
        writeFile(filPath);
        //读取数据
        try {
            readFile(filPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
