package ServerSocketTest;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(12345);
        Socket s = ss.accept();//侦听要连接此套接字的请求并接受它。
        BufferedReader br = new BufferedReader(new InputStreamReader(
                s.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\Copy.txt"));
        String line = null;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        bw.close();
        s.close();
    }
}
