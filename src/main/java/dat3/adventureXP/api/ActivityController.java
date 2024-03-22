package dat3.adventureXP.api;

import dat3.adventureXP.dto.ActivityDto;
import dat3.adventureXP.service.ActivityService;
import dat3.adventureXP.service.ReservationActivityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    private final ActivityService activityService;

    private final ReservationActivityService reservationActivityService;

    public ActivityController(ActivityService activityService, ReservationActivityService reservationActivityService) {

        this.activityService = activityService;
        this.reservationActivityService = reservationActivityService;
    }

    // Create (POST)
    @PostMapping
    public ActivityDto addActivity(@RequestBody ActivityDto request) {
        return activityService.addActivity(request);
    }

    // Read All (GET)
    @GetMapping
    public List<ActivityDto> getAllActivities() {
        return activityService.getAllActivities();
    }

    // Read by ID (GET)
    @GetMapping("/{id}")
    public ActivityDto getActivityById(@PathVariable int id) {
        return activityService.getActivityById(id);
    }

    // Update (PUT)
    @PutMapping("/{id}")
    public ActivityDto editActivity(@PathVariable int id, @RequestBody ActivityDto request) {
        return activityService.editActivity(id, request);
    }

    // Delete (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteActivity(@PathVariable int id) {
        return activityService.deleteActivity(id);
    }

    // get available slots for an activity
    @GetMapping("/{id}/availableslots")
    public List<Integer> getAvailableSlots(@RequestParam(required = false) LocalDate date, @PathVariable int id) {
        return reservationActivityService.getAvailableSpots(date, id);
    }
}

