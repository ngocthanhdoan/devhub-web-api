package com.devhub.io.vn.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiController {
	@RequestMapping(value = "/", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getIndex() {
		return "helloworld";
	}
	@RequestMapping(value = "")
	@ResponseBody
	public String getIndex1() {
		
		return "helloworld";
	}
}
