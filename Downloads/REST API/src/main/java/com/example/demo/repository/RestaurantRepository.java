package com.example.demo.repository;

import com.example.demo.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@Repository
//@RepositoryRestResource
public interface RestaurantRepository extends JpaRepository<Restaurant, Long>
{
    @Modifying
    @Query(value = "truncate table restaurant", nativeQuery = true)
    void truncate();

    @Query(value = "SELECT *FROM Restaurant INNER JOIN USER ON Restaurant.manager_id = USER.id where user.email=?#{#email}",nativeQuery = true)
    Restaurant findByManager(String email);


}
