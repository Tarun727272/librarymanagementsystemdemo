package com.make.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MaintenanceController {
	//maintenance(Only admin)
		@GetMapping("/map-maintenance")
		public String maintenanceMapping() {
			return "maintenance";
		}
		
		@GetMapping("/map-addbook")
		public String bookMapping() {
			return "addbook";
		}
		
		@GetMapping("/map-viewbook")
		public String viewbookMapping() {
			return "viewbook";
		}
		

}
