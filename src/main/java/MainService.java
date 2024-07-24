import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainService {
    public static void main(String[] args){
        System.out.println("Сервер взлетает!");
        int port = 12635;
        while (true){
            try (ServerSocket serverSocket = new ServerSocket(port);
                 Socket clientSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));)
            {
                System.out.printf("Порт для нового принятого соединения: %d%n", clientSocket.getPort());
                final String name = in.readLine();
                out.println(String.format("Привет %s, твой порт %d", name, clientSocket.getPort()));
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
