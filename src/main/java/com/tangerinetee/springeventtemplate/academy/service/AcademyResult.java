package com.tangerinetee.springeventtemplate.academy.service;

import com.tangerinetee.springeventtemplate.academy.model.Academy;

public record AcademyResult(
        long academyId,
        String academyName
) {
    public static AcademyResult from(Academy save) {
        return new AcademyResult(save.getId(), save.getAcademyName());
    }
}
