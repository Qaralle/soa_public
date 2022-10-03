package com.example.crud.model;

import com.example.crud.model.base.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "coordinates")
public class Coordinates extends BaseEntity<Long> {
    @Max(value = 757)
    @NotNull
    private Integer x; //Максимальное значение поля: 757, Поле не может быть null
    @Min(value = -522)
    @NotNull
    private Integer y; //Значение поля должно быть больше -521, Поле не может быть null

    @Id
    @Override
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @Column(name = "x_value")
    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    @Column(name = "y_value")
    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}