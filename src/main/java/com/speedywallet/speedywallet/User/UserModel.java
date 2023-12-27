package com.speedywallet.speedywallet.User;

import com.speedywallet.speedywallet.User.DTO.RequestUserDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity(name = "users")
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false)
    @NotBlank(message = "First Name is mandatory")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotBlank(message = "Last Name is mandatory")
    private String lastName;

    @Column(name = "document", nullable = false, unique = true)
    @NotBlank(message = "Document is mandatory")
    private String document;

    @Column(name = "email", nullable = false, unique = true)
    @NotBlank(message = "Email is mandatory")
    private String email;

    @Column(name = "password", nullable = false)
    @NotBlank(message = "Password is mandatory")
    @Size(min = 8)
    private String password;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance = BigDecimal.valueOf(0);

    @Column(name = "is_active", nullable = false)
    private boolean isActive = true;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public UserModel() {
    }

    public UserModel(String firstName, String lastName, String document, String email, String password, UserType userType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public UserModel(RequestUserDTO requestUserDTO) {
        this.firstName = requestUserDTO.firstName();
        this.lastName = requestUserDTO.lastName();
        this.document = requestUserDTO.document();
        this.email = requestUserDTO.email();
        this.password = requestUserDTO.password();
        this.userType = requestUserDTO.userType();
    }
}
