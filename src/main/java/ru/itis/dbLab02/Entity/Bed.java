package ru.itis.dbLab02.Entity;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Bed {
    private Room room;
    private double price;
    private String roomNumber;

    public String toJSON(){
        return "{\"room\":"+ room.toJSON() + ", \"price\":" + price +",\"roomNumber\":\"" + roomNumber +"\"}";
    }
}
