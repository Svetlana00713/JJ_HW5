package org.example;

import java.net.*;
import java.io.*;

public class Server {
    private final ServerSocket serverSocket;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void runServer(){
        try {
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                ClientManager clientManager = new ClientManager(socket);
                System.out.println("Подключен новый клиент.");
                Thread thread = new Thread(clientManager);
                thread.start();
            }
        } catch (IOException e){
            closeSocket();
        }
    }

    public void closeSocket(){
        try{
            if(serverSocket != null) serverSocket.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}