package ChatApp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.ServerException;

public class Server {

    public static int PORT = 60000;

    public static void main(String args[]){

        //create Server socket
        try{

            ServerSocket serverSocket = new ServerSocket(PORT);

            Socket clientSocket = serverSocket.accept();

            OutputStream outputStream = clientSocket.getOutputStream();

            DataOutputStream dos = new DataOutputStream(outputStream);

            dos.writeBytes("Hello world!\n");

        }catch(ServerException e) {
            System.out.println(e);
        }
        catch(IOException es){
            System.out.println(es);
        }


    }
}
