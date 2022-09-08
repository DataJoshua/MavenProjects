package ChatApp;

import java.awt.image.DataBufferDouble;
import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String args []){

        try {

            Socket clientSocket = new Socket("localhost", Server.PORT);

            InputStream inputStream = clientSocket.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            System.out.println(bufferedReader.readLine());



        }catch(Exception e){
            System.out.println(e);
        }
    }
}
