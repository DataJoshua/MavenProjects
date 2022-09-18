package ru.itis.lab01;

import com.sun.source.tree.Scope;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String args[]){

        try{
            Socket clientSocket = new Socket("localhost", Server.SERVER_PORT);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
            Scanner scanner = new Scanner(System.in);

            Thread receiver = new Thread(new Runnable() {
                String msg;
                @Override
                public void run() {
                    try{
                        msg = in.readLine();
                        while(msg != null){
                            System.out.println("Server:" + msg);
                            msg= in.readLine();
                        }
                    }catch(IOException e){System.out.print(e);}

                }
            });
            receiver.start();
            Thread sender = new Thread(new Runnable() {
                String msg;
                @Override
                public void run() {
                    while(true){
                        msg = scanner.nextLine();
                        out.println(msg);
                        out.flush();
                    }
                }
            });
            sender.start();


        }catch(IOException e){
            System.out.println(e);
        }


    }
}
