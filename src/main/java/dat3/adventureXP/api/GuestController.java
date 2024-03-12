package dat3.adventureXP.api;

import dat3.adventureXP.entity.Guest;
import dat3.adventureXP.repository.GuestRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
public class GuestController {

    private final GuestRepository guestRepository;

    public GuestController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    // Similar CRUD operations as in ActivityController (adjust for Guest entity)
    // Read All (GET)
    @GetMapping
    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }
}