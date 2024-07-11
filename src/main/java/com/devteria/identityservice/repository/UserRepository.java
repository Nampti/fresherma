package com.devteria.identityservice.repository;

import com.devteria.identityservice.dto.response.FresherResponse;
import com.devteria.identityservice.entity.Role;
import com.devteria.identityservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
    @Query("SELECT new com.devteria.identityservice.dto.response.FresherResponse(u.id, u.name) FROM User u JOIN Fresher f ON u.id = f.user.id WHERE u.role = :role")
    List<FresherResponse> findAllByRole(Role role);
}
