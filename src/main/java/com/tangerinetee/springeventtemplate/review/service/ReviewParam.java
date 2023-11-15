package com.tangerinetee.springeventtemplate.review.service;

import com.tangerinetee.springeventtemplate.review.model.Review;

public record ReviewParam(
        boolean kindness,
        boolean goodFacility,
        boolean cheapFee,
        boolean goodManagement
) {
    public Review toEntity(long academyId) {
        return new Review(academyId, kindness, goodFacility, cheapFee, goodManagement);
    }
}
