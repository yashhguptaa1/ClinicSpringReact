package com.yg.ClinicSpringReact.repositories;

import com.yg.ClinicSpringReact.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long>
{
    Category findByName(String name);
}
