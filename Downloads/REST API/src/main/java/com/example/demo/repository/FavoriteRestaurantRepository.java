package com.example.demo.repository;

import com.example.demo.model.FavoriteRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@Repository
//@RepositoryRestResource
public interface FavoriteRestaurantRepository extends JpaRepository<FavoriteRestaurant, Long>
{
    @Modifying
    @Query(value = "truncate table favorite_restaurant", nativeQuery = true)
    void truncate();
    @Query(value = "SELECT * from favorite_restaurant where client_id=?#{#id_c} and restaurant_id=?#{#id_r}", nativeQuery = true)
    FavoriteRestaurant findByIdr(Long id_c, Long id_r);
    @Modifying
    @Query(value = "delete from favorite_restaurant where client_id=?#{#id_c} and restaurant_id=?#{#id_r}", nativeQuery = true)
    void deleteByIdr(Long id_c, Long id_r);
    @Query(value = "SELECT * from favorite_restaurant where client_id=?#{#id_c} ", nativeQuery = true)
    List<FavoriteRestaurant> findByIdc(Long id_c);
}