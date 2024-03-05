package com.fsse2401.lab_b02.api;

import com.fsse2401.lab_b02.data.domainObject.CreatePersonRequestData;
import com.fsse2401.lab_b02.data.domainObject.CreatePersonResponseData;
import com.fsse2401.lab_b02.data.domainObject.GetAllPeopleResponseData;
import com.fsse2401.lab_b02.data.dto.request.CreatePersonRequestDto;
import com.fsse2401.lab_b02.data.dto.response.CreatePersonResponseDto;
import com.fsse2401.lab_b02.data.dto.response.GetAllPeopleResponseDTO;
import com.fsse2401.lab_b02.data.entity.PersonEntity;
import com.fsse2401.lab_b02.service.PersonService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
// transfer to Data (computer)
        CreatePersonResponseDto createPersonResponseDto= new CreatePersonResponseDto(
                createPersonResponseData.getLastName(),
                createPersonResponseData.getFirstName(),
                createPersonResponseData.getHkid()
        );

        return createPersonResponseDto;
    }
// transfer to Dto (user)

    @GetMapping("/person")
    public List<GetAllPeopleResponseDTO> getPeopleDTO(){
        List<GetAllPeopleResponseData> data = personService.getAllPeople();
        List<GetAllPeopleResponseDTO> DTO = new ArrayList<>();
        for( GetAllPeopleResponseData collectdata:data){
            DTO.add(new GetAllPeopleResponseDTO(collectdata.getLastName(),collectdata.getFirstName(),collectdata.getHkid()));
        }
        return DTO;
    }
}

