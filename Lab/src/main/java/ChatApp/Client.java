package ChatApp;


import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    public static void main(String args []) throws  IOException{
        Socket socket = new Socket("localhost", Server.PORT);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        OutputStream out = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);

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
                }catch (IOException e){
                    System.out.println(e);
                }

            }
        });
        receiver.start();

        Thread sender = new Thread(new Runnable() {
            String message;
            @Override
            public void run() {
                while(true){
                    try{
                        message = scanner.nextLine();
                        out.write((message + "\n").getBytes(StandardCharsets.UTF_8));
                    }catch (IOException e){System.out.println(e);}
                }
            }
        });

        sender.start();
    }
}
