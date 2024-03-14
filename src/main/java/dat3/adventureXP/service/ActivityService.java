package dat3.adventureXP.service;


import dat3.adventureXP.dto.ActivityDto;
import dat3.adventureXP.entity.Activity;
import dat3.adventureXP.repository.ActivityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<ActivityDto> getAllActivities() {
        List<Activity> activities = activityRepository.findAll();
        List<ActivityDto> activityResponses = activities.stream().map((a) -> new ActivityDto(a)).toList();
        return activityResponses;
    }

    public ActivityDto getActivityById(Integer id) {
        Activity activity = activityRepository.findById(id).orElseThrow( () -> new
                ResponseStatusException(HttpStatus.NOT_FOUND, "Activity not found"));
        return new ActivityDto(activity);
    }
    public ActivityDto addActivity(ActivityDto request){
        Activity newActivity = new Activity();
        updateActivity(newActivity, request);
        activityRepository.save(newActivity);
        return new ActivityDto(newActivity);
    }

    private void updateActivity(Activity activity, ActivityDto activityDto) {
        activity.setId(activityDto.getId());
        activity.setName(activityDto.getName());
        activity.setAgeLimit(activityDto.getAgeLimit());
        activity.setTimeSlot(activityDto.getTimeSlot());
    }

    public ActivityDto editActivity(Integer id, ActivityDto request) {
        if (request.getId() != id) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You cannot change the id of an existing recipe");
        }
        Activity activity = activityRepository.findById(id).orElseThrow(() -> new
                ResponseStatusException(HttpStatus.NOT_FOUND, "Activity not found"));
        updateActivity(activity, request);
        activityRepository.save(activity);
        return new ActivityDto(activity);
    }

    public ResponseEntity<?> deleteActivity(Integer id) {
        Activity activity = activityRepository.findById(id).orElseThrow(() -> new
                ResponseStatusException(HttpStatus.NOT_FOUND, "Activity not found"));
        activityRepository.delete(activity);
        return ResponseEntity.noContent().build();
    }

}
