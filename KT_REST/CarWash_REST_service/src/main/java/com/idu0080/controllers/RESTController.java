package com.idu0080.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idu0080.entities.WashInput;
import com.idu0080.services.WashInputServices;

@Controller
public class RESTController {

	@Autowired
	WashInputServices washInputServices;
	
	@RequestMapping(value="/service/washinputs",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<WashInput> getAll(WashInput washInput) {
		List<WashInput> inputs = washInputServices.getAllInputs();
		
		return inputs;
	}
}
