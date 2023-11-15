package com.tangerinetee.springeventtemplate;

public record ReviewResponse(
        long reviewId,
        boolean kindness,
        boolean goodFacility,
        boolean cheapFee,
        boolean goodManagement
) {
    public static ReviewResponse from(ReviewResult result) {
        return new ReviewResponse(
                result.reviewId(),
                result.kindness(),
                result.goodFacility(),
                result.cheapFee(),
                result.goodManagement());
    }
}
