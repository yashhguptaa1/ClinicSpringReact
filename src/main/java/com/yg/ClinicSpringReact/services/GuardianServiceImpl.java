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

        return saveAndReturnDTO(guardianMapper.guardianDtoToGuardian(guardianDTO));
    }

    // Since Create and update operation are pretty
    // much same only difference is initial code
    // so making one function for that after function

    private GuardianDTO saveAndReturnDTO(Guardian guardian)
    {
        Guardian savedGuardian=guardianRepository.save(guardian);
        GuardianDTO returnDto=guardianMapper.guardianToGuardianDTO(savedGuardian);
        returnDto.setGuardianUrl("/api/v1/guardian/"+savedGuardian.getId());
        return returnDto;
    }

    @Override
    public GuardianDTO saveGuardianByDto(Long id, GuardianDTO guardianDTO) {

        Guardian guardian =guardianMapper.guardianDtoToGuardian(guardianDTO);
        guardian.setId(id);

        return saveAndReturnDTO(guardian);
    }

    @Override
    public GuardianDTO patchCustomer(Long id, GuardianDTO guardianDTO) {
        return guardianRepository.findById(id).map(guardian -> {
            if(guardianDTO.getFirstName()!=null)
            {
                guardian.setFirstName(guardianDTO.getFirstName());
            }
            if(guardianDTO.getLastName()!=null)
            {
                guardian.setLastName(guardianDTO.getLastName());
            }
            GuardianDTO returnDto=guardianMapper.guardianToGuardianDTO(guardianRepository.save(guardian));
            returnDto.setGuardianUrl("/api/v1/guardian/"+id);
            return returnDto;

        }).orElseThrow(RuntimeException::new);
    }
}
