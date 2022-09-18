package ru.itis.lab01;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.TreeMap;

public class Server {
    public static int SERVER_PORT = 50001;

    public static void main(String args[]){

        ServerSocket serverSocket;
        BufferedReader in;
        PrintWriter out;
        Socket clientSocket;
        Scanner scanner = new Scanner(System.in);

        try{
            serverSocket = new ServerSocket(SERVER_PORT);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream());
            in  = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            Thread sender = new Thread(new Runnable() {
                String message;
                @Override
                public void run() {
                      while(true){
                          message = scanner.nextLine();
                          out.println(message);
                          out.flush();
                      }
                }
            });
            sender.start();

            Thread receiver = new Thread(new Runnable() {
                String message;
                @Override
                public void run() {
                    try{
                        message = in.readLine();
                        while(message != null){
                            System.out.println("Client: " + message);
                            message = in.readLine();
                        }

                    }catch(IOException e){System.out.print(e);}
                }
            });
            receiver.start();
        }
        catch(IOException e){System.out.print(e);}
    }


}
