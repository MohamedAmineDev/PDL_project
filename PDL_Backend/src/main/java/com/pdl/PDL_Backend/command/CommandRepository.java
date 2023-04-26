package com.pdl.PDL_Backend.command;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CommandRepository extends JpaRepository<Command, UUID> {
    @Query("select c from Command c where c.type=?1")
    List<Command> findByType(CommandType type);

    @Query("select c from Command c where c.client.email=?1")
    List<Command> findByUserEmail(String email);
    @Query("select c.id,c.createdAt,c.totalPrice,c.type from Command c")
    List<Command> findAllCommands();
}
