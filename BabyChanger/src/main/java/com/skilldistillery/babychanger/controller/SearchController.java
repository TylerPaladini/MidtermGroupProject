package com.skilldistillery.babychanger.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.babychanger.data.LocationDAO;
import com.skilldistillery.babychanger.data.RestroomDAO;
import com.skilldistillery.babychanger.data.UsersDAO;
import com.skilldistillery.babychanger.entities.Location;
import com.skilldistillery.babychanger.entities.Restroom;

@Controller
public class SearchController {
	
	@Autowired
	private LocationDAO locationDAO; 
	@Autowired
	private RestroomDAO restroomDAO;
	@Autowired
	private UsersDAO userDAO;
	
	@RequestMapping(path = "home.do", method = RequestMethod.GET)
	public String index() {
		return "home";
	}

//	@RequestMapping(path = "getBathrooms.do", method = RequestMethod.GET)
//	  public ModelAndView getLocationById(@RequestParam("id") int id) {
//	    ModelAndView mv = new ModelAndView();
//	    Location location = locationDAO.getLocationById(id);    
//	    mv.addObject("location", location);
//	    mv.setViewName("results");
//	    return mv;
//	  }
	
//	@RequestMapping(path = "getLocationsByCity.do", method = RequestMethod.GET)
//	public ModelAndView getLocationsByCity(@RequestParam("city") String city) {
//		ModelAndView mv = new ModelAndView();
//		List<Location> location = locationDAO.getLocationsByCity(city);    
//		mv.addObject("location", location);
//		mv.setViewName("results");
//		return mv;
//	}
	
//	@RequestMapping(path = "getLocationsByState.do", method = RequestMethod.GET)
//	public ModelAndView getLocationsByState(@RequestParam("state") String state) {
//		ModelAndView mv = new ModelAndView();
//		List<Location> location = locationDAO.getLocationsByState(state);    
//		mv.addObject("location", location);
//		mv.setViewName("results");
//		return mv;
//	}
	
	@RequestMapping(path = "getLocationsByKeywordSearch.do", method = RequestMethod.GET)
	public ModelAndView getLocationsByKeyword(@RequestParam("keyword") String keyword) {
		ModelAndView mv = new ModelAndView();
		Set<Location> location = locationDAO.getLocationsByKeyword(keyword);    
		mv.addObject("allKeywords", location);
		mv.setViewName("results");
		return mv;
	}
	
//	@RequestMapping(path = "getLocationLikeAddress.do", method = RequestMethod.GET)
//	public ModelAndView getLocationLikeAddress(@RequestParam("addressLike") String addressLike) {
//		ModelAndView mv = new ModelAndView();
//		List<Location> location = locationDAO.getLocationsLikeAddress(addressLike);    
//		mv.addObject("location", location);
//		mv.setViewName("results");
//		return mv;
//	}
	
//	@RequestMapping(path = "getLocationByGender.do", method = RequestMethod.GET)
//	public ModelAndView getLocationByGender(@RequestParam("addressLike") Gender gender) {
//		ModelAndView mv = new ModelAndView();
//		List<Location> location = locationDAO.getLocationsByGender(gender);    
//		mv.addObject("location", location);
//		mv.setViewName("results");
//		return mv;
//	}
	
//	@RequestMapping(path = "getLocationByName.do", method = RequestMethod.GET)
//	public ModelAndView getLocationByName(@RequestParam("name") String name) {
//		ModelAndView mv = new ModelAndView();
//		List<Location> location = locationDAO.getLocationsByName(name);    
//		mv.addObject("location", location);
//		mv.setViewName("results");
//		return mv;
//	}
	
//	@RequestMapping(path = "getLocationByZipCode.do", method = RequestMethod.GET)
//	public ModelAndView getLocationByZipCode(@RequestParam("zipCode") String zipCode) {
//		ModelAndView mv = new ModelAndView();
//		List<Location> location = locationDAO.getLocationsByName(zipCode);    
//		mv.addObject("location", location);
//		mv.setViewName("results");
//		return mv;
//	}
	
//	@RequestMapping(path = "getLocationByRating.do", method = RequestMethod.GET)
//	public ModelAndView getLocationByRating(@RequestParam("rating") Rating rating) {
//		ModelAndView mv = new ModelAndView();
//		List<Location> location = locationDAO.getLocationsByRating(rating);    
//		mv.addObject("location", location);
//		mv.setViewName("results");
//		return mv;
//	}
	
//	@RequestMapping(path = "getLocationByFlag.do", method = RequestMethod.GET)
//	public ModelAndView getLocationByFlag(@RequestParam("flag") Boolean flag) {
//		ModelAndView mv = new ModelAndView();
//		List<Location> location = locationDAO.getLocationsByFlag(flag);    
//		mv.addObject("location", location);
//		mv.setViewName("results");
//		return mv;
//	}
	
