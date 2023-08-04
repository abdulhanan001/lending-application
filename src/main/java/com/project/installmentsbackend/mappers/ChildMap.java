package com.project.installmentsbackend.mappers;

import com.project.installmentsbackend.dto.ChildDto;
import com.project.installmentsbackend.model.Child;
import com.project.installmentsbackend.model.Parent;
import com.project.installmentsbackend.repository.ParentRepository;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class ChildMap {
    private ParentRepository parentRepository;

    public ChildMap(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    public Child dToM(ChildDto childDto) {
        if ( childDto == null ) {
            return null;
        }

        Child child = new Child();

        if ( childDto != null ) {
            child.setId( childDto.getId() );
            child.setPaidAmount( childDto.getPaidAmount() );
            Optional<Parent> parent = parentRepository.findById(childDto.getParentId());
            if(parent.isPresent()) child.setParent(parent.get());
        }

        return child;
    }
}
