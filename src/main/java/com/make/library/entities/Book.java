package com.make.library.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String serialNo;
    private String name;
    private String authorName;
    private String category;
    private String status;
    private double cost;
    private LocalDate procurementDate;
    private LocalDate issueDate;
    private LocalDate returnDate;
    private LocalDate deadline;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(Long id, String serialNo, String name, String authorName, String category, String status, double cost,
			LocalDate procurementDate, LocalDate issueDate, LocalDate returnDate, LocalDate deadline) {
		super();
		this.id = id;
		this.serialNo = serialNo;
		this.name = name;
		this.authorName = authorName;
		this.category = category;
		this.status = status;
		this.cost = cost;
		this.procurementDate = procurementDate;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.deadline = deadline;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public LocalDate getProcurementDate() {
		return procurementDate;
	}
	public void setProcurementDate(LocalDate procurementDate) {
		this.procurementDate = procurementDate;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	public LocalDate getDeadline() {
		return deadline;
	}
	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", serialNo=" + serialNo + ", name=" + name + ", authorName=" + authorName
				+ ", category=" + category + ", status=" + status + ", cost=" + cost + ", procurementDate="
				+ procurementDate + ", issueDate=" + issueDate + ", returnDate=" + returnDate + ", deadline=" + deadline
				+ "]";
	}
    
    
}
//	public Book() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public Book(Long id, String serialNo, String name, String authorName, String category, String status, double cost,
//			LocalDate procurementDate) {
//		super();
//		this.id = id;
//		this.serialNo = serialNo;
//		this.name = name;
//		this.authorName = authorName;
//		this.category = category;
//		this.status = status;
//		this.cost = cost;
//		this.procurementDate = procurementDate;
//	}
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getSerialNo() {
//		return serialNo;
//	}
//	public void setSerialNo(String serialNo) {
//		this.serialNo = serialNo;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getAuthorName() {
//		return authorName;
//	}
//	public void setAuthorName(String authorName) {
//		this.authorName = authorName;
//	}
//	public String getCategory() {
//		return category;
//	}
//	public void setCategory(String category) {
//		this.category = category;
//	}
//	public String getStatus() {
//		return status;
//	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
//	public double getCost() {
//		return cost;
//	}
//	public void setCost(double cost) {
//		this.cost = cost;
//	}
//	public LocalDate getProcurementDate() {
//		return procurementDate;
//	}
//	public void setProcurementDate(LocalDate procurementDate) {
//		this.procurementDate = procurementDate;
//	}
//	@Override
//	public String toString() {
//		return "Book [id=" + id + ", serialNo=" + serialNo + ", name=" + name + ", authorName=" + authorName
//				+ ", category=" + category + ", status=" + status + ", cost=" + cost + ", procurementDate="
//				+ procurementDate + "]";
//	}
//}