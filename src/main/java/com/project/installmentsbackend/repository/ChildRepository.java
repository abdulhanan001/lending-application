package com.project.installmentsbackend.repository;

import com.project.installmentsbackend.model.Child;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChildRepository extends JpaRepository<Child,Long> {

    List<Child> findAllByParentId(long id, Sort by);
}
