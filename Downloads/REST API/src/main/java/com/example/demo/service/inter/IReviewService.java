package com.example.demo.service.inter;

import com.example.demo.model.Review;

import java.util.List;

public interface IReviewService
{
    public List<Review> findAll();
    public Review findById(Long id);
    Review save(Review review);
    void delete(Review review);

    Double getRate(Long id);

    List<Review> findByIdr(Long id);
}
