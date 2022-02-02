package com.dagacube.casinopoc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Root {
	@GetMapping("/")
	public String greeting() {
		return "Dagacube Casino POC.";
	 }
}
