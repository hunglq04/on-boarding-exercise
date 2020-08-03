package vn.elca.training.dom;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QRole is a Querydsl query type for Role
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QRole extends EntityPathBase<Role> {

    private static final long serialVersionUID = 1061556707L;

    public static final QRole role = new QRole("role");

    public final ListPath<EmployeeRole, QEmployeeRole> employeeRoles = this.<EmployeeRole, QEmployeeRole>createList("employeeRoles", EmployeeRole.class, QEmployeeRole.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QRole(String variable) {
        super(Role.class, forVariable(variable));
    }

    public QRole(Path<? extends Role> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRole(PathMetadata<?> metadata) {
        super(Role.class, metadata);
    }

}

