package com.tangerinetee.springeventtemplate.review;

public record ReviewPostRequest(
        Boolean kindness,
        Boolean goodFacility,
        Boolean cheapFee,
        Boolean goodManagement
) {
    public Review toEntity() {
        return new Review(kindness, goodFacility, cheapFee, goodManagement);
    }
}
