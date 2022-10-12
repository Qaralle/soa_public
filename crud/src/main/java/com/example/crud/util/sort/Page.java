package com.example.crud.util.sort;

import java.util.List;

public class Page<T> {
    private List<T> data;
    private Long totalSize;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }
}
