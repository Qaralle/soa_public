package com.example.crud.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CoordinatesDto {
    @NotNull
    @Max(757)
    private Integer x; //Максимальное значение поля: 757, Поле не может быть null
    @NotNull
    @Min(-520)
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