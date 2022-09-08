package ru.itis.lab01;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String args[]){
        try{
            Socket s = new Socket("localhost", 50001);
            InputStream inputStream = s.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            System.out.print(br.readLine());

        }
        catch(Exception e){

        }
    }
}
