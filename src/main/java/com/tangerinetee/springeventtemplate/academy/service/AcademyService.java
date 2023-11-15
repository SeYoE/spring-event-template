package com.tangerinetee.springeventtemplate.academy.service;

import com.tangerinetee.springeventtemplate.academy.model.Academy;
import com.tangerinetee.springeventtemplate.academy.model.ReviewCount;
import com.tangerinetee.springeventtemplate.academy.repository.AcademyJpaRepository;
import com.tangerinetee.springeventtemplate.academy.repository.ReviewCountJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AcademyService {

    private final AcademyJpaRepository academyJpaRepository;
    private final ReviewCountJpaRepository reviewCountJpaRepository;

    public AcademyService(AcademyJpaRepository academyJpaRepository, ReviewCountJpaRepository reviewCountJpaRepository) {
        this.academyJpaRepository = academyJpaRepository;
        this.reviewCountJpaRepository = reviewCountJpaRepository;
    }

    @Transactional
    public AcademyResult createAcademy(AcademyParam param) {
        Academy academy = param.toEntity();
        Academy savedAcademy = academyJpaRepository.save(academy);

        ReviewCount reviewCount = new ReviewCount(savedAcademy);
        reviewCountJpaRepository.save(reviewCount);

        return AcademyResult.from(savedAcademy);
    }
}
