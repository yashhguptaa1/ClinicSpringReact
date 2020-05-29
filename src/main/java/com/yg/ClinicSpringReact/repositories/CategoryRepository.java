package com.yg.ClinicSpringReact.repositories;

import com.yg.ClinicSpringReact.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
/*
Doubt1: why extends JpaRepository
Doubt2 : why repository package created
 */