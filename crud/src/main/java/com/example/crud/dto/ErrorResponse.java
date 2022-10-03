package com.example.crud.dto;

import com.example.crud.util.LocalDateTimeXmlAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;

@XmlRootElement(name = "errorResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class ErrorResponse {
    @XmlElement
    private String message;
    @XmlElement
    @XmlJavaTypeAdapter(value = LocalDateTimeXmlAdapter.class)
    private LocalDateTime timeStamp;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
