package vn.elca.training.dom;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.mapping.Join;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
public class EmployeeRole implements Serializable {

    @Id@GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Employee employee;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Role role;

    public EmployeeRole() {
        this.employee = new Employee();
        this.role = new Role();
    }

    public EmployeeRole(Employee employee, Role role) {
        this.employee = employee;
        this.role = role;
    }
}
