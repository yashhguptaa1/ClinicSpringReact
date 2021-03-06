package com.yg.ClinicSpringReact.services;

import com.yg.ClinicSpringReact.api.v1.model.GuardianDTO;
import com.yg.ClinicSpringReact.domain.Guardian;

import java.util.List;

public interface GuardianService {

    List<GuardianDTO> getAllGuardians();
    GuardianDTO getGuardianById(Long id);
    GuardianDTO createNewGuardian(GuardianDTO guardianDTO);
    GuardianDTO saveGuardianByDto(Long id,GuardianDTO guardianDTO);
    GuardianDTO patchGuardian(Long id,GuardianDTO guardianDTO);
    void deleteGuardianById(Long id);

}
