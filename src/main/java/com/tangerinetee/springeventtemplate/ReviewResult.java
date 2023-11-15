package com.tangerinetee.springeventtemplate;

public record ReviewResult(
        long reviewId,
        boolean kindness,
        boolean goodFacility,
        boolean cheapFee,
        boolean goodManagement
) {
    public static ReviewResult from(Review entity) {
        return new ReviewResult(
                entity.getId(),
                entity.isKindness(),
                entity.isGoodFacility(),
                entity.isCheapFee(),
                entity.isGoodManagement());
    }
}
