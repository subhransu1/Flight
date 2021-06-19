package com.Bhran.location.service;

import java.util.List;
import java.util.Optional;

import com.Bhran.location.entities.Location;

public interface LocationService {
	Location saveLocation(Location l);

	Location updateLocation(Location l);

	void deleteLocation(Location locationById);

	Location getLocationById(int id);

	List<Location> getAllLocation();
}
