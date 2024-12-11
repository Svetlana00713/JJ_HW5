package org.example;

import java.net.*;
import java.io.*;
import java.rmi.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start server");
        try {
            ServerSocket serverSocket = new ServerSocket(1400);
            Server server = new Server(serverSocket);
            server.runServer();

        } catch (UnknownHostException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}