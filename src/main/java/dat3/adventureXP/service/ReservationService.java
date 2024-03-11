package dat3.adventureXP.service;

import dat3.adventureXP.repository.ActivityRepository;
import dat3.adventureXP.repository.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ActivityRepository activityRepository;

    public ReservationService(ReservationRepository reservationRepository, ActivityRepository activityRepository) {
        this.reservationRepository = reservationRepository;
        this.activityRepository = activityRepository;
    }

    // Can implement methods for:
    // - Checking activity availability for a specific reservation date and time
    // - Creating a reservation with associated activities (considering availability)
    // - Cancelling a reservation with appropriate logic (e.g., notifying guests)
}
