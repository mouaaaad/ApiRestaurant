package com.example.demo.repository;

import com.example.demo.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@Repository
//@RepositoryRestResource
public interface CommentRepository extends JpaRepository<Comment, Long>
{
    @Modifying
    @Query(value = "truncate table comment", nativeQuery = true)
    void truncate();
}
