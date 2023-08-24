package com.web.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.model.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	//public List<Employee> findByNameStartingWith(String findBynameStartingWith);

	public List<Employee> findByNameLike(String findBynNameLike);

}
