package com.pdl.PDL_Backend.user;

import com.pdl.PDL_Backend.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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
        user.setRole("ROLE_CLIENT");
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

    @Override
    public boolean registerAnAdmin(User user) throws Exception {
        if (user == null) {
            throw new Exception("User is null !");
        }
        user.setRole("ROLE_ADMIN");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user) != null;
    }

    @Override
    public List<User> loadAllClients() throws Exception {
        return userRepository.getAllUserGroupedByRole("ROLE_CLIENT");
    }

    @Override
    public boolean updateAUser(Long id, User user) throws Exception {
        if (user == null) {
            throw new Exception("User is null !");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User user1 = userRepository.findById(id).orElseThrow(() -> new Exception("The user does not exist !"));
        if (user.getNom().isEmpty() == false && user1.getNom().equals(user1.getNom()) == false) {
            user1.setNom(user.getNom());
        }
        if (user.getPrenom().isEmpty() == false && user1.getPrenom().equals(user1.getPrenom()) == false) {
            user1.setPrenom(user.getPrenom());
        }
        return userRepository.save(user1) != null;
    }
}
