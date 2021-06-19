package com.Bhran.FlightCheckin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Bhran.FlightCheckin.dto.Reservation;
import com.Bhran.FlightCheckin.dto.ReservationUpdateRequest;
import com.Bhran.FlightCheckin.integration.ReservationRestClient;

@Controller
public class CheckInController {

	@Autowired
	ReservationRestClient rrc;
	@RequestMapping("/showStartCheckin")
	public String showStartCheckin() {
		return "startCheckin";
	}

	@RequestMapping("/startCheckIn")
	public String checkinLogic(@RequestParam("reservationId") Long reservationId,ModelMap modelmap) {
		Reservation reservation = rrc.findReservation(reservationId);
		modelmap.addAttribute("reservations", reservation);
		
		return "displayReservationDetails";
	}
	
	@RequestMapping("/completeCheckin")
	public String completeCheckIn(@RequestParam("reservationId") Long reservationId ,@RequestParam("numberOfBags") int bags) {
		ReservationUpdateRequest rur=new ReservationUpdateRequest();
		rur.setCheckedIn(true);
		rur.setId(reservationId);
		rur.setNumberOfBags(bags);
		
		rrc.updateReservation(rur);
		return "checkInConfirmation";
		
		
	}

}
