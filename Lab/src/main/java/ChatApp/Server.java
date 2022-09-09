package ChatApp;

import javax.print.attribute.standard.RequestingUserName;
import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.ServerException;
import java.util.Scanner;

public class Server {

    public static final int PORT = 5001;

    public static void main(String[] args) {

        System.out.println("Waiting for connection");
        ServerSocket serverSocket;
        BufferedReader in;
        PrintWriter out;
        Socket clientSocket;
        final Scanner scanner = new Scanner(System.in);

        try{
             serverSocket = new ServerSocket(PORT);
             // accept the client connection
             clientSocket = serverSocket.accept();
                System.out.println("client connected");
             in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             out = new PrintWriter(clientSocket.getOutputStream());

             Thread sender = new Thread(new Runnable() {
                 String message;
                 @Override
                 public void run() {
                     while(1 == 1){
                         message = scanner.nextLine(); //reading the input of the user
                         out.println(message); // we send the message the user is typing in console to the client socket
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
                         message = in.readLine(); // read the data from the client socket
                         System.out.println("prjafjisa");
                         while(message != null){
                             System.out.println("client says: " + message);
                             message = in.readLine();
                         }
                            // in the case the message is null the user is disconected

                         System.out.println("client disconnected");

                         out.close();
                         in.close();
                         clientSocket.close();
                         serverSocket.close();

                     }
                     catch(IOException e){System.out.println(e);}
                 }
             });

             receiver.start();

        }catch(IOException exception){
            System.out.println(exception);
        }




    }

}
