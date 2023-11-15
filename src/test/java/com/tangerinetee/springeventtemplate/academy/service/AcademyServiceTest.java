package com.tangerinetee.springeventtemplate.academy.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AcademyServiceTest {

    @Autowired
    private AcademyService academyService;

    @Test
    @DisplayName("더미 학원 추가")
    void createAcademy() {
        // Given
        AcademyParam koreanParam = new AcademyParam("국어 학원");
        AcademyParam codingParam = new AcademyParam("코딩 학원");

        // When
        AcademyResult koreanEntity = academyService.createAcademy(koreanParam);
        AcademyResult codingEntity = academyService.createAcademy(codingParam);

        // Then
        System.out.println(koreanEntity);
        System.out.println(codingEntity);
    }

}