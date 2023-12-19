package com.themovietracker.TheMovieTracker.user;

import java.beans.Transient;
import java.util.Collection;

import javax.management.relation.Role;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "User")
public class User implements UserDetails {

    @Transient
    public static final String SEQUENCE_NAME = "SQN_USER";
    private long id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Role role;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.role.getAuthorities();
    }
}