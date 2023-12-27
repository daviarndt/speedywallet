package com.speedywallet.speedywallet.User;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity(name = "users")
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "full_name", nullable = false)
    @NotBlank(message = "Full Name is mandatory")
    private String fullName;

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

    @Column(name = "is_active", nullable = false)
    private boolean isActive = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public UserModel(String fullName, String document, String email, String password, UserType userType) {
        this.fullName = fullName;
        this.document = document;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }
}
