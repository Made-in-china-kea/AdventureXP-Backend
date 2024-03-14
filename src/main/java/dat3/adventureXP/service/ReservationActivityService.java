package dat3.adventureXP.service;

import dat3.adventureXP.dto.ReservationActivityDto;
import dat3.adventureXP.entity.ReservationActivity;
import dat3.adventureXP.repository.ReservationActivityRepository;

public class ReservationActivityService {

    private final ReservationActivityRepository reservationActivityRepository;

    public ReservationActivityService(ReservationActivityRepository reservationActivityRepository) {
    this.reservationActivityRepository = reservationActivityRepository;
    }

    // add activity reservation to ReservationActivityRepository
    public ReservationActivity addActivityReservation(ReservationActivityDto request) {
        ReservationActivity newReservationActivity = new ReservationActivity();
        updateReservationActivity(newReservationActivity, request);
        reservationActivityRepository.save(newReservationActivity);
        return newReservationActivity;
        }

    private void updateReservationActivity(ReservationActivity reservationActivity, ReservationActivityDto request) {
        reservationActivity.setReservation(request.getReservation());
        reservationActivity.setActivity(request.getActivity());
        reservationActivity.setStartTime(request.getStartTime());
        reservationActivity.setEndTime(request.getEndTime());
        reservationActivity.setCreated(request.getCreated());

    }
}

