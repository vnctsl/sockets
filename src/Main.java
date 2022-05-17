import com.sek.client;

import java.net.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {


    int count = 0;
    ServerSocket serverSocket = new ServerSocket(8000);
    System.out.println("ServerStarted");



    while(true){
        Socket clientSocket = serverSocket.accept();
        System.out.println("Clients accepted: " + (++count));
        OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));

        String request = reader.readLine();

        String newRequest = request.replace(" ","_");
        String response =  newRequest + "\n";


        writer.write(response);
        writer.flush();

        writer.close();
        reader.close();
        clientSocket.close();
    }

    }
}
