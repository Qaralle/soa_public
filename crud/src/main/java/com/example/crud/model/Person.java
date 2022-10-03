package com.example.crud.model;

import com.example.crud.model.base.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "person")
public class Person extends BaseEntity<Long> {
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

    @Id
    @Override
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "height")
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Column(name = "passport")
    public String getPassportID() {
        return passportID;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    @Column(name = "hair_color")
    public Color getHairColor() {
        return hairColor;
    }

    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }

    @Column(name = "nationality")
    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }
}