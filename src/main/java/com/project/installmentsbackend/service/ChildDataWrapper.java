package com.project.installmentsbackend.service;
import com.project.installmentsbackend.dto.ChildDto;
import com.project.installmentsbackend.model.Child;
import com.project.installmentsbackend.model.Parent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChildDataWrapper {
    private List<ChildDto> data;
}
