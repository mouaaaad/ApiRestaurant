package com.example.demo.repository;

import com.example.demo.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@Repository
//@RepositoryRestResource
public interface MealRepository extends JpaRepository<Meal, Long>
{
    @Modifying
    @Query(value = "truncate table meal", nativeQuery = true)
    void truncate();

    @Query(value = "SELECT * FROM Meal INNER JOIN Restaurant  ON  Restaurant.id = meal.restaurant_id where Restaurant.name=?#{#name}",nativeQuery = true)
    List<Meal> findByRestaurant(String name);
}
