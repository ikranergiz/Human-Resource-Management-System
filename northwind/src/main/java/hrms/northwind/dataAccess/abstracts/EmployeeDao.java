package hrms.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.northwind.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	
}
