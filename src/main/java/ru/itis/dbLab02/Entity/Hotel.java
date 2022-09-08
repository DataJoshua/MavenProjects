package ru.itis.dbLab02.Entity;




public class Hotel {
    private String name;
    private String adress;
    private int hotelStars;

    public int getHotelStars() {
        return hotelStars;
    }

    public void setHotelStars(int hotelStars) {
        this.hotelStars = hotelStars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }


    public String toJSON(){
        return "{\"name\":\""+name + "\", \"adress\":\"" + adress +"\",\"starts\":" + hotelStars +"}";
    }
}
