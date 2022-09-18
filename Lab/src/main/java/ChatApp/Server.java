package ChatApp;

import javax.print.attribute.standard.RequestingUserName;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.BufferOverflowException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Server {

    public static final int PORT = 5001;

    public static void main(String[] args) throws  IOException {

        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket clientSocket = serverSocket.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        OutputStream out = clientSocket.getOutputStream();
        Scanner scanner = new Scanner(System.in);

        Thread sender = new Thread(new Runnable() {
            String message;
            @Override
            public void run() {
                while(true){
                    try{
                        message = scanner.nextLine();
                        out.write((message+"\n").getBytes(StandardCharsets.UTF_8));
                    }catch(IOException e){
                        System.out.println(e);
                    }
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
                        System.out.println(message);
                        message = in.readLine();
                    }

                }catch(IOException  e){
                    System.out.println(e);
                }


            }
        });
        receiver.start();


    }
}

