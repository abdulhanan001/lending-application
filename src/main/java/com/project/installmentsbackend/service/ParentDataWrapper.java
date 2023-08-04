package com.project.installmentsbackend.service;

import com.project.installmentsbackend.model.Parent;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParentDataWrapper {
    private List<Parent> data;
}
