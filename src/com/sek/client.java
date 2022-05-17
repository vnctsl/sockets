package com.sek;
import java.net.*;
import java.io.*;

public class client {

    public static void main(String[] args) throws IOException{
        Socket clientSocket = new Socket("127.0.0.1", 8000);

        OutputStreamWriter out = new OutputStreamWriter(clientSocket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        out.write("Get me some info\n");
        out.flush();


        String response = in.readLine();
        System.out.println(response);


        out.close();
        in.close();
        clientSocket.close();
    }
}
