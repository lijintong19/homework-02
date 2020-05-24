package ServerSocketTest;

import java.io.*;
import java.net.Socket;

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
    }
}
