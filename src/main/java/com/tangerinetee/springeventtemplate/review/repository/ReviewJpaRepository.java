package com.tangerinetee.springeventtemplate.review.repository;

import com.tangerinetee.springeventtemplate.review.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewJpaRepository extends JpaRepository<Review, Long> {
}
