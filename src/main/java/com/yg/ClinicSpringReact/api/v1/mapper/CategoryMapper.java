package com.yg.ClinicSpringReact.api.v1.mapper;

import com.yg.ClinicSpringReact.api.v1.model.CategoryDTO;
import com.yg.ClinicSpringReact.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE= Mappers.getMapper(CategoryMapper.class);
    CategoryDTO categoryToCategoryDTO(Category category);



}
/*
we’ll explore the use of MapStruct which is, simply put, a Java Bean mapper.
This API contains functions that automatically map between two Java Beans.
With MapStruct we only need to create the interface, and the library will automatically create a concrete
implementation during compile time.

For most applications, you’ll notice a lot of boilerplate code converting POJOs to other POJOs.
For example, a common type of conversion happens between persistence-backed entities and DTOs that
go out to the client side.
So that is the problem that MapStruct solves – manually creating bean mappers is time-consuming.
The library can generate bean mapper classes automatically.
 */