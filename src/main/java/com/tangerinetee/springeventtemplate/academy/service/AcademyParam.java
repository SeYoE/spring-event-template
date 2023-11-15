package com.tangerinetee.springeventtemplate.academy.service;

import com.tangerinetee.springeventtemplate.academy.model.Academy;

public record AcademyParam(
        String academyName
) {
    public Academy toEntity() {
        return new Academy(academyName);
    }
}
