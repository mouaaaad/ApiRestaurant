package com.example.demo.service.impl;

import com.example.demo.model.Review;
import com.example.demo.repository.ReviewRepository;
import com.example.demo.service.inter.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReviewServiceImpl implements IReviewService
{
    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public List<Review> findAll()
    {
        return reviewRepository.findAll();
    }

    @Override
    public Review findById(Long id)
    {
        return reviewRepository.findById(id).get();
    }

    @Override
    public Review save(Review review)
    {
        return reviewRepository.save(review);
    }

    @Override
    public void delete(Review review)
    {
        reviewRepository.delete(review);
    }

    @Override
    public Double getRate(Long id) {
        return reviewRepository.getRate(id);
    }

    @Override
    public List<Review> findByIdr(Long id) {
        return reviewRepository.findByRestaurant_Id(id);
    }
}