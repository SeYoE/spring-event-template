package com.tangerinetee.springeventtemplate.review.service;

import com.tangerinetee.springeventtemplate.review.event.NewReviewEvent;
import com.tangerinetee.springeventtemplate.review.model.Review;
import com.tangerinetee.springeventtemplate.review.repository.ReviewJpaRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ReviewService {

    private final ApplicationEventPublisher eventPublisher;
    private final ReviewJpaRepository reviewJpaRepository;

    public ReviewService(
            ApplicationEventPublisher eventPublisher,
            ReviewJpaRepository reviewJpaRepository
    ) {
        this.eventPublisher = eventPublisher;
        this.reviewJpaRepository = reviewJpaRepository;
    }

    @Transactional
    public ReviewResult createReview(long academyId, ReviewParam param) {
        Review review = param.toEntity(academyId);
        Review save = reviewJpaRepository.save(review);

        NewReviewEvent newReviewEvent = new NewReviewEvent(save);

        eventPublisher.publishEvent(newReviewEvent);

        return ReviewResult.from(save);
    }

}
