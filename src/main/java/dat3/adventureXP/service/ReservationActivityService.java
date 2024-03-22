package dat3.adventureXP.service;

import dat3.adventureXP.dto.ReservationActivityDto;
import dat3.adventureXP.entity.ReservationActivity;
import dat3.adventureXP.repository.ReservationActivityRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
public class ReservationActivityService {

    private final ReservationActivityRepository reservationActivityRepository;

    public ReservationActivityService(ReservationActivityRepository reservationActivityRepository) {
        this.reservationActivityRepository = reservationActivityRepository;
    }

    // add activity reservation to ReservationActivityRepository and return the new ReservationActivity record
    public ReservationActivity addActivityReservation(ReservationActivityDto request) {
        ReservationActivity newReservationActivity = new ReservationActivity();
        updateReservationActivity(newReservationActivity, request);
        reservationActivityRepository.save(newReservationActivity);
        return newReservationActivity;
    }


        // updates the object with the new values from the request
    private void updateReservationActivity(ReservationActivity reservationActivity, ReservationActivityDto request) {
        reservationActivity.setReservation(request.getReservation());
        reservationActivity.setActivity(request.getActivity());
        reservationActivity.setStartTime(request.getStartTime());
        reservationActivity.setReservedSlots(request.getReservedSlots());
        reservationActivity.setCreated(LocalDateTime.now());
    }

    public List<Integer> getAvailableSpots(String date, Integer activityId) {
        List<ReservationActivity> reservedActivities = reservationActivityRepository.getReservationActivityByActivity_IdAndReservation_ReservationDate(activityId, date);

        List<Integer> availableSlots = new ArrayList<>();
        int closingTime = 2200; // 10 PM

        // Initial availableStartTime based on opening hours (replace if needed)
        int availableStartTime = 800; // 8 AM

        for (ReservationActivity reservedActivity : reservedActivities) {
            int startTime = reservedActivity.getStartTime();
            int endTime = startTime + (reservedActivity.getActivity().getTimeSlot() * reservedActivity.getReservedSlots()); // Assuming time slot represents duration

            // Ensure endTime is within a valid range during a day. Returns the smaller of two values
            endTime = Math.min(endTime, closingTime);

            // Update availableStartTime considering previous activities and closing time
            availableStartTime = Math.max(availableStartTime, endTime); // Skip overlapping times
        }

        // Add available start times within business hours
        while (availableStartTime <= closingTime) {
            availableSlots.add(availableStartTime);
            availableStartTime += 100; // Add 1 hour for the next slot
        }

        System.out.println("Available slots: " + availableSlots);

        return availableSlots;
    }
}

