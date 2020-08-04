package vn.elca.training.dom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {
    @Id@GeneratedValue
    private Long id;
    @Column
    private String name;
//    @OneToMany(mappedBy = "role")
//    private List<EmployeeRole> employeeRoles;
    public Role(String name) {
        this.name = name;
    }
}
