package vn.elca.training.dom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRoleId implements Serializable {
    @Column(name = "employee_id")
    private Long employeeId;
    @Column(name = "role_id")
    private Long roleId;
}
