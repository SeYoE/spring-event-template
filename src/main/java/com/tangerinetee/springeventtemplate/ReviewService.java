package com.tangerinetee.springeventtemplate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ReviewService {

    private final ReviewJpaRepository reviewJpaRepository;

    public ReviewService(ReviewJpaRepository reviewJpaRepository) {
        this.reviewJpaRepository = reviewJpaRepository;
    }

    public ReviewPostResult createReview(ReviewPostRequest request) {
        Review review = request.toEntity();
        Review save = reviewJpaRepository.save(review);

        return ReviewPostResult.from(save);
    }
}
