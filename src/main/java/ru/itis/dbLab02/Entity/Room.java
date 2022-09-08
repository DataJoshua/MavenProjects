package ru.itis.dbLab02.Entity;

public class Room {
    private Hotel hotel;
    private int roomNumber;
    private String category;
    private double price;


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String toJSON(){
        return "{\"hotel\": " + hotel.toJSON() + ",\"room\":"+roomNumber + ", \"category\":\"" + category +"\",\"price\":" + price +"}";
    }

}
