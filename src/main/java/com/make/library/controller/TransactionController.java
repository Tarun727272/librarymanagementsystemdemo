package com.make.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class TransactionController {
	//transaction
		@GetMapping("/map-transaction")
		public String transactionMapping() {
			return "transaction";
		}
		@GetMapping("/map-availability")
		public String availabilityMapping() {
			return "checkavailability";
		}
		@GetMapping("/map-issuebook")
		public String issuebookMapping() {
			return "issuebook";
		}
		@GetMapping("/map-returnbook")
		public String returnbookMapping() {
			return "returnBook";
		}
		@GetMapping("/map-payfine")
		public String payfineMapping() {
			return "payfine";
		}
}
