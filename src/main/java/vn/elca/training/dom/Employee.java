package vn.elca.training.dom;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {
    @Id@GeneratedValue
    private Long id;
    @Column(length = 3, unique = true)
    private String visa;
//    @OneToMany(mappedBy = "employee")
//    private List<EmployeeProject> employeeProjects;
//    @OneToMany(mappedBy = "employee")
//    private List<EmployeeRole> employeeRoles;
//    @OneToMany(mappedBy = "leader")
//    private List<Group> groups;
//    @OneToMany(mappedBy = "leader")
//    private List<Project> projects;

    public Employee(String visa) {
        this.visa = visa;
    }
}
