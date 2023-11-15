package com.tangerinetee.springeventtemplate;

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
