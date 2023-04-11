package com.crud.users.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@ToString @EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue
    @Getter @Setter @Column(name="user_id")
    private Long id;

    @Getter @Setter @Column(name="name")
    private String name;

    @Getter @Setter @Column(name="last_name")
    private String lastName;

    @Getter @Setter @Column(name="email")
    private String email;

    @Getter @Setter @Column(name="phone")
    private String phone;

    @Getter @Setter @Column(name="password")
    private String password;
}
