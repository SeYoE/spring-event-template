package com.tangerinetee.springeventtemplate;

public record ReviewPostResponse(
        long reviewId,
        boolean kindness,
        boolean goodFacility,
        boolean cheapFee,
        boolean goodManagement
) {
    public static ReviewPostResponse from(ReviewPostResult result) {
        return new ReviewPostResponse(
                result.reviewId(),
                result.kindness(),
                result.goodFacility(),
                result.cheapFee(),
                result.goodManagement());
    }
}
