package com.medplus.employee.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medplus.employee.dto.EmployeeDTO;
import com.medplus.employee.service.EmployeeService;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@PostMapping("/addEmployee")
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
		employeeService.addEmployee(employeeDTO);
		return new ResponseEntity<String>("Inserted", HttpStatus.OK);
	}

	@GetMapping("/getAllEmps")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployee() {
		List<EmployeeDTO> empList = employeeService.getAllEmployees();
		return new ResponseEntity<List<EmployeeDTO>>(empList, HttpStatus.OK);
	}

	@GetMapping("/{code}")
	public ResponseEntity<EmployeeDTO> getEmployeeByCode(@PathVariable("code") int code) {
		EmployeeDTO employee = employeeService.getEmployeeByCode(code);
		return new ResponseEntity<EmployeeDTO>(employee, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
		employeeService.updateEmployee(employeeDTO);
		return new ResponseEntity<String>("updated", HttpStatus.OK);
	}

	@DeleteMapping("/delete/{code}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int code) {
		employeeService.deleteEmployee(code);
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}

	@GetMapping("/doj/{date}")
	public ResponseEntity<List<EmployeeDTO>> getEmployeesByDoj(@PathVariable String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<EmployeeDTO> emplist = employeeService.getEmployeesByDoj(sdf.parse(date));
		return new ResponseEntity<List<EmployeeDTO>>(emplist, HttpStatus.OK);
	}

	@GetMapping("/job/{job}")
	public ResponseEntity<List<EmployeeDTO>> getEmployeesByJob(@PathVariable String job) {
		List<EmployeeDTO> emplist = employeeService.getEmployeesByJob(job);
		return new ResponseEntity<List<EmployeeDTO>>(emplist, HttpStatus.OK);
	}
}
