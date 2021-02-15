package com.example.demo.repository;

import com.example.demo.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@Repository
//@RepositoryRestResource
public interface RestaurantRepository extends JpaRepository<Restaurant, Long>
{
    @Modifying
    @Query(value = "truncate table restaurant", nativeQuery = true)
    void truncate();

    @Query(value = "SELECT *FROM Restaurant INNER JOIN USER ON Restaurant.manager_id = USER.id where user.email=?#{#email}",nativeQuery = true)
    List<Restaurant> findByManager(String email);

    Restaurant findByName(String name);

    @Query(value = "delete from favorite_restaurant where client_id=?#{#id_c} and restaurant_id=?#{#id_r}", nativeQuery = true)
    void deleteByIdr(Long id_c, Long id_r);

    @Modifying
    @Query(value = "delete from restaurant where restaurant.name=?#{#name}", nativeQuery = true)
    void deletebyname(String name);

    @Query(value = "SELECT * FROM restaurant WHERE created_at=date(NOW()); ",nativeQuery = true)
    List<Restaurant> findByActualite();
}
