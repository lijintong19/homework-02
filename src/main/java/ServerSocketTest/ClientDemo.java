package ServerSocketTest;

import java.io.*;
import java.net.Socket;
/*作业要求：只用Java里的网络编程，网页链接将内容输出到本地文本中

* 这里写了一个客户端类一个服务器类，达成的效果是服务端将指定的本地文本中的内容传给客户端，
* 客户端再将该信息保存在另外一个本地文本中，（先启动服务端再启动客户端）*/
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket s=new Socket("localhost",12345);
        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(
                s.getOutputStream()
        ));
        BufferedReader br=new BufferedReader(new FileReader("D:\\ReceiveDemo.txt"));
        String line=null;
        while((line=br.readLine())!=null){
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        bufferedWriter.close();
        s.close();
        System.out.println("传输成功！");
    }
}
