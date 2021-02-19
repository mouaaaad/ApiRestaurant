package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.model.Comment;
import com.example.demo.repository.CityRepository;
import com.example.demo.repository.CommentRepository;
import com.example.demo.service.inter.IAppInitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentRestControllerTest
{
    @Autowired
    IAppInitService appInitService;

    @Autowired
    CommentRestController commentRestController;

    @Autowired
    CommentRepository commentRepository;

    @Test
    void findAll()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        assertFalse(commentRestController.findAll().isEmpty());
    }

    @Test
    void findAllIsNotEmpty()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        assertFalse(commentRestController.findAll().isEmpty());
    }

    @Test
    void findById()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        assertAll(
                () -> assertEquals(commentRepository.findById(1L).get().getId(), commentRestController.findById(1L).getId()),
                () -> assertEquals(commentRepository.findById(1L).get().getComment(), commentRestController.findById(1L).getComment()),
                () -> assertEquals(commentRepository.findById(1L).get().getCreatedAt(), commentRestController.findById(1L).getCreatedAt())
        );
    }

    @Test
    void newComment()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        Comment comment = new Comment();
        comment.setComment("SALAM");
        assertEquals(comment.getComment(), commentRestController.newComment(comment).getComment());
    }

    @Test
    void editComment()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        Comment comment = new Comment();
        comment.setId(1L);
        comment.setComment("A BIENTOT");
        assertEquals(comment.getComment(), commentRestController.editComment(comment).getComment());
    }
}