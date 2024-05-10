package com.make.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportsController {
	//reports
		@GetMapping("/map-reports")
		public String reportsMapping() {
			return "reports";
		}
		@GetMapping("/map-activeissues")
		public String activeissueMapping() {
			return "activeissue";
		}
		@GetMapping("/map-masterlistmembership")
		public String listMembershipMapping() {
			return "listmembership";
		}
		@GetMapping("/map-masterlistmovies")
		public String listmoviesMapping() {
			return "listmovies";
		}
		@GetMapping("/map-masterlistbook")
		public String listbookMapping() {
			return "listbook";
		}
		@GetMapping("/map-overduereturn")
		public String overduereturnMapping() {
			return "overduereturn";
		}
		@GetMapping("/map-pendingrequest")
		public String pendingrequestMapping() {
			return "pendingrequest";
		}
		
}
