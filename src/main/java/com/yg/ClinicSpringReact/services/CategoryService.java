package com.yg.ClinicSpringReact.services;

import com.yg.ClinicSpringReact.api.v1.model.CategoryDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryByName(String name);

}
