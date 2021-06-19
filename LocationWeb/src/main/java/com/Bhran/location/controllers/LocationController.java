package com.Bhran.location.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Bhran.location.entities.Location;
import com.Bhran.location.repos.LocationRepository;
import com.Bhran.location.service.LocationService;
import com.Bhran.location.utilities.EmailUtil;
import com.Bhran.location.utilities.ReportUtil;

@Controller
public class LocationController {

	@Autowired
	LocationService service;
	@Autowired
	LocationRepository repo;
	@Autowired
	EmailUtil emailutil;
	@Autowired
	ReportUtil reportutil;
	@Autowired
	ServletContext sc;
	
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "CreateLocation";
	}
	
	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute() Location loc,ModelMap modelmap) {
		Location saveLocation = service.saveLocation(loc);
		String msg="Location saved with id:"+saveLocation.getId();
		modelmap.addAttribute("msgs", msg);
		//emailutil.sendEmail("javapractice18@gmail.com","LocationWeb", "Location added successfully to Database");
		return "CreateLocation";
	}
	
	@RequestMapping("/displaylocations")
	public String displayLocation(ModelMap modelmap) {
		List<Location> location = service.getAllLocation();
		modelmap.addAttribute("locations",location);
		return "displayLocation";
	}
	
	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam() int id,ModelMap modelmap) {
		Location locationById = service.getLocationById(id);
		service.deleteLocation(locationById);
		/*Location loc=new Location();
		loc.setId(id);
		service.deleteLocation(loc);*/
		
		List<Location> locations = service.getAllLocation();
		modelmap.addAttribute("locations",locations);
		return "displayLocation";
	}
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam() int id,ModelMap modelmap) {
		
		Location location = service.getLocationById(id);
		modelmap.addAttribute("loc", location);
		return "editLocation";
	}
	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute() Location loc,ModelMap modelmap) {
		
		service.updateLocation(loc);
		List<Location> allLocation = service.getAllLocation();
		modelmap.addAttribute("locations", allLocation);
		return "displayLocation";
	}
	
	/*
	@RequestMapping("/generateReport")
	public String generateReport() {
		
		String path = sc.getRealPath("/");
		List<Object[]> data = repo.findTypeAndTypeCount();
		reportutil.generatePieChart(path, data);
		return "Report";
		
	}*/
} 
