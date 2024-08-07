package com.jcode.inventory_control.entities.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Entity
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 6024454717245642172L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String login;

    private String password;

    @Enumerated(EnumType.STRING)
    private Permission permissions;


//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//
//        if (this.permissions == Permission.ADMIN) {
//            return Set.of(
//                    new SimpleGrantedAuthority("ROLE_ADMIN"),
//                    new SimpleGrantedAuthority("ROLE_MANAGER"),
//                    new SimpleGrantedAuthority("ROLE_USER"));
//        } else if (this.permissions == Permission.MANAGER) {
//            return Set.of(
//                    new SimpleGrantedAuthority("ROLE_MANAGER"),
//                    new SimpleGrantedAuthority("ROLE_USER"));
//        }
//        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
//    }
//
//    @Override
//    public String getUsername() {
//        return this.login;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}
