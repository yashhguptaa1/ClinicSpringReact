package com.yg.ClinicSpringReact.api.v1.model;

/*
expose this class using REST controller
 */
import lombok.*;

@Data
public class CategoryDTO {
    private Long id;
    private String name;
}
