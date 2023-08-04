package com.project.installmentsbackend.repository;

import com.project.installmentsbackend.model.Parent;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parent, Long> {

}
