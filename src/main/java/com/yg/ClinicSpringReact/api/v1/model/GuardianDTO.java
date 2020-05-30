package com.yg.ClinicSpringReact.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuardianDTO {
   // private Long id;
    private String firstName;
    private String lastName;

    @JsonProperty("guardian_url")
    private String guardianUrl;

}
