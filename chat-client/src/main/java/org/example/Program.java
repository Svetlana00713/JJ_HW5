package org.example;
import java.util.Scanner;
import java.net.*;
import java.io.IOException;

@SuppressWarnings("ALL")
public class Program {
    public static void main(String[] args) {
        try {
            System.out.println("Start client");
            // System.out.println("Введите свое имя: ");
            @SuppressWarnings("resource")
            String name = new Scanner(System.in).nextLine();
            Socket socket = new Socket("localhost", 1400);
            Client client = new Client(socket, name);

            InetAddress inetAddress = socket.getInetAddress();
            System.out.println("InetAddress: " + inetAddress);
            String remoteIp = inetAddress.getHostAddress();
            System.out.println("Remote IP: " + remoteIp);
            System.out.println("LocalPort: " + socket.getLocalPort());

            client.listenForMessage();
            client.sendMessage();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

