package vn.elca.training.dom;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
public class EmployeeRole implements Serializable {

    @Id@ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;
    @Id@ManyToOne(fetch = FetchType.LAZY)
    private Role role;

    public EmployeeRole() {
        this.employee = new Employee();
        this.role = new Role();
    }
}
