package com.pdl.PDL_Backend.details_du_approvisionnement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsDuApprovisionnementRepository extends JpaRepository<DetailsDuApprovisionnement, Long> {
}
