package com.example.additional.client.rest;

import com.example.additional.dto.StudyGroupRequestDto;
import com.example.additional.dto.StudyGroupResponseDto;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class CrudRestClient {
    public static final String BASE_URL = "https://localhost:27813/university";

    public static StudyGroupResponseDto performGetById(Long id){
        Client client = ClientBuilder.newClient();

        return client.target(BASE_URL).path("/groups/{id}")
                    .resolveTemplate("id", id)
                .request(MediaType.APPLICATION_XML)
                .get(StudyGroupResponseDto.class);
    }

    public static void performUpdateById(Long id, StudyGroupRequestDto dto) throws JAXBException {
        Client client = ClientBuilder.newClient();
        JAXBContext jc = JAXBContext.newInstance(StudyGroupRequestDto.class);
        Marshaller marshaller = jc.createMarshaller();
        StringWriter sw = new StringWriter();
        marshaller.marshal(dto,sw);
        String xml = sw.toString();

        client.target(BASE_URL).path("/groups/{id}")
                .resolveTemplate("id", id)
                .request(MediaType.APPLICATION_XML)
                .put(Entity.xml(dto));
    }
}
