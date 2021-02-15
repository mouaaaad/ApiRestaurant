package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client extends User implements Serializable
{
    @OneToMany(mappedBy = "client", cascade = {CascadeType.ALL})
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<FavoriteRestaurant> favoriteRestaurants;

    public Client(Long id, String username, String email, String password, String tel,String city,String address, String address2, String profilePhoto, String type,Date createdAt)
    {
        super(id, username, email, password,   tel, city, address,  address2 , profilePhoto,type, createdAt);
    }
}