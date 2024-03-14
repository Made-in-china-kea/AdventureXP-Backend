package dat3.adventureXP.service;

import dat3.adventureXP.dto.ActivityDto;
import dat3.adventureXP.repository.ActivityRepository;

public class ActivityReservation {

    private final ActivityRepository activityRepository;

    public ActivityReservation(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }


}
