package com.pdl.PDL_Backend.user;

import java.util.List;
import java.util.UUID;

public interface UserCrud {
    boolean registerAClient(User user) throws Exception;

    String login(User user) throws Exception;

    boolean registerAnAdmin(User user) throws Exception;

    List<User> loadAllClients() throws Exception;

    boolean updateAUser(UUID id, User user) throws Exception;
}
