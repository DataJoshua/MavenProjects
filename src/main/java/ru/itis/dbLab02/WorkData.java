package ru.itis.dbLab02;

import ru.itis.dbLab02.Entity.*;

import java.text.DateFormat;
import java.util.Date;

public class WorkData {

    public Booking createBooking(){
        Booking booking = new Booking();
        Hotel hotel = new Hotel();
        hotel.setName("Grand Hostel");
        hotel.setAdress("Ru, Kazan pushkina");

        booking.setHotel(hotel);

        Room room = new Room();
        room.setRoomNumber(1);
        room.setCategory("normal");
        room.setHotel(hotel);

        booking.setRoom(room);

        Client client = new Client();
        client.setEmail("jodsahfi@gmail.com");
        client.setName("Joshua");
        client.setBirthDate(new Date());
        booking.setClient(client);

        Bed bed = new Bed();
       bed.setPrice(500);
        bed.setRoom(room);
        bed.setRoomNumber("10");

        booking.setBed(bed);

        booking.setArrivalDate(new Date());
        booking.setStayUntil(new Date());
        return booking;
    }
}
