package com.Bhran.FlightCheckin.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.Bhran.FlightCheckin.dto.Reservation;
import com.Bhran.FlightCheckin.dto.ReservationUpdateRequest;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {

	private static final String RESERVATION_REST_URL = "http://localhost:8080/FlightReservation/reservations/";

	@Override
	public Reservation findReservation(Long id) {
		RestTemplate rt=new RestTemplate();
		Reservation reservation = rt.getForObject(RESERVATION_REST_URL+id, Reservation.class);
		return reservation;
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest request) {
		RestTemplate rt=new RestTemplate();
		rt.postForObject(RESERVATION_REST_URL, request, Reservation.class);
		return null;
	}

}
