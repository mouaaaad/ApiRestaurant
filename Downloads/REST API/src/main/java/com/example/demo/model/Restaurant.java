package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String picture;
    private String phone;
    private Double latitude;
    private Double longitude;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @ManyToOne
    private City city;
    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern="HH:mm")
    private Date openingTime;
    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern="HH:mm")
    private Date closingTime;
    @ManyToOne//(fetch = FetchType.LAZY)
    private RestaurantCategory restaurantCategory;
    @ManyToOne//(fetch = FetchType.LAZY)
    private Manager manager;
    @OneToMany(mappedBy = "restaurant", cascade = {CascadeType.ALL})
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Meal> meals;
    @OneToMany(mappedBy = "restaurant", cascade = {CascadeType.ALL})
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<FavoriteRestaurant> favoriteRestaurants;
}