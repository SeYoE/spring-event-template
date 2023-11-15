package com.tangerinetee.springeventtemplate.review;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/reviews")
public class ReviewRestController {

    private final ReviewService reviewService;

    public ReviewRestController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ReviewResponse> registerReview(
            @RequestBody final ReviewPostRequest request
    ) {
        ReviewResult result = reviewService.createReview(request);
        ReviewResponse response = ReviewResponse.from(result);

        return ResponseEntity
                .status(CREATED)
                .body(response);
    }

    @GetMapping(path = "/{reviewId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ReviewResponse> getReview(
            @PathVariable final Long reviewId
    ) {
        ReviewResult result = reviewService.findReview(reviewId);
        ReviewResponse response = ReviewResponse.from(result);

        return ResponseEntity
                .status(OK)
                .body(response);
    }

}
