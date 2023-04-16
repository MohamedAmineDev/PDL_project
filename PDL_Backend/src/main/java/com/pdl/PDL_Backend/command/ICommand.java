package com.pdl.PDL_Backend.command;

import com.pdl.PDL_Backend.user.User;

import java.util.List;
import java.util.UUID;

public interface ICommand {
    List<Command> getAll() throws Exception;

    String add(Command command, boolean payed, User user) throws Exception;

    String update(UUID id, boolean delivered) throws Exception;

    String delete(UUID id) throws Exception;

    List<Command> getAllCommandsThatAreWaitingForPayment() throws Exception;

    List<Command> getAllCommandsThatArePayedWaitingForDelivery() throws Exception;

    List<Command> getAllCommandsThatArePayedAndDelivered() throws Exception;

    List<Command> getAllCommandsOfAUser(User user) throws Exception;
}
