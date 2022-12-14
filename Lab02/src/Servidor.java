import javax.xml.crypto.Data;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

public class Servidor {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(5002);
        System.out.println("waiting client......");
        Socket clientSocket = serverSocket.accept();
        System.out.println("client connected");
        System.out.println("waiting message....");
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        OutputStream out = clientSocket.getOutputStream();


        /*Thread receiver = new Thread(new Runnable() {
            String message;
            @Override
            public void run() {
                try{
                    message = in.readLine();
                    while(message != null){

                        System.out.println("client:" + message);
                        message = in.readLine();
                    }
                }catch(IOException e){
                    System.out.println(e);
                }


            }
        });

        receiver.start();
        */

        Thread receiverYSender = new Thread(new Runnable() {
            String message;

            @Override
            public void run() {

                try{
                    message = in.readLine();
                    while(message != null){

                        String sendMessage = "no entiendo nada";

                        if(message.equalsIgnoreCase("как дела?")) {

                            String [] options = {"хорошо", "плохо", "отлично" };
                            String option = options[(int) Math.random() * options.length];
                            sendMessage = option;

                        } else if(message.equalsIgnoreCase("как сегодня погода?")){
                            String [] options = {"снег", "Дождь", "Ветер", "тепло"};
                            String option = options[(int)Math.random() * options.length];
                            sendMessage = option;
                        } else if(message.contains("меня зовут")) {
                            String name = message.substring(10, message.length());
                            sendMessage = "Привет" + name;
                        } else if(message.equalsIgnoreCase("exit")) {
                            sendMessage = "До свидания";
                        } else if(message.equalsIgnoreCase("какое сегодня число?")){
                            Date date =  new Date();
                            sendMessage = date.toString();
                        } else if(message.equalsIgnoreCase("который час?")){
                            DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm:ss");
                            LocalDateTime time = LocalDateTime.now();
                            sendMessage = time.format(f);
                        }else if(message.equalsIgnoreCase("как тебя зовут?")){

                            sendMessage = "Меня зовут server )";
                        }

                        out.write((sendMessage+ "\n").getBytes(StandardCharsets.UTF_8));

                        message = in.readLine();
                    }


                }catch(IOException e){
                    System.out.println(e);
                }
            }
        });

        receiverYSender.start();


    }
}
