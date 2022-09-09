package ChatApp;

import com.sun.nio.sctp.AbstractNotificationHandler;

import java.awt.image.DataBufferDouble;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Client {
    public static void main(String args []){

        Socket socket;
        BufferedReader in;
        PrintWriter out;
        Scanner scanner = new Scanner(System.in);
        try{
            socket = new Socket("localhost", Server.PORT);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());

            Thread sender = new Thread(new Runnable() {
                String message;
                @Override
                public void run() {
                    while(2==2){
                        message = scanner.nextLine(); // read the console
                        out.println(message);// send to the server
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
                            System.out.println("Server says: " + message);
                            message = in.readLine();
                        }
                        // the server is over
                        System.out.println("server out of service");
                        socket.close();

                    }catch(IOException e){System.out.println(e);}
                }
            });
            receiver.start();
        }catch(IOException e){System.out.println(e);}



    }
}
