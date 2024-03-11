package dat3.adventureXP.service;

import dat3.adventureXP.repository.GuestRepository;
import org.springframework.stereotype.Service;

@Service
public class GuestService {

    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    // Can implement methods for:
    // - Guest search functionality based on name or email
}