package com.theyardapp.auth.user;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;
import java.util.List;
import java.util.Set;

@Data
@Builder
// @NoArgsConstructor
@AllArgsConstructor
@Document(collection = "auth-col") 
public class User implements UserDetails {

    @Id
    private String userId;
    private String email;
    private String firstname;
    private String lastname;
    private String username;
    // private String ip;
    private String password; 
    private Set<Role> roles = new HashSet<>();

    public User() {
        this.userId = UUID.randomUUID().toString();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.userId.toString()));
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