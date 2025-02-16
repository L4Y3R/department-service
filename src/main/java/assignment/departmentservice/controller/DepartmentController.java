package assignment.departmentservice.controller;

import assignment.departmentservice.entity.Department;
import assignment.departmentservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

  private final DepartmentRepository departmentRepository;

  public DepartmentController(DepartmentRepository departmentRepository) {
    this.departmentRepository = departmentRepository;
  }

  /**
   * Saves the department info
   *
   * @param department: department information.
   */
  @PostMapping("/create")
  public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
    try {
      Department savedDepartment = departmentRepository.save(department);
      return ResponseEntity.ok(savedDepartment);
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }

  /**
   * Retrieves the department info to a given id
   *
   * @param id: id that it needs to retrieve.
   */
  @GetMapping("/{id}")
  public ResponseEntity<Department> getDepartment(@PathVariable Long id) {
    try{
      return departmentRepository.findById(id)
              .map(ResponseEntity::ok)
              .orElse(ResponseEntity.notFound().build());
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }

  /**
   * Retrieves all departments.
   *
   * @return List of all departments.
   */
  @GetMapping("/all")
  public ResponseEntity<List<Department>> getAllDepartments() {
    try {
      List<Department> departments = departmentRepository.findAll();
      if (departments.isEmpty()) {
        return ResponseEntity.noContent().build();
      }
      return ResponseEntity.ok(departments);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
}
