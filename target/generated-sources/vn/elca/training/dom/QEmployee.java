package vn.elca.training.dom;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QEmployee is a Querydsl query type for Employee
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QEmployee extends EntityPathBase<Employee> {

    private static final long serialVersionUID = 2139290011L;

    public static final QEmployee employee = new QEmployee("employee");

    public final ListPath<EmployeeProject, QEmployeeProject> employeeProjects = this.<EmployeeProject, QEmployeeProject>createList("employeeProjects", EmployeeProject.class, QEmployeeProject.class, PathInits.DIRECT2);

    public final ListPath<EmployeeRole, QEmployeeRole> employeeRoles = this.<EmployeeRole, QEmployeeRole>createList("employeeRoles", EmployeeRole.class, QEmployeeRole.class, PathInits.DIRECT2);

    public final ListPath<Group, QGroup> groups = this.<Group, QGroup>createList("groups", Group.class, QGroup.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath visa = createString("visa");

    public QEmployee(String variable) {
        super(Employee.class, forVariable(variable));
    }

    public QEmployee(Path<? extends Employee> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEmployee(PathMetadata<?> metadata) {
        super(Employee.class, metadata);
    }

}

