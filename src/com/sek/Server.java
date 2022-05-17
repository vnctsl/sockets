package com.sek;

import java.io.*;
import java.net.*;


public class Server implements Runnable {
    static private ServerSocket server;
    static private Socket client;
    static private ObjectOutputStream output;
    static private InputStream input;

    public void run() {

        try {
            server = new ServerSocket(8888, 10);
            while (true) {
                client = server.accept();
                output = new ObjectOutputStream(client.getOutputStream());
                input = new ObjectInputStream(client.getInputStream());
//                output.write((byte[]) input.readObject());
            }
        } catch (IOException e) {
            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        }
    }}
