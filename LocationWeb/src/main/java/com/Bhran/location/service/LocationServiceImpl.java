package com.Bhran.location.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bhran.location.entities.Location;
import com.Bhran.location.repos.LocationRepository;

@Service 
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository repository;
	public LocationRepository getRepository() {
		return repository;
	}

	public void setRepository(LocationRepository repository) {
		this.repository = repository;
	}

	@Override
	public Location saveLocation(Location l) {
		return repository.save(l);
	}

	@Override
	public Location updateLocation(Location l) {
		return repository.save(l);
	}

	@Override
	public void deleteLocation(Location l) {
		repository.delete(l);
	}

	@Override
	public Location getLocationById(int id) {
		return repository.getOne(id);
	}

	@Override
	public List<Location> getAllLocation() {
		return repository.findAll();
	}

}
