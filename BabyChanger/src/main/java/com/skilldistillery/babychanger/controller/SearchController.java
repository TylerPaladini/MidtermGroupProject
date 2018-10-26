package com.skilldistillery.babychanger.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.babychanger.data.LocationDAO;
import com.skilldistillery.babychanger.entities.Gender;
import com.skilldistillery.babychanger.entities.Location;
import com.skilldistillery.babychanger.entities.Rating;

@Controller
public class SearchController {
	@Autowired
	private LocationDAO locationDAO; 

	@RequestMapping(path = "getBathrooms.do", method = RequestMethod.GET)
	  public ModelAndView get(@RequestParam("id") int id) {
	    ModelAndView mv = new ModelAndView();

	    Location location = locationDAO.getLocationById(id);    

	    mv.addObject("location", location);
	    mv.setViewName("results");
	    return mv;
	  }
	
	@RequestMapping(path = "getLocationsByCity.do", method = RequestMethod.GET)
	public ModelAndView getLocationsByCity(@RequestParam("city") String city) {
		ModelAndView mv = new ModelAndView();
		
		List<Location> location = locationDAO.getLocationsByCity(city);    
		
		mv.addObject("location", location);
		mv.setViewName("results");
		return mv;
	}
	
	@RequestMapping(path = "getLocationsByState.do", method = RequestMethod.GET)
	public ModelAndView getLocationsByState(@RequestParam("state") String state) {
		ModelAndView mv = new ModelAndView();
		
		List<Location> location = locationDAO.getLocationsByState(state);    
		
		mv.addObject("location", location);
		mv.setViewName("results");
		return mv;
	}
	
	@RequestMapping(path = "getLocationsByKeyword.do", method = RequestMethod.GET)
	public ModelAndView getLocationsByKeyword(@RequestParam("keyword") String keyword) {
		ModelAndView mv = new ModelAndView();
		
		List<Location> location = locationDAO.getLocationByKeyword(keyword);    
		
		mv.addObject("location", location);
		mv.setViewName("results");
		return mv;
	}
	
	@RequestMapping(path = "getLocationLikeAddress.do", method = RequestMethod.GET)
	public ModelAndView getLocationLikeAddress(@RequestParam("addressLike") String addressLike) {
		ModelAndView mv = new ModelAndView();
		
		List<Location> location = locationDAO.getLocationLikeAddress(addressLike);    
		
		mv.addObject("location", location);
		mv.setViewName("results");
		return mv;
	}
	
	@RequestMapping(path = "getLocationByGender.do", method = RequestMethod.GET)
	public ModelAndView getLocationByGender(@RequestParam("addressLike") Gender gender) {
		ModelAndView mv = new ModelAndView();
		
		List<Location> location = locationDAO.getLocationByGender(gender);    
		
		mv.addObject("location", location);
		mv.setViewName("results");
		return mv;
	}
	
	@RequestMapping(path = "getLocationByName.do", method = RequestMethod.GET)
	public ModelAndView getLocationByName(@RequestParam("name") String name) {
		ModelAndView mv = new ModelAndView();
		
		List<Location> location = locationDAO.getLocationByName(name);    
		
		mv.addObject("location", location);
		mv.setViewName("results");
		return mv;
	}
	
	@RequestMapping(path = "getLocationByZipCode.do", method = RequestMethod.GET)
	public ModelAndView getLocationByZipCode(@RequestParam("zipCode") String zipCode) {
		ModelAndView mv = new ModelAndView();
		
		List<Location> location = locationDAO.getLocationByName(zipCode);    
		
		mv.addObject("location", location);
		mv.setViewName("results");
		return mv;
	}
	
	@RequestMapping(path = "getLocationByRating.do", method = RequestMethod.GET)
	public ModelAndView getLocationByRating(@RequestParam("rating") Rating rating) {
		ModelAndView mv = new ModelAndView();
		
		List<Location> location = locationDAO.getLocationByRating(rating);    
		
		mv.addObject("location", location);
		mv.setViewName("results");
		return mv;
	}
	
	@RequestMapping(path = "getLocationByFlag.do", method = RequestMethod.GET)
	public ModelAndView getLocationByFlag(@RequestParam("flag") Boolean flag) {
		ModelAndView mv = new ModelAndView();
		
		List<Location> location = locationDAO.getLocationByFlag(flag);    
		
		mv.addObject("location", location);
		mv.setViewName("results");
		return mv;
	}
	
	@RequestMapping(path = "getLocationByOpen.do", method = RequestMethod.GET)
	public ModelAndView getLocationByOpen(Date open, Date close) {
		ModelAndView mv = new ModelAndView();
		
		List<Location> location = locationDAO.getLocationByOpen(open, close);    
		
		mv.addObject("location", location);
		mv.setViewName("results");
		return mv;
	}
	
}
