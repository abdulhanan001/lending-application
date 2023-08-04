package com.project.installmentsbackend.controller;

import com.project.installmentsbackend.model.Parent;
import com.project.installmentsbackend.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParentController {
    private final ParentRepository parentRepository;

    @Autowired
    public ParentController(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @GetMapping("/parents")
    public List<Parent> getAllParents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        PageRequest pageable = PageRequest.of(page, pageSize, Sort.by(sortBy));
        return parentRepository.findAll(pageable).toList();
    }
}
