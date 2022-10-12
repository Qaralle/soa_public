package com.example.crud.util.sort;

import com.example.crud.model.StudyGroup;
import com.example.crud.model.base.BaseEntity;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.domain.Sort;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

public class FilterUtils {
    public static List<Sort.Order> getOrdersByNames(Map<String, String> namePropertyMap){
        if (namePropertyMap == null || namePropertyMap.isEmpty()){
            return Collections.emptyList();
        }

        List<Sort.Order> orders = new ArrayList<>();
        List<String> columnsNames = new ArrayList<>();

        for (Field f : StudyGroup.class.getDeclaredFields()) {
            columnsNames.add(f.getName());
            if (BaseEntity.class.isAssignableFrom(f.getType())) {
                List<String> names = Arrays.stream(f.getType().getDeclaredFields())
                        .map(Field::getName)
                        .collect(Collectors.toList());

                for (String name : names) {
                    columnsNames.add(f.getName() + "." + name);
                }
            }
        }

        namePropertyMap.entrySet().stream()
                .filter(e -> columnsNames.contains(e.getKey()))
                .forEach(e -> {
                    if (e.getValue().equalsIgnoreCase("desc")) {
                        orders.add(Sort.Order.desc(e.getKey()));
                    } else {
                        orders.add(Sort.Order.asc(e.getKey()));
                    }
                });

        return orders;
    }
}
