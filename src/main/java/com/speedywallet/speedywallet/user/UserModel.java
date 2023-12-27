package com.speedywallet.speedywallet.user;

import com.speedywallet.speedywallet.user.dto.RequestUserDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Entity(name = "users")
@Table(name = "users")
public class UserModel implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", updatable = false, nullable = false)
    private Long userId;

    @Column(name = "first_name", nullable = false)
    @NotBlank(message = "First Name is mandatory")
    @Size(min = 3)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotBlank(message = "Last Name is mandatory")
    @Size(min = 3)
    private String lastName;

    @Column(name = "document", nullable = false, unique = true)
    @NotBlank(message = "Document is mandatory")
    @Size(min = 11, max = 14)
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

    public Long getUserId() {
        return userId;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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
        this.password = new BCryptPasswordEncoder().encode(password);
        this.userType = userType;
    }

    public UserModel(RequestUserDTO requestUserDTO) {
        this.firstName = requestUserDTO.firstName();
        this.lastName = requestUserDTO.lastName();
        this.document = requestUserDTO.document();
        this.email = requestUserDTO.email();
        this.password = new BCryptPasswordEncoder().encode(requestUserDTO.password());
        this.userType = requestUserDTO.userType();
    }
}
