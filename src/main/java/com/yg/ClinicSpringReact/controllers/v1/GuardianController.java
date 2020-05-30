package com.yg.ClinicSpringReact.controllers.v1;

import com.yg.ClinicSpringReact.api.v1.model.GuardianDTO;
import com.yg.ClinicSpringReact.api.v1.model.GuardianListDTO;
import com.yg.ClinicSpringReact.services.GuardianService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<GuardianDTO> createNewGuardian(@RequestBody GuardianDTO guardianDTO)
    {
        return new ResponseEntity<GuardianDTO>(guardianService.createNewGuardian(guardianDTO),HttpStatus.CREATED);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<GuardianDTO> updateGuardian(@PathVariable Long id,@RequestBody GuardianDTO guardianDTO)
    {
        return new ResponseEntity<GuardianDTO>(guardianService.saveGuardianByDto(id,guardianDTO),HttpStatus.OK);
    }

    //when using patch with postman first execute post then execute patch
    @PatchMapping({"/{id}"})
    public ResponseEntity<GuardianDTO> patchGuardian(@PathVariable Long id,@RequestBody GuardianDTO guardianDTO)
    {

        return new ResponseEntity<GuardianDTO>(guardianService.patchGuardian(id,guardianDTO),HttpStatus.OK);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteGuardian(@PathVariable Long id)
    {
        guardianService.deleteGuardianById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }



}
