package com.tangerinetee.springeventtemplate.academy.model;

import static lombok.AccessLevel.PROTECTED;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Map;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Entity
@Table(name = "review_counts")
public class ReviewCount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academyId")
    private Academy academy;

    @Column(name = "kindness_count", nullable = false)
    private long kindnessCount;

    @Column(name = "good_facility_count", nullable = false)
    private long goodFacilityCount;

    @Column(name = "cheap_fee_count", nullable = false)
    private long cheapFeeCount;

    @Column(name = "good_management_count", nullable = false)
    private long goodManagementCount;

    public ReviewCount(Academy academy) {
        this.academy = academy;
        this.kindnessCount = 0;
        this.goodFacilityCount = 0;
        this.cheapFeeCount = 0;
        this.goodManagementCount = 0;
    }

    public ReviewCount addReview(Map<String, Boolean> reviews) {
        this.kindnessCount += reviews.get("kindness") ? 1 : 0;
        this.goodFacilityCount += reviews.get("goodFacility") ? 1 : 0;
        this.cheapFeeCount += reviews.get("cheapFee") ? 1 : 0;
        this.goodManagementCount += reviews.get("goodManagement") ? 1 : 0;
        return this;
    }

}
