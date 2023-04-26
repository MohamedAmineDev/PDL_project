package com.pdl.PDL_Backend.supply;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SupplyRepository extends JpaRepository<Supply, UUID> {
}
