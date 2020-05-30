package com.yg.ClinicSpringReact.services;

import com.yg.ClinicSpringReact.api.v1.mapper.GuardianMapper;
import com.yg.ClinicSpringReact.api.v1.model.GuardianDTO;
import com.yg.ClinicSpringReact.domain.Guardian;
import com.yg.ClinicSpringReact.repositories.GuardianRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuardianServiceImpl implements GuardianService{

    private final GuardianMapper guardianMapper;
    private final GuardianRepository guardianRepository;

    public GuardianServiceImpl(GuardianMapper guardianMapper, GuardianRepository guardianRepository) {
        this.guardianMapper = guardianMapper;
        this.guardianRepository = guardianRepository;
    }

    @Override
    public List<GuardianDTO> getAllGuardians() {
        return guardianRepository
                .findAll()
                .stream().map(guardian -> {
                    GuardianDTO guardianDTO=guardianMapper.guardianToGuardianDTO(guardian);
                    guardianDTO.setGuardianUrl("api/v1/guardians/"+ guardian.getId());
                    return guardianDTO;
                }).collect(Collectors.toList());
    }

    @Override
    public GuardianDTO getGuardianById(Long id) {
        return guardianRepository.findById(id)
                .map(guardianMapper::guardianToGuardianDTO)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public GuardianDTO createNewGuardian(GuardianDTO guardianDTO) {
        Guardian guardian=guardianMapper.guardianDtoToGuardian(guardianDTO);
        Guardian savedGuardian=guardianRepository.save(guardian);
        GuardianDTO returnDto=guardianMapper.guardianToGuardianDTO(savedGuardian);
        returnDto.setGuardianUrl("/api/v1/guardian/"+savedGuardian.getId());


        return returnDto;
    }
}
