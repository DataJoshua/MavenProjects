
import java.io.*;
import java.net.Socket;


import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try{
            Socket  clientSocket = new Socket("localhost", 5002);

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
                         out.write((message + "\n").getBytes(StandardCharsets.UTF_8));

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
                            System.out.println("server says:" + message);
                            message = in.readLine();
                        }
                    }catch(IOException e){
                        System.out.println(e);
                    }


                }
            });

            receiver.start();


        }catch(IOException e){
            System.out.println(e);
        }


    }
}

