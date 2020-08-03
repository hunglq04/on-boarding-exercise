package vn.elca.training.dom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id@GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column(length = 3, unique = true)
    private String visa;
    @OneToMany(mappedBy = "employee")
    private List<EmployeeProject> employeeProjects;
    @OneToMany(mappedBy = "employee")
    private List<EmployeeRole> employeeRoles;
    @OneToMany(mappedBy = "employee")
    private List<Group> groups;
}
