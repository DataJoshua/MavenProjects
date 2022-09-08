package ru.itis.dbLab02.Entity;

import java.util.Date;

public class Booking {
    private Hotel hotel;
    private Client client;
    private Room room;
    private Bed bed;
    private Date arrivalDate;
    private Date stayUntil;
    private double sum;




    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getStayUntil() {
        return stayUntil;
    }

    public void setStayUntil(Date stayUntil) {
        this.stayUntil = stayUntil;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "hotel=" + hotel.toString() +
                ", client=" + client.toString() +
                ", room=" + room.toString() +
                ", bed=" + bed.toString() +
                '}';
    }

    public String toJSON(){
        return "{\"hotel\":"+ hotel.toJSON() + ", \"client\":" + client.toJSON() +",\"room:" + room.toJSON()+",\"bed\":"+ bed.toJSON() +",\"arrivalDate\":"+ arrivalDate +",\"stayUntil\":"+ stayUntil +"}";
    }

}
