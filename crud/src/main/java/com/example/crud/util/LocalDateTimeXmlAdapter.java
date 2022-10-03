package com.example.crud.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;

public class LocalDateTimeXmlAdapter extends XmlAdapter<String, LocalDateTime> {
    public LocalDateTime unmarshal(String v) {
        return LocalDateTime.parse(v);
    }

    public String marshal(LocalDateTime v) {
        return v.toString();
    }
}