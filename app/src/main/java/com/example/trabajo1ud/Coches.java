package com.example.trabajo1ud;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "cars")
public class Coches implements Serializable {


    @Override
    public String toString() {
        return "Coches{" +
                "year=" + year +
                ", id=" + id +
                ", horsepower=" + horsepower +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", img_url='" + img_url + '\'' +
                '}';
    }

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "horsepower")
    private int horsepower;
    @ColumnInfo(name = "make")
    private String make;
    @ColumnInfo(name = "model")
    private String model;
    @ColumnInfo(name = "price")
    private int price;
    @ColumnInfo(name = "year")
    private int year;

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    private String img_url;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}