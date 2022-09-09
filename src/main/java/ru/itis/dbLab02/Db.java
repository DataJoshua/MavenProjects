package ru.itis.dbLab02;

import ru.itis.dbLab02.Entity.Booking;

public class Db {

    public static void main(String args[]){
        WorkData wd = new WorkData();

        Booking b1 =  wd.createBooking();

        System.out.println(b1.toJSON());


    }

}
