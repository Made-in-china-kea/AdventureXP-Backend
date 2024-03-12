package dat3.adventureXP.api;

import dat3.adventureXP.dto.ActivityDto;
import dat3.adventureXP.entity.Activity;
import dat3.adventureXP.repository.ActivityRepository;
import dat3.adventureXP.service.ActivityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    private ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
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
    public ActivityDto getActivityById(@PathVariable Long id) {
        return activityService.getActivityById(id);
    }

    // Update (PUT)
    @PutMapping("/{id}")
    public ActivityDto editActivity(@PathVariable Long id, @RequestBody ActivityDto request) {
        return activityService.editActivity(id, request);
    }

    // Delete (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteActivity(@PathVariable Long id) {
        return activityService.deleteActivity(id);
    }
}

