package com.example.demo.controller;

import com.example.demo.model.Review;
import com.example.demo.service.inter.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ReviewRestController
{
    @Autowired
    IReviewService reviewService;

    @GetMapping("/reviews")
    public List<Review> findAll()
    {
        return reviewService.findAll();
    }

    @GetMapping("/reviews/{id}")
    public Review findById(@PathVariable Long id)
    {
        return reviewService.findById(id);
    }

    @GetMapping("/reviews/{id}/rate")
    public Double getRate(@PathVariable Long id)
    {
        return reviewService.getRate(id);
    }

    @PostMapping("/reviews/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Review newReview(@RequestBody Review review)
    {
        return reviewService.save(review);
    }

    @PutMapping("/reviews/edit")
    @ResponseStatus(value = HttpStatus.OK, reason = "rate updated successfully")
    public Review editReview(@RequestBody Review review)
    {
        return reviewService.save(review);
    }

    @DeleteMapping("/reviews/delete")
    @ResponseStatus(value = HttpStatus.OK, reason = "rate deleted successfully")
    public void deleteReview(@RequestBody Review review)
    {
        reviewService.delete(review);
    }
}