package com.fsse2401.lab_b02.service.impl;

import com.fsse2401.lab_b02.data.domainObject.CreatePersonRequestData;
import com.fsse2401.lab_b02.data.domainObject.CreatePersonResponseData;
import com.fsse2401.lab_b02.data.entity.PersonEntity;
import com.fsse2401.lab_b02.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    //Mock DataBase
    List<PersonEntity>personEntityList=new ArrayList<>();
    @Override
    public CreatePersonResponseData createPerson (CreatePersonRequestData createPersonRequestData){
        //Lv1
        PersonEntity personEntity = new PersonEntity(
                createPersonRequestData.getLastName(),
                createPersonRequestData.getFirstName(),
                createPersonRequestData.getHkid()
        );

        personEntityList.add(personEntity);

        CreatePersonResponseData createPersonResponseData = new CreatePersonResponseData(
                personEntity.getLastName(),
                personEntity.getFirstName(),
                personEntity.getHkid()
        );
        return createPersonResponseData;
    }
}
