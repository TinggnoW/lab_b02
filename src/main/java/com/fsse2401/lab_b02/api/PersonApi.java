package com.fsse2401.lab_b02.api;

import com.fsse2401.lab_b02.data.domainObject.CreatePersonRequestData;
import com.fsse2401.lab_b02.data.domainObject.CreatePersonResponseData;
import com.fsse2401.lab_b02.data.dto.request.CreatePersonRequestDto;
import com.fsse2401.lab_b02.data.dto.response.CreatePersonResponseDto;
import com.fsse2401.lab_b02.service.PersonService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonApi {

    private final PersonService personService;
    @Autowired
    public PersonApi(PersonService personService){
        this.personService=personService;
    }
    @PostMapping("/person")
    public CreatePersonResponseDto createPerson (@RequestBody CreatePersonRequestDto createPersonRequestDto){
        CreatePersonRequestData createPersonRequestData = new CreatePersonRequestData(
                createPersonRequestDto.getLastName(),
                createPersonRequestDto.getFirstName(),
                createPersonRequestDto.getHkid()
        );

        CreatePersonResponseData createPersonResponseData=personService.createPerson(createPersonRequestData);

        CreatePersonResponseDto createPersonResponseDto= new CreatePersonResponseDto(
                createPersonResponseData.getLastName(),
                createPersonResponseData.getFirstName(),
                createPersonResponseData.getHkid()
        );

        return createPersonResponseDto;
    }
}
