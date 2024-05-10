package com.make.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	@GetMapping("/map-register")
	public String registerMapping() {
		return "register";
	}
	
	@GetMapping("/map-login")
	public String loginMapping() {
		return "login";
	}
	
//	//maintenance(Only admin)
//	@GetMapping("/map-maintenance")
//	public String maintenanceMapping() {
//		return "maintenance";
//	}
//	@GetMapping("/map-addmembership")
//	public String addmembershipMapping() {
//		return "addmembership";
//	}
//	@GetMapping("/map-updatemembership")
//	public String updateMembershipMapping() {
//		return "updatemembership";
//	}
//	@GetMapping("/map-addbook")
//	public String bookMapping() {
//		return "addbook";
//	}
//	@GetMapping("/map-updatebook")
//	public String updatebookMapping() {
//		return "updatebook";
//	}
//	
//	//reports
//	@GetMapping("/map-reports")
//	public String reportsMapping() {
//		return "reports";
//	}
//	@GetMapping("/map-activeissues")
//	public String activeissueMapping() {
//		return "activeissue";
//	}
//	@GetMapping("/map-masterlistmembership")
//	public String listMembershipMapping() {
//		return "listmembership";
//	}
//	@GetMapping("/map-masterlistmovies")
//	public String listmoviesMapping() {
//		return "listmovies";
//	}
//	@GetMapping("/map-masterlistbook")
//	public String listbookMapping() {
//		return "listbook";
//	}
//	@GetMapping("/map-overduereturn")
//	public String overduereturnMapping() {
//		return "overduereturn";
//	}
//	@GetMapping("/map-pendingrequest")
//	public String pendingrequestMapping() {
//		return "pendingrequest";
//	}
//	
	
//	//transaction
//	@GetMapping("/map-transaction")
//	public String transactionMapping() {
//		return "transaction";
//	}
//	@GetMapping("/map-availability")
//	public String availabilityMapping() {
//		return "bookAvailable";
//	}
//	@GetMapping("/map-issuebook")
//	public String issuebookMapping() {
//		return "bookIssue";
//	}
//	@GetMapping("/map-returnbook")
//	public String returnbookMapping() {
//		return "returnBook";
//	}
	
}