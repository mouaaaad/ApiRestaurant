package com.example.demo.controller;

import com.example.demo.model.Meal;
import com.example.demo.model.Review;
import com.example.demo.repository.MealRepository;
import com.example.demo.repository.ReviewRepository;
import com.example.demo.service.inter.IAppInitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReviewRestControllerTest
{
    @Autowired
    IAppInitService appInitService;

    @Autowired
    ReviewRestController reviewRestController;

    @Autowired
    ReviewRepository reviewRepository;

    @Test
    void findAll()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        assertEquals(reviewRepository.count(), reviewRestController.findAll().size());
    }

    @Test
    void findAllIsNotEmpty()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        assertFalse(reviewRestController.findAll().isEmpty());
    }

    @Test
    void findById()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        assertAll(
                () -> assertEquals(reviewRepository.findById(1L).get().getId(), reviewRestController.findById(1L).getId()),
                () -> assertEquals(reviewRepository.findById(1L).get().getRate(), reviewRestController.findById(1L).getRate()),
                () -> assertEquals(reviewRepository.findById(1L).get().getComment(), reviewRestController.findById(1L).getComment()),
                () -> assertEquals(reviewRepository.findById(1L).get().getCreatedAt(), reviewRestController.findById(1L).getCreatedAt())
        );
    }

    @Test
    void newReview()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        Review review = new Review();
        review.setRate(5);
        review.setComment("TOOOP");
        assertAll(
                () -> assertEquals(review.getRate(), reviewRestController.newReview(review).getRate()),
                () -> assertEquals(review.getComment(), reviewRestController.newReview(review).getComment())
        );
    }

    @Test
    void editReview()
    {
        appInitService.deleteAllData();
        appInitService.insertAllData();
        Review review = new Review();
        review.setId(1L);
        review.setRate(1);
        review.setComment("NUUUL");
        assertAll(
                () -> assertEquals(review.getRate(), reviewRestController.editReview(review).getRate()),
                () -> assertEquals(review.getComment(), reviewRestController.editReview(review).getComment())
        );
    }
}