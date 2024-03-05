package com.fsse2401.lab_b02.service;

import com.fsse2401.lab_b02.data.domainObject.CreatePersonRequestData;
import com.fsse2401.lab_b02.data.domainObject.CreatePersonResponseData;
import com.fsse2401.lab_b02.data.domainObject.GetAllPeopleResponseData;
import com.fsse2401.lab_b02.data.entity.PersonEntity;

import java.util.List;

public interface PersonService {
    CreatePersonResponseData createPerson (CreatePersonRequestData createPersonRequestData);

    List<GetAllPeopleResponseData> getAllPeople();
}

