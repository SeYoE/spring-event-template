package com.tangerinetee.springeventtemplate.academy.repository;

import com.tangerinetee.springeventtemplate.academy.model.Academy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademyJpaRepository extends JpaRepository<Academy, Long> {
}