	@RequestMapping(path="searchOpenLocations.do", method = RequestMethod.GET)
	public ModelAndView addAddressLocationRestroom() {
		ModelAndView mv = new ModelAndView();
		List<Location> openLocations = locationDAO.getLocationsByOpen();
		mv.addObject("open", openLocations);
		mv.setViewName("results");
		return mv;
	}
	
	@RequestMapping(path="detailedResults.do", method = RequestMethod.GET)
	public ModelAndView detailsResultsPage(@RequestParam("locationId")int id) {
		ModelAndView mv = new ModelAndView();
		Location location = locationDAO.getLocationById(id);
		Double averageRating = locationDAO.getAverageRating(id);
		mv.addObject("location", location);
		mv.addObject("averageRating", averageRating);
		mv.setViewName("detailedResults");
		return mv;
	}
	
	@RequestMapping(path="detailedResultsFlagged.do", method = RequestMethod.GET)
	public ModelAndView detailsResultsPageByAdmin(@RequestParam("restroomId")int id) {
		ModelAndView mv = new ModelAndView();
		Restroom flaggedRestroom = restroomDAO.getRestroom(id);
		Location relatedLocation = locationDAO.getLocationById(flaggedRestroom.getLocation().getId());
		mv.addObject("location", relatedLocation);
		mv.setViewName("detailedResults");
		return mv;
	}
	
	@RequestMapping(path="getAllUsers.do", method = RequestMethod.POST)
	public ModelAndView getAllUsers() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("allUsersToDisableDelete", userDAO.listAllUsers());
		mv.setViewName("results");
		return mv;
	}
	
	@RequestMapping(path="getUsersByKeywords.do", method = RequestMethod.POST)
	public ModelAndView getUsersByKeywords(String keywords) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("allUsersToDisableDelete", userDAO.usersByKeywords(keywords));
		mv.setViewName("results");
		return mv;
	}
	@RequestMapping(path="searchLocationsToUpdatePage.do", method = RequestMethod.GET)
	public ModelAndView searchLocationToUpdatePage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("searchLocationUpdate", true);
		mv.setViewName("search");
		return mv;
	}
	@RequestMapping(path="searchLocationsToDeletePage.do", method = RequestMethod.GET)
	public ModelAndView searchLocationToDeletePage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("searchLocationDelete", true);
		mv.setViewName("search");
		return mv;
	}
	@RequestMapping(path="getLocationsByKeywordToDelete.do", method = RequestMethod.POST)
	public ModelAndView searchLocationToDelete(String keyword) {
		ModelAndView mv = new ModelAndView();
		Set<Location> locations = locationDAO.getLocationsByKeyword(keyword);
		mv.addObject("deleteDisableOption", true);
		mv.addObject("locations", locations);
		mv.setViewName("results");
		return mv;
	}
	@RequestMapping(path="listAllLocationsDelete.do", method = RequestMethod.POST)
	public ModelAndView allLocationsToDelete() {
		ModelAndView mv = new ModelAndView();
		List<Location> locations = locationDAO.getAllLocations();
		mv.addObject("deleteDisableOption", true);
		mv.addObject("locations", locations);
		mv.setViewName("results");
		return mv;
	}
	@RequestMapping(path="getLocationsByKeywordToUpdate.do", method = RequestMethod.POST)
	public ModelAndView searchLocationToUpdate(String keyword) {
		ModelAndView mv = new ModelAndView();
		Set<Location> locations = locationDAO.getLocationsByKeyword(keyword);
		mv.addObject("updateOption", true);
		mv.addObject("locations", locations);
		mv.setViewName("results");
		return mv;
	}
	@RequestMapping(path="listAllLocationsUpdate.do", method = RequestMethod.POST)
	public ModelAndView allLocationsToUpdate() {
		ModelAndView mv = new ModelAndView();
		List<Location> locations = locationDAO.getAllLocations();
		mv.addObject("updateOption", true);
		mv.addObject("locations", locations);
		mv.setViewName("results");
		return mv;
	}
	
	
}
