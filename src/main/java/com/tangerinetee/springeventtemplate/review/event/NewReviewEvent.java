package com.tangerinetee.springeventtemplate.review.event;

import com.tangerinetee.springeventtemplate.review.model.Review;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NewReviewEvent {

    private final Review review;

    public NewReviewEvent(Review review) {
        this.review = review;
    }

    public long getAcademyId() {
        return review.getAcademyId();
    }

    public Map<String, Boolean> getReviews() {
        return Map.of(
                "kindness", review.isKindness(),
                "goodFacility", review.isGoodFacility(),
                "cheapFee", review.isCheapFee(),
                "goodManagement", review.isGoodManagement());
    }

}
