package com.pdl.PDL_Backend.user;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface IUserController {
    ResponseEntity<?> registerAClient(User user) throws Exception;

    ResponseEntity<?> login(User user) throws Exception;

    ResponseEntity<?> registerAnAdmin(User user) throws Exception;

    ResponseEntity<List<User>> loadAllClients() throws Exception;

    ResponseEntity<?> updateAUser(UUID id, User user) throws Exception;
}
