package ru.itis.lab01;

import java.net.InetAddress;

public class Lab01InetAdress {
    public static void main(String args[]){
        InetAddress aiRemote  = null;
        InetAddress[] iaRemoteAll;

        String name = "google.com";

        try {
            aiRemote = InetAddress.getByName(name);
            iaRemoteAll = InetAddress.getAllByName(name);

            for(InetAddress e: iaRemoteAll){
                System.out.println(e);
            }


        }
        catch(Exception e){
            System.out.print(e);
        }
    }
}
