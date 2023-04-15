package com.pdl.PDL_Backend.user;

import java.util.List;

public interface UserCrud {
    boolean registerAClient(User user) throws Exception;

    String login(User user) throws Exception;

    boolean registerAnAdmin(User user) throws Exception;

    List<User> loadAllClients() throws Exception;

    boolean updateAUser(Long id, User user) throws Exception;
}
