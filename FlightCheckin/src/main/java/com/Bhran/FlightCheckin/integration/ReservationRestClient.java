package com.Bhran.FlightCheckin.integration;

import com.Bhran.FlightCheckin.dto.Reservation;
import com.Bhran.FlightCheckin.dto.ReservationUpdateRequest;

public interface ReservationRestClient {
	
	public Reservation findReservation(Long id);
	
	public Reservation updateReservation(ReservationUpdateRequest request);

}
