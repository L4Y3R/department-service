package assignment.departmentservice.entity;

import jakarta.persistence.*;

@Entity
public class Department {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false, unique = true)
  private String name;
  public String description;
  public String location;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }
}
