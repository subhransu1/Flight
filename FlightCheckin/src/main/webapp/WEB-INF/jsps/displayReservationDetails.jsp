<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation Details</title>
</head>
<body>
<pre>
<h2>Flight Details</h2>
Airlines:${reservations.flight.operatingAirlines}<br/>
Flight No:${reservations.flight.flightNumber}<br/>
Departure City:${reservations.flight.departureCity}<br/>
Arrival City:${reservations.flight.arrivalCity}<br/>
Date  :${reservations.flight.dateOfDeparture}<br/>
ESD Time:${reservations.flight.estimatedDepartureTime}<br/>

<h2>Passenger Details</h2>
First Name:${reservations.passenger.first_name}<br/>
Last Name:${reservations.passenger.last_name}<br/>
Mid Name:${reservations.passenger.middle_name}<br/>
Email ID:${reservations.passenger.email}<br/>
Phone No:${reservations.passenger.phone}<br/>
</pre>
<form action="completeCheckin" method="post">

Enter No. of Bags::<input type="text" name="numberOfBags"/>
<input type="hidden" value="${reservations.id}" name="reservationId"/>
<input type="submit" value="checkin"/>

</form>


</body>
</html>