//Library Management System
//001--
//Controller--
//a.NavController
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
}
b.UsersController
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
}
//Entity
//Users
package com.make.library.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String username;
	String email;
	String password;
	String gender;
	String role;
	String address;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String username, String email, String password, String gender, String role, String address) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.role = role;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", gender=" + gender + ", role=" + role + ", address=" + address + "]";
	}
	
}
//Repositories
package com.make.library.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.make.library.entities.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	
	public User findByEmail(String email);

}
//Services
//a.UserService
package com.make.library.services;

import com.make.library.entities.User;


public interface UserService {
	public String addUser(User user);

	public boolean emailExists(String email);
	public boolean validateUser(String email,String password);
	public String getRole(String email);

	public User getUser(String email);

	public void updateUser(User user);
}
//UserServiceImpl
package com.make.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.make.library.entities.User;
import com.make.library.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository repo;
	
	@Override
	public String addUser(User user) {
		repo.save(user);
		return "user is created and saved";
	}

	@Override
	public boolean emailExists(String email) {
		if(repo.findByEmail(email)==null){
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean validateUser(String email, String password) {
		
		User user=repo.findByEmail(email);
		String db_password=user.getPassword();
		if(db_password.equals(password)) {
			return true;
		}
		else {
			return false;
		}
	}
    public String getRole(String email) {
		
    	return (repo.findByEmail(email).getRole());
		
		
		
	}

	@Override
	public User getUser(String email) {
		
		
		return repo.findByEmail(email);
	}

	@Override
	public void updateUser(User user) {
		repo.save(user);
		
	}
	

}
//002-
//src/main/resources
//templates
//a.index.html
<!DOCTYPE html>
<html lang="ar" dir="rtl">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.rtl.min.css" integrity="sha384-dpuaG1suU0eT09tx5plTaGMLBsfDLzUCCUXOY2j/LSvXYuG6Bqs43ALlhIqAJVRb" crossorigin="anonymous">

    <title>Welcome user's</title>
  </head>
  <body>
    

<h1>Welcome to Tune Hub Application</h1>
<a href="/map-register">Click here to register</a>
<br/><br/>
<a href="/map-login">Click here to login</a>
</body>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

    
  </body>
</html>
//b.login.html
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="/login" method="post">
<label>Email ID:   </label>
<input type="email" name="email" required="required"/>
<br/><br/>

<label>Password:   </label>
<input type="password" name="password" required="required"/>
<br/><br/>
<input type="submit" value="LOGIN"/>
</form> 
</body>
</html>

//c.Register.html
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="/register" method="post">

<label>Username   </label>
<input type="text" name="username" required="required">
<br/><br/>

<label>Email ID   </label>
<input type="email" name="email" required="required">
<br/><br/>

<label>Password   </label>
<input type="password" name="password" required="required">
<br/><br/>
<label>Gender </label>
M<input type="radio" name="gender" value="Male">
F<input type="radio" name="gender" value="Female">
O<input type="radio" name="gender" value="Other">
<br/><br/>
<label>Role </label>

Admin<input type="radio" name="role" value="admin">
User<input type="radio" name="role" value="customer">
<br/><br/>
<label>Address:</label>
<textarea name="address"></textarea>
<br/><br/>
<input type="submit" value="REGISTER"/>
</form>
</body>
</html>
//d.bookIssue.html
<form th:action="@{/issueBook}" method="post">
    <label for="bookName">Name of Book:</label>
    <input type="text" id="bookName" name="bookName" required><br>

    <!-- Other fields and validations -->
    <label for="issueDate">Issue Date:</label>
    <input type="date" id="issueDate" name="issueDate" min="2024-05-15" required><br>

    <label for="returnDate">Return Date:</label>
    <input type="date" id="returnDate" name="returnDate" min="2024-05-16" max="2024-05-30" required><br>

    <label for="remarks">Remarks:</label>
    <input type="text" id="remarks" name="remarks"><br>

    <button type="submit">Issue Book</button>
</form>
//e.<form th:action="@{/returnBook}" method="post">
    <label for="bookName">Name of Book:</label>
    <input type="text" id="bookName" name="bookName" required><br>

    <!-- Other fields and validations -->
    <label for="serialNo">Serial No:</label>
    <input type="text" id="serialNo" name="serialNo" required><br>

    <label for="returnDate">Return Date:</label>
    <input type="date" id="returnDate" name="returnDate" min="2024-05-16" max="2024-05-30" required><br>

    <button type="submit">Return Book</button>
</form>
//f.transactions.html
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Transactions</title>
</head>
<body>
    <h1>Transactions</h1>
    <ul>
        <li>
            <label>Is book available?</label>
            <a href="#">Check availability</a>
        </li>
        <li>
            <label>Issue book?</label>
            <a href="#">Issue book</a>
        </li>
        <li>
            <label>Return book?</label>
            <a href="#">Return book</a>
        </li>
        <li>
            <label>Pay Fine?</label>
            <a href="#">Pay Fine</a>
        </li>
        <li>
            <label>Log Out</label>
            <a href="/logout">Log Out</a>
        </li>
    </ul>
</body>
</html>
//g.bookAvailable
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Transactions</title>
</head>
<body>
    <h1>Transactions</h1>
    
    <form th:action="@{/search}" method="get">
        <label>Search:</label>
        <input type="text" name="keyword">
        <button type="submit">Search</button>
    </form>
    
    <ul>
        <li>
            <label>Is book available?</label>
            <a href="#">Check availability</a>
        </li>
        <li>
            <label>Issue book?</label>
            <form th:action="@{/issueBook}" method="post">
                <input type="text" name="bookName" placeholder="Enter Book Name" required>
                <select name="category">
                    <option value="book">Book</option>
                    <option value="movie">Movie</option>
                </select>
                <button type="submit">Issue book</button>
            </form>
        </li>
        <li>
            <label>Return book?</label>
            <form th:action="@{/returnBook}" method="post">
                <input type="text" name="author" placeholder="Enter Author" required>
                <select name="category">
                    <option value="book">Book</option>
                    <option value="movie">Movie</option>
                </select>
                <button type="submit">Return book</button>
            </form>
        </li>
        <li>
            <label>Pay Fine?</label>
            <a href="#">Pay Fine</a>
        </li>
        <li>
            <button onclick="history.back()">Back</button>
        </li>
        <li>
            <a href="/logout">Log Out</a>
        </li>
    </ul>
</body>
</html>
//g.bookissue
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Issue</title>
</head>
<body>
    <h1>Book Issue</h1>
    
    <form th:action="@{/issueBook}" method="post">
        <label for="bookName">Enter Book Name:</label>
        <input type="text" id="bookName" name="bookName" required><br>
        
        <label for="author">Enter Author:</label>
        <input type="text" id="author" name="author" required><br>
        
        <label for="issueDate">Issue Date:</label>
        <input type="date" id="issueDate" name="issueDate" min="2024-05-15" value="2024-05-15" required><br>
        
        <label for="returnDate">Return Date:</label>
        <input type="date" id="returnDate" name="returnDate" min="2024-05-16" max="2024-05-30" value="2024-05-30" required><br>
        
        <label for="remarks">Remarks:</label>
        <textarea id="remarks" name="remarks"></textarea><br>
        
        <button type="submit">Issue Book</button>
    </form>
    
    <a href="/logout">Log Out</a>
</body>
</html>
//h.returnbook
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Return Book</title>
</head>
<body>
    <h1>Return Book</h1>
    
    <form th:action="@{/returnBook}" method="post">
        <label for="bookName">Enter Book Name:</label>
        <input type="text" id="bookName" name="bookName" required><br>
        
        <label for="author">Enter Author:</label>
        <input type="text" id="author" name="author" required><br>
        
        <label for="serialNo">Serial No:</label>
        <input type="text" id="serialNo" name="serialNo" required><br>
        
        <label for="issueDate">Issue Date:</label>
        <input type="text" id="issueDate" name="issueDate" required><br>
        
        <label for="returnDate">Return Date:</label>
        <input type="date" id="returnDate" name="returnDate" min="2024-05-16" max="2024-05-30" value="2024-05-30" required><br>
        
        <label for="remarks">Remarks:</label>
        <textarea id="remarks" name="remarks"></textarea><br>
        
        <button type="submit">Return Book</button>
    </form>
    
    <a href="/logout">Log Out</a>
</body>
</html>
//i.Reports
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
    <h1>Home</h1>
    
    <ul>
        <li>
            <label>Available Reports:</label>
            <a href="#">View Reports</a>
        </li>
        <li>
            <label>Master List of Books:</label>
            <a href="#">View Books</a>
        </li>
        <li>
            <label>Master List of Movies:</label>
            <a href="#">View Movies</a>
        </li>
        <li>
            <label>Master List of Memberships:</label>
            <a href="#">View Memberships</a>
        </li>
        <li>
            <label>Active Issues:</label>
            <a href="#">View Active Issues</a>
        </li>
        <li>
            <label>Overdue Returns:</label>
            <a href="#">View Overdue Returns</a>
        </li>
        <li>
            <label>Pending Issue Requests:</label>
            <a href="#">View Pending Issue Requests</a>
        </li>
        <li>
            <a href="/logout">Log Out</a>
        </li>
    </ul>
</body>
</html>
//j.List of books
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Master List of Books</title>
</head>
<body>
    <h1>Master List of Books</h1>
    
    <table border="1">
        <thead>
            <tr>
                <th>Serial No</th>
                <th>Name of Book</th>
                <th>Author Name</th>
                <th>Category</th>
                <th>Status</th>
                <th>Cost</th>
                <th>Procurement Date</th>
            </tr>
        </thead>
        <tbody>
            <!-- Iterate over the list of books -->
            <tr th:each="book : ${books}">
                <td th:text="${book.serialNo}"></td>
                <td th:text="${book.name}"></td>
                <td th:text="${book.author}"></td>
                <td th:text="${book.category}"></td>
                <td th:text="${book.status}"></td>
                <td th:text="${book.cost}"></td>
                <td th:text="${book.procurementDate}"></td>
            </tr>
        </tbody>
    </table>
    
    <a href="/home">Home</a>
    <a href="/logout">Log Out</a>
</body>
</html>
//k.Memebership list book
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of Active Memberships</title>
</head>
<body>
    <h1>List of Active Memberships</h1>
    
    <table border="1">
        <thead>
            <tr>
                <th>Membership Id</th>
                <th>Name of Member</th>
                <th>Contact Number</th>
                <th>Contact Address</th>
                <th>Aadhar Card No</th>
                <th>Start Date of Membership</th>
                <th>End Date of Membership</th>
                <th>Status</th>
                <th>Amount Pending (Fine)</th>
            </tr>
        </thead>
        <tbody>
            <!-- Iterate over the list of active memberships -->
            <tr th:each="membership : ${activeMemberships}">
                <td th:text="${membership.membershipId}"></td>
                <td th:text="${membership.memberName}"></td>
                <td th:text="${membership.contactNumber}"></td>
                <td th:text="${membership.contactAddress}"></td>
                <td th:text="${membership.aadharCardNo}"></td>
                <td th:text="${membership.startDate}"></td>
                <td th:text="${membership.endDate}"></td>
                <td th:text="${membership.status}"></td>
                <td th:text="${membership.amountPending}"></td>
            </tr>
        </tbody>
    </table>
    
    <a href="/home">Home</a>
    <a href="/logout">Log Out</a>
</body>
</html>
//l.add membership
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Library Management System</title>
</head>
<body>
    <!-- Navigation Bar -->
    <div>
        <a th:href="@{/home}">Home</a>
        <a th:href="@{/logout}">Log Out</a>
    </div>

    <!-- Membership Form -->
    <h2>Membership</h2>
    <form th:action="@{/addMembership}" method="post">
        <input type="text" name="firstName" placeholder="First Name" required><br>
        <input type="text" name="lastName" placeholder="Last Name" required><br>
        <input type="text" name="contactName" placeholder="Contact Name" required><br>
        <input type="text" name="contactAddress" placeholder="Contact Address" required><br>
        <input type="text" name="aadharCardNo" placeholder="Aadhar Card No" required><br>
        <label for="startDate">Start Date:</label>
        <input type="date" id="startDate" name="startDate" required><br>
        <label for="endDate">End Date:</label>
        <input type="date" id="endDate" name="endDate" required><br>
        <label for="sixMonths">Membership:</label>
        <input type="radio" id="sixMonths" name="membership" value="sixMonths" required> Six Months
        <input type="radio" id="oneYear" name="membership" value="oneYear" required> One Year
        <input type="radio" id="twoYears" name="membership" value="twoYears" required> Two Years<br>
        <button type="submit">Add Membership</button>
    </form>

    <!-- User Management Form -->
    <h2>User Management</h2>
    <form th:action="@{/addUser}" method="post">
        <!-- Add user management fields here -->
    </form>

    <!-- Books/Movies Form -->
    <h2>Books/Movies</h2>
    <form th:action="@{/addBook}" method="post">
        <!-- Add book/movie fields here -->
    </form>
</body>
</html>


//003-Database connectivity
spring.application.name=librarymanagement
server.port=1212

spring.datasource.url=jdbc:mysql://localhost/library_management
spring.datasource.username=root
spring.datasource.password=Tarun@9621@9621
spring.jpa.hibernate.ddl-auto=update

