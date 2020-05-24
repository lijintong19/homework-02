package FileTest;

import java.io.File;

public class FileDemo1 {
    public static void main(String[] args) {
        String inputPath="E:\\test";
        File file=new File(inputPath);
        func(file);
    }

    //递归遍历目录下的所有文件（包括子目录下文件）
    private static void func(File file){
        File[] fs=file.listFiles();
        for (File f : fs) {
            if (f.isDirectory()){
                func(f);
            }
            if (f.isFile()){
                System.out.println(f);
            }
        }
    }
}
