package com.tangerinetee.springeventtemplate;

public record ReviewPostResult(
        long reviewId,
        boolean kindness,
        boolean goodFacility,
        boolean cheapFee,
        boolean goodManagement
) {
    public static ReviewPostResult from(Review entity) {
        return new ReviewPostResult(
                entity.getId(),
                entity.isKindness(),
                entity.isGoodFacility(),
                entity.isCheapFee(),
                entity.isGoodManagement());
    }
}
