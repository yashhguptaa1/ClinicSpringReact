package com.yg.ClinicSpringReact.repositories;

import com.yg.ClinicSpringReact.domain.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuardianRepository extends JpaRepository<Guardian,Long> {
}
