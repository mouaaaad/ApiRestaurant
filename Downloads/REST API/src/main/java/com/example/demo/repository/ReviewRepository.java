package com.example.demo.repository;

import com.example.demo.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@Repository
//@RepositoryRestResource
public interface ReviewRepository extends JpaRepository<Review, Long>
{
    @Modifying
    @Query(value = "truncate table review", nativeQuery = true)
    void truncate();

    @Query(value = "SELECT avg(rate) from Review where restaurant_id=?#{#id}")
    Double getRate(Long id);
}