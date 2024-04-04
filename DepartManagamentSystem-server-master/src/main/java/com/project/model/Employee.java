package com.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    @NotBlank(message = "please Enter your name")
    private String name;

    @Email
    @Column(unique = true)
    @NotEmpty
    private String email;
    @NotBlank(message = "please Enter your password")
    @NotEmpty
    private  String password;
    @NotBlank(message = "please select your gender")
    @NotEmpty
   // private String gender;
   @NotBlank(message = "Not empty")
    @NotEmpty
    private String department;
    @NotEmpty
    private  String salary;
    @NotBlank(message = "please enter your city")
    @NotEmpty
    private String city;
    @NotBlank(message = "please enter your role")
    @NotEmpty
    private  String role;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      return   List.of(new SimpleGrantedAuthority(getRole()));
    }

    @Override
    public String getUsername() {
        return getEmail();
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
}
