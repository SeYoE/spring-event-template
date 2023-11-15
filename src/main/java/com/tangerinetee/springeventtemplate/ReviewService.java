package com.tangerinetee.springeventtemplate;

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
    public ReviewResult createReview(ReviewPostRequest request) {
        Review review = request.toEntity();
        Review save = reviewJpaRepository.save(review);

        return ReviewResult.from(save);
    }

    public ReviewResult findReview(Long reviewId) {
        Review review = reviewJpaRepository.findById(reviewId)
                .orElseThrow(() -> new EntityNotFoundException("리뷰 없졍"));

        return ReviewResult.from(review);
    }
}
