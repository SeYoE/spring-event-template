package com.tangerinetee.springeventtemplate.academy.event;

import com.tangerinetee.springeventtemplate.academy.service.AcademyService;
import com.tangerinetee.springeventtemplate.review.event.NewReviewEvent;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NewReviewEventListener {

    private final AcademyService academyService;

    public NewReviewEventListener(AcademyService academyService) {
        this.academyService = academyService;
    }

    @EventListener
    public void sendPush(NewReviewEvent event) {
        long academyId = event.getAcademyId();
        Map<String, Boolean> reviews = event.getReviews();

        academyService.updateReviewCount(academyId, reviews);
    }

}
