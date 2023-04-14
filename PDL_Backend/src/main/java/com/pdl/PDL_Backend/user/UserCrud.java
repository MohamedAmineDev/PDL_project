package com.pdl.PDL_Backend.user;

public interface UserCrud {
    boolean registerAClient(User user) throws Exception;

    String login(User user) throws Exception;
}
