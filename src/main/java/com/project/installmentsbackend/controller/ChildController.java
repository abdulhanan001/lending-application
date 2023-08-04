package com.project.installmentsbackend.controller;

import com.project.installmentsbackend.model.Child;
import com.project.installmentsbackend.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChildController {
    private ChildRepository childRepository;

    @Autowired
    public ChildController(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    @GetMapping("parents/{parentId}/children")
    public List<Child> getAllChildren(@PathVariable int parentId) {
        return childRepository.findAllByParentId(parentId, Sort.by("id"));
    }
}