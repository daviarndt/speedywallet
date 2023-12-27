package com.speedywallet.speedywallet.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    @Query(
            value = "SELECT * FROM users WHERE EMAIL=:login",
            nativeQuery = true
    )
    Optional<UserModel> findByEmailNative(@Param("login") String login);

    Optional<UserModel> findByDocument(String document);

    // Returning UserDetails for Authentication:
    Optional<UserDetails> findByEmail(String login);
}
