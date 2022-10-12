package com.example.crud.util;

import com.example.crud.service.exception.EmptyCollectionException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionUtils {
    public static <K, V> Map<K, V> listsToMap(List<K> keys, List<V> values) {
        return IntStream.range(0, keys.size()).boxed()
                .collect(Collectors.toMap(keys::get, values::get));
    }

    public static void assertEmpty(List<?> list){
        if (list.isEmpty()) {
            throw new EmptyCollectionException("collection is empty");
        }
    }
}
