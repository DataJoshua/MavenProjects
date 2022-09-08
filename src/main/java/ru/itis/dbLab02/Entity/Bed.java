package ru.itis.dbLab02.Entity;

public class Bed {
    private Room room;
    private double price;
    private String roomNumber;


    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String toJSON(){
        return "{\"room\":"+ room.toJSON() + ", \"price\":" + price +",\"roomNumber\":\"" + roomNumber +"\"}";
    }
}
