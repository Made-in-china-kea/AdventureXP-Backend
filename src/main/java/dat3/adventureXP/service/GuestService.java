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

    public Guest createGuest(GuestDto guest) {
        Guest newGuest = new Guest();
        updateGuest(newGuest, guest);
        guestRepository.save(newGuest);
        return newGuest;

    }

    private void updateGuest(Guest guest, GuestDto guestDto) {
        if (guestRepository.existsByEmail(guestDto.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        guest.setFirstName(guestDto.getFirstName());
        guest.setLastName(guestDto.getLastName());
        guest.setEmail(guestDto.getEmail());
    }
}