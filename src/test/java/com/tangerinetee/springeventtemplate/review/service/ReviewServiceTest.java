package com.tangerinetee.springeventtemplate.review.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReviewServiceTest {

    @Autowired
    private ReviewService reviewService;

    @Test
    @DisplayName("리뷰 등록")
    void createReview() {
        // Given
        long academyId = 1L;
        ReviewParam reviewParam = new ReviewParam(true, true, false, true);

        // When
        ReviewResult review = reviewService.createReview(academyId, reviewParam);

        // Then
        System.out.println(review);
    }

}