package assignment.departmentservice.repository;

import assignment.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository <Department, Long>{
}
