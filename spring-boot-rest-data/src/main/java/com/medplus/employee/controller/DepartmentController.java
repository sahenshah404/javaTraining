package com.medplus.employee.controller;

import java.util.List;
import java.util.Optional;

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

import com.medplus.employee.entities.Department;
import com.medplus.employee.service.DepartmentService;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/dept")
public class DepartmentController {
	@Autowired
	DepartmentService deptService;

	@PostMapping("/addDept")
	public ResponseEntity<String> addDepartment(@RequestBody Department dept) {
		deptService.addDepartment(dept);
		return new ResponseEntity<String>("Inserted", HttpStatus.OK);
	}

	@GetMapping("/GetDepts")
	public ResponseEntity<List<Department>> getAllDepartments() {
		List<Department> deptList = deptService.getAllDepartments();
		return new ResponseEntity<List<Department>>(deptList, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateDepartment(@RequestBody Department dept) {
		deptService.updateDepartment(dept);
		return new ResponseEntity<String>("Updated", HttpStatus.OK);
	}

	@DeleteMapping("/delete/{deptCode}")
	public ResponseEntity<String> deleteDepartment(@PathVariable int deptNo) {
		deptService.deleteDepartment(deptNo);
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}

	@GetMapping("/{deptNo}")
	public ResponseEntity<Optional<Department>> getDepartment(@PathVariable int deptNo) {
		Optional<Department> dept = deptService.getDepartmentByDeptNo(deptNo);
		return new ResponseEntity<Optional<Department>>(dept, HttpStatus.OK);
	}
}