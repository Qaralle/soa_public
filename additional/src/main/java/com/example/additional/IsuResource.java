package com.example.additional;

import com.example.additional.dto.StudyGroupRequestDto;
import com.example.additional.dto.StudyGroupResponseDto;
import com.example.additional.model.FormOfEducation;

import javax.ws.rs.*;
import javax.xml.bind.JAXBException;

import static com.example.additional.client.rest.CrudRestClient.performGetById;
import static com.example.additional.client.rest.CrudRestClient.performUpdateById;

@Path("/groups")
public class IsuResource {
    @POST
    @Path("/{id}/add-student")
    public void addStudent(@PathParam("id") Long id) throws JAXBException {
        StudyGroupResponseDto dto = performGetById(id);
        dto.setStudentsCount(dto.getStudentsCount()+1);
        StudyGroupRequestDto dtoSave =  new StudyGroupRequestDto(dto);

        performUpdateById(id, dtoSave);
    }

    @PUT
    @Path("/{id}/change-edu-form/{form}")
    public void changeFormOfEducation(@PathParam("id") Long id,
                                      @PathParam("form") FormOfEducation newForm) throws JAXBException {
        StudyGroupResponseDto dto = performGetById(id);
        dto.setFormOfEducation(newForm);
        StudyGroupRequestDto dtoSave =  new StudyGroupRequestDto(dto);

        performUpdateById(id, dtoSave);
    }
}