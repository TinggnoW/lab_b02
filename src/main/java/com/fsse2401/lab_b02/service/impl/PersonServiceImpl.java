package com.fsse2401.lab_b02.service.impl;

import com.fsse2401.lab_b02.data.domainObject.CreatePersonRequestData;
import com.fsse2401.lab_b02.data.domainObject.CreatePersonResponseData;
import com.fsse2401.lab_b02.data.domainObject.GetAllPeopleResponseData;
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
        // Build database (import)
        CreatePersonResponseData createPersonResponseData = new CreatePersonResponseData(
                personEntity.getLastName(),
                personEntity.getFirstName(),
                personEntity.getHkid()
        );
        return createPersonResponseData;
        // make createPersonResponseData (export)
    }

    @Override
    public List<GetAllPeopleResponseData> getAllPeople(){
       List<GetAllPeopleResponseData> getAllPeopleResponseData = new ArrayList<>();
        for(PersonEntity getdata:personEntityList){
            getAllPeopleResponseData.add(new GetAllPeopleResponseData(getdata.getLastName(),getdata.getFirstName(),getdata.getHkid()));
        }return getAllPeopleResponseData;
    }



}
