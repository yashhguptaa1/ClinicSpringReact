package com.yg.ClinicSpringReact.controllers.v1;

import com.yg.ClinicSpringReact.api.v1.model.GuardianDTO;
import com.yg.ClinicSpringReact.api.v1.model.GuardianListDTO;
import com.yg.ClinicSpringReact.services.GuardianService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/guardians/")
public class GuardianController {

    private final GuardianService guardianService;

    public GuardianController(GuardianService guardianService) {
        this.guardianService = guardianService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public GuardianListDTO getListOfGuardians(){

        return new GuardianListDTO(guardianService.getAllGuardians());
    }

    @GetMapping({"{id}"})
    @ResponseStatus(HttpStatus.OK)
    public GuardianDTO getGuardianById(@PathVariable Long id)
    {
        return guardianService.getGuardianById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GuardianDTO createNewGuardian(@RequestBody GuardianDTO guardianDTO)
    {
        return guardianService.createNewGuardian(guardianDTO);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public GuardianDTO updateGuardian(@PathVariable Long id,@RequestBody GuardianDTO guardianDTO)
    {
        return guardianService.saveGuardianByDto(id,guardianDTO);
    }

    //when using patch with postman first execute post then execute patch
    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public GuardianDTO patchGuardian(@PathVariable Long id,@RequestBody GuardianDTO guardianDTO)
    {

        return guardianService.patchGuardian(id,guardianDTO);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteGuardian(@PathVariable Long id)
    {
        guardianService.deleteGuardianById(id);
    }



}
