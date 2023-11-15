package com.tangerinetee.springeventtemplate.review.service;

import com.tangerinetee.springeventtemplate.review.model.Review;
import com.tangerinetee.springeventtemplate.review.repository.ReviewJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ReviewService {

    private final ReviewJpaRepository reviewJpaRepository;

    public ReviewService(ReviewJpaRepository reviewJpaRepository) {
        this.reviewJpaRepository = reviewJpaRepository;
    }

    @Transactional
    public ReviewResult createReview(ReviewParam param) {
        Review review = param.toEntity();
        Review save = reviewJpaRepository.save(review);

        return ReviewResult.from(save);
    }

}
