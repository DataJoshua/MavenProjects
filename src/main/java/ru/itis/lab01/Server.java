package ru.itis.lab01;


import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static int SERVER_PORT = 50001;

    public static void main(String args[]){

        try{

            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);

            Socket clientSocket = serverSocket.accept();

            OutputStream os = clientSocket.getOutputStream();

            DataOutputStream dos =  new DataOutputStream(os);

            dos.writeBytes("hola putito\n");


        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }


}
