package ru.itis.dbLab02.Entity;

import java.util.Date;

public class Client {
    private String name;
    private String email;
    private Date birthDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public String toJSON(){
        return "{\"name\":\""+name + "\", \"email\":\"" + email +"\",\"birthdate\":" + birthDate +"}";
    }
}
