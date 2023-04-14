package com.pdl.PDL_Backend.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/user_controller")
@RequiredArgsConstructor
public class UserController implements UserCrud {
    private final UserService userService;

    @PostMapping(path = "/register_client")
    @Override
    public boolean registerAClient(@RequestBody User user) {
        try {
            return userService.registerAClient(user);
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @PostMapping(path = "/login")
    @Override
    public String login(@RequestBody User user) {
        try {
            return userService.login(user);
        } catch (Exception exception) {
            exception.printStackTrace();
            return exception.getLocalizedMessage();
        }
    }

    @GetMapping(path = "/hello")
    public String hello() {
        return "Hello everyone !\nHow are you ?";
    }
}
