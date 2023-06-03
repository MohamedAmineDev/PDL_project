package com.pdl.PDL_Backend;

import com.pdl.PDL_Backend.user.User;
import com.pdl.PDL_Backend.user.UserRepository;
import com.pdl.PDL_Backend.user.UserRole;
import com.pdl.PDL_Backend.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PdlBackendApplication {
    //TODO Create unit tests for each controller
    public static void main(String[] args) {
        SpringApplication.run(PdlBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunnerUserDetails(UserService userService, UserRepository userRepository) {
        return args -> {
            /*accountService.addNewRole("USER");
            accountService.addNewRole("ADMIN");
            accountService.addNewUser("user1", "123", "user1@gmail.com", "123");
            accountService.addNewUser("user2", "123", "user2@gmail.com", "123");
            accountService.addNewUser("user3", "123", "user3@gmail.com", "123");
            accountService.addNewUser("admin", "123", "admin@gmail.com", "123");
            accountService.addRoleToUser("user1", "USER");
            accountService.addRoleToUser("user2", "USER");
            accountService.addRoleToUser("user3", "USER");
            accountService.addRoleToUser("admin", "USER");
            accountService.addRoleToUser("admin", "ADMIN");
             */
            //accountService.addNewRole("CLIENT");
            User user = new User();
            user.setPrenom("Ali");
            user.setNom("Ali");
            user.setEmail("ali@gmail.com");
            user.setRole(UserRole.ADMIN_ROLE.name());
            user.setPassword("mmm");
            var found=userRepository.findByEmail(user.getEmail());
            if(found==null){
                userService.registerAnAdmin(user);
            }
        };
    }
}
