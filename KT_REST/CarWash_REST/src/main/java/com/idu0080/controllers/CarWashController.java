package com.idu0080.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.idu0080.entities.Wash;
import com.idu0080.entities.WashInput;
import com.idu0080.services.RESTWashInputService;
import com.idu0080.services.WashServices;



@Controller
@RequestMapping(value="wash")
public class CarWashController {
	
	@Autowired
	private WashServices washServices;
	
	@Autowired
	private RESTWashInputService restWashInputService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView getPage() {
		ModelAndView view = new ModelAndView("index");
		return view;
	}
	
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> getSaved(Wash carWash) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(washServices.createOrUpdateWash(carWash)) {
			map.put("status", "200");
			map.put("message", "Autopesu edukalt salvestatud");
		} else {
			System.out.println("saving data unsuccess ... ");
		}
		
		return map;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getAll(Wash carWash) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Wash> list = washServices.getAllWashes();
		
		if(list != null) {
			map.put("status", "200");
			map.put("message", "Data found");
			map.put("data", list);
		} else {
			map.put("status", "404");
			map.put("message", "Data not found");
		}
		
		return map;
	}
	
	@Transactional
	@RequestMapping(value = "/delete/wash/{wash_id}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteWash(@PathVariable String wash_id) {
		washServices.deleteWash(wash_id);
	}
	
	@RequestMapping(value = "/service/external/washInputs", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<WashInput> getExternalWashInputs(HttpServletResponse response) throws IOException{
		List<WashInput> washInputs = restWashInputService.getAllWashInputs();
		return washInputs;
	}
	
	@RequestMapping(value="service/search", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Wash> searchCarWashes(@RequestParam(value="wash_type") String washType) throws IOException {
		List<Wash> washes = washServices.searchByWashType(washType);
		return washes;
	}
	
	@RequestMapping(value="/service/wash", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Wash getWash(@RequestParam(value="wash_id") String id) throws IOException{
			
		Wash wash = washServices.getWashById(id);
		return wash;
	}
}
