package com.tangerinetee.springeventtemplate.review.model;

import static lombok.AccessLevel.PROTECTED;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "academy_id", nullable = false)
    private Long academyId;

    @Column(name = "kindness", nullable = false)
    private boolean kindness;

    @Column(name = "good_facility", nullable = false)
    private boolean goodFacility;

    @Column(name = "cheap_fee", nullable = false)
    private boolean cheapFee;

    @Column(name = "good_managment", nullable = false)
    private boolean goodManagement;

    public Review(Long academyId, boolean kindness, boolean goodFacility, boolean cheapFee, boolean goodManagement) {
        this.academyId = academyId;
        this.kindness = kindness;
        this.goodFacility = goodFacility;
        this.cheapFee = cheapFee;
        this.goodManagement = goodManagement;
    }

}
