package dat3.adventureXP.service;

import dat3.adventureXP.dto.GuestDto;
import dat3.adventureXP.entity.Guest;
import dat3.adventureXP.repository.GuestRepository;
import org.springframework.stereotype.Service;

@Service
public class GuestService {

    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public GuestDto createGuest(GuestDto guest) {
        Guest newGuest = new Guest();
        updateGuest(newGuest, guest);
        guestRepository.save(newGuest);
        return new GuestDto(newGuest);

    }

    private void updateGuest(Guest guest, GuestDto guestDto) {
        guest.setId(guestDto.getId());
        guest.setFirstName(guestDto.getFirstName());
        guest.setLastName(guestDto.getLastName());
        guest.setPhoneNumber(guestDto.getPhoneNumber());
        guest.setEmail(guestDto.getEmail());
    }

    // Can implement methods for:
    // - Guest search functionality based on name or email
}