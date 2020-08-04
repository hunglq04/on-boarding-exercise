package vn.elca.training.dom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class EmployeeProjectId implements Serializable {
    @Column(name = "employee_id")
    private Long employeeId;
    @Column(name = "project_id")
    private Long projectId;
}
