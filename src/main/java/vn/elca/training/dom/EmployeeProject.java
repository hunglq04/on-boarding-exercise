package vn.elca.training.dom;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
public class EmployeeProject implements Serializable {
    @Id@GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Employee employee;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Project project;

    public EmployeeProject() {
        this.employee = new Employee();
        this.project = new Project();
    }

    public EmployeeProject(Employee employee, Project project) {
        this.employee = employee;
        this.project = project;
    }
}
