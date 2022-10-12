package com.example.additional.dto;

public class CoordinatesDto {
    private Integer x; //Максимальное значение поля: 757, Поле не может быть null
    private Integer y; //Значение поля должно быть больше -521, Поле не может быть null

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}