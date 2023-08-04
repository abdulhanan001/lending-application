package com.project.installmentsbackend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.installmentsbackend.mappers.ChildMap;
import com.project.installmentsbackend.model.Child;
import com.project.installmentsbackend.model.Parent;
import com.project.installmentsbackend.repository.ChildRepository;
import com.project.installmentsbackend.repository.ParentRepository;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataLoader {
    private ParentRepository parentRepository;
    private ChildRepository childRepository;
    private ChildMap childMap;

    public DataLoader(ParentRepository parentRepository, ChildRepository childRepository, ChildMap childMap) {
        this.parentRepository = parentRepository;
        this.childRepository = childRepository;
        this.childMap = childMap;
    }

    public void loadData() {
       loadParentData();
       loadChildData();
    }

    public void loadParentData() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<ArrayList<Parent>> typeReference = new TypeReference<>() {};
            InputStream inputStream = getClass().getResourceAsStream("/data/Parent.json");
            ParentDataWrapper dataWrapper = objectMapper.readValue(inputStream, ParentDataWrapper.class);
            parentRepository.saveAll(dataWrapper.getData());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadChildData() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<ArrayList<Child>> typeReference = new TypeReference<>() {};
            InputStream inputStream = getClass().getResourceAsStream("/data/Child.json");
            ChildDataWrapper dataWrapper = objectMapper.readValue(inputStream, ChildDataWrapper.class);
            List<Child> children = dataWrapper.getData().stream().map(obj -> childMap.dToM(obj)).collect(Collectors.toList());
            childRepository.saveAll(children);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



