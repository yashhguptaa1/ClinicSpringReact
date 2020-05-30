package com.yg.ClinicSpringReact.controllers.v1;

import com.yg.ClinicSpringReact.api.v1.model.GuardianDTO;
import com.yg.ClinicSpringReact.api.v1.model.GuardianListDTO;
import com.yg.ClinicSpringReact.services.GuardianService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/guardians/")
public class GuardianController {

    private final GuardianService guardianService;

    public GuardianController(GuardianService guardianService) {
        this.guardianService = guardianService;
    }

    @GetMapping
    public ResponseEntity<GuardianListDTO> getListOfGuardians(){

        return new ResponseEntity<GuardianListDTO>(new GuardianListDTO(guardianService.getAllGuardians()), HttpStatus.OK);
    }

    @GetMapping({"{id}"})
    public ResponseEntity<GuardianDTO> getGuardianById(@PathVariable Long id)
    {
        return new ResponseEntity<GuardianDTO>(guardianService.getGuardianById(id),HttpStatus.OK);
    }


}
