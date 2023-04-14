package com.pdl.PDL_Backend.user;

import com.pdl.PDL_Backend.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserCrud {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public boolean registerAClient(User user) throws Exception {
        if (user == null) {
            throw new Exception("User is null !");
        }
        user.setRole(UserRole.CLIENT_ROLE);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user) != null;
    }

    @Override
    public String login(User user) throws Exception {
        if (user == null) {
            throw new Exception("User is null !");
        }
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
        );
        var foundUser = userRepository.findByEmail(user.getEmail()).orElseThrow();
        return jwtService.generateToken(user);
    }
}
