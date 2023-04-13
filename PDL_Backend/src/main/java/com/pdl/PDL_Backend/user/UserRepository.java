package com.pdl.PDL_Backend.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);

    @Query("select u from User u  where u.role=:role")
    List<User> getAllUserGroupedByRole(UserRole role);
}
