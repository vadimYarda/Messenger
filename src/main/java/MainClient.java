import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainClient {
    public static void main(String[] args){
        String host = "localhost";
        int port = 12635;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            out.println("Олег");
            String resp = in.readLine();
            System.out.println(resp);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
