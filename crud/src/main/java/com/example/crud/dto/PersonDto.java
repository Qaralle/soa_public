package com.example.crud.dto;

import com.example.crud.model.Color;
import com.example.crud.model.Country;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PersonDto {
    @NotNull
    @NotBlank
    private String name; //Поле не может быть null, Строка не может быть пустой
    @Min(0)
    private int height; //Значение поля должно быть больше 0
    @NotNull
    private String passportID; //Поле не может быть null
    @NotNull
    private Color hairColor; //Поле не может быть null
    @NotNull
    private Country nationality; //Поле не может быть null

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getPassportID() {
        return passportID;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    public Color getHairColor() {
        return hairColor;
    }

    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }
}