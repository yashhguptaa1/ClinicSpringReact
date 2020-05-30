package com.yg.ClinicSpringReact.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Guardian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    //We dont mention String guardianUrl here because we wont get
    // any specific input from user for url
    //instead we will only set its value thats why defined only in GuardianDTO

}
