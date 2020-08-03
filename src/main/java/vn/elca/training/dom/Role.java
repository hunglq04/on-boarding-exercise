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
public class Role {
    @Id@GeneratedValue
    private Long id;
    @Column
    private String name;
    @OneToMany(mappedBy = "role")
    private List<EmployeeRole> employeeRoles;
}
