package com.yg.ClinicSpringReact.services;

import com.yg.ClinicSpringReact.api.v1.model.GuardianDTO;

import java.util.List;

public interface GuardianService {

    List<GuardianDTO> getAllGuardians();
    GuardianDTO getGuardianById(Long id);

}
