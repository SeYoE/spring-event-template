package com.tangerinetee.springeventtemplate.academy.repository;

import com.tangerinetee.springeventtemplate.academy.model.ReviewCount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewCountJpaRepository extends JpaRepository<ReviewCount, Long> {
}
