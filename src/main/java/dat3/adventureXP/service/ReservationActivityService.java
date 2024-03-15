package dat3.adventureXP.service;

import dat3.adventureXP.dto.ReservationActivityDto;
import dat3.adventureXP.entity.ReservationActivity;
import dat3.adventureXP.repository.ReservationActivityRepository;

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
        reservationActivity.setReservationId(request.getReservationId());
        reservationActivity.setActivity(request.getActivity());
        reservationActivity.setDate(request.getDate());
        reservationActivity.setStartTime(request.getStartTime());
        reservationActivity.setReservedSlots(request.getReservedSlots());
        reservationActivity.setEndTime(request.getEndTime());
        reservationActivity.setCreated(request.getCreated());
    }
}

