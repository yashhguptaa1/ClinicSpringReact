package com.yg.ClinicSpringReact.api.v1.mapper;

import com.yg.ClinicSpringReact.api.v1.model.GuardianDTO;
import com.yg.ClinicSpringReact.domain.Guardian;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GuardianMapper {
    GuardianMapper INSTANCE= Mappers.getMapper(GuardianMapper.class);
    GuardianDTO guardianToGuardianDTO(Guardian guardian);
    Guardian guardianDtoToGuardian(GuardianDTO guardianDTO);
}
