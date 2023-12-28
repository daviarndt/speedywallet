package com.speedywallet.speedywallet.user;

import com.speedywallet.speedywallet.user.dto.RequestUserDTO;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    EntityManager entityManager;

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName(value = "Should successfully get User from database")
    void findByEmailNativeSuccess() {
        String email = "test-email@gmail.com";

        var userDto = new RequestUserDTO(
                "TestName", "TestLastName", "01010101001", email, "87654321", UserType.SHOPKEEPER
        );
        createUser(userDto);

        Optional<UserModel> userFound = userRepository.findByEmailNative(email);
        assertThat(userFound.isPresent()).isTrue();
    }

    @Test
    @DisplayName(value = "Shouldn't get User from database because it won't exists")
    void findByEmailNativeEmpty() {
        String email = "test-email@gmail.com";

        Optional<UserModel> userFound = userRepository.findByEmailNative(email);
        assertThat(userFound.isEmpty()).isTrue();
    }

    @Test
    @DisplayName(value = "Should successfully get User from database")
    void findByDocumentSuccess() {
        String document = "11111111111";
        var userDto = new RequestUserDTO(
                "TestName", "TestLastName", document, "test@gmail.com", "12345678", UserType.COMMON
        );
        createUser(userDto);

        Optional<UserModel> userFound = userRepository.findByDocument(document);
        assertThat(userFound.isPresent()).isTrue();
    }

    @Test
    @DisplayName(value = "Shouldn't get User from database because it won't exists")
    void findByDocumentEmpty() {
        String document = "11111111111";

        Optional<UserModel> userFound = userRepository.findByDocument(document);
        assertThat(userFound.isEmpty()).isTrue();
    }

    private void createUser(RequestUserDTO userDTO) {
        var user = new UserModel(userDTO);
        entityManager.persist(user);
    }
}