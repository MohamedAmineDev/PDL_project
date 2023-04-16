package com.pdl.PDL_Backend.command;

import com.pdl.PDL_Backend.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/command")
@RequiredArgsConstructor
public class CommandController implements ICommand {
    private final CommandService service;

    @GetMapping(path = "/commands")
    @Override
    public List<Command> getAll() {
        try {
            return service.getAll();
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ArrayList<>();
        }
    }

    @PostMapping(path = "/client/addition/{payed}")
    @Override
    public String add(@RequestBody Command command, @PathVariable("payed") boolean payed, @AuthenticationPrincipal User user) {
        try {
            return service.add(command, payed, user);
        } catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @PutMapping(path = "/admin/update/{id}")
    @Override
    public String update(@PathVariable("id") UUID id, @RequestBody boolean delivered) {
        try {
            return service.update(id, delivered);
        } catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @DeleteMapping(path = "/client/delete/{id}")
    @Override
    public String delete(@PathVariable("id") UUID id) {
        try {
            return service.delete(id);
        } catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @GetMapping(path = "/admin/commands_that_are_waiting_for_payment")
    @Override
    public List<Command> getAllCommandsThatAreWaitingForPayment() {
        try {
            return service.getAllCommandsThatAreWaitingForPayment();
        } catch (Exception exception) {
            return new ArrayList<>();
        }
    }

    @GetMapping(path = "/admin/commands_that_are_payed_waiting_for_delivery")
    @Override
    public List<Command> getAllCommandsThatArePayedWaitingForDelivery() {
        try {
            return service.getAllCommandsThatArePayedWaitingForDelivery();
        } catch (Exception exception) {
            return new ArrayList<>();
        }
    }

    @GetMapping(path = "/admin/commands_that_are_payed_and_delivered")
    @Override
    public List<Command> getAllCommandsThatArePayedAndDelivered() {
        try {
            return service.getAllCommandsThatArePayedAndDelivered();
        } catch (Exception exception) {
            return new ArrayList<>();
        }
    }

    @GetMapping(path = "/client/my_commands")
    @Override
    public List<Command> getAllCommandsOfAUser(@AuthenticationPrincipal User user) {
        try {
            return service.getAllCommandsOfAUser(user);
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ArrayList<>();
        }
    }
}
