package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class User implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String username;
    private String email;
    private String password;
    private String profilePhoto;
    private  String type ;
    private Date createdAt;

    public User(Long id, String username, String email, String password, String profilePhoto, Date createdAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.profilePhoto = profilePhoto;
        this.createdAt = createdAt;
    }
}