package vn.elca.training.dom;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QEmployeeRole is a Querydsl query type for EmployeeRole
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QEmployeeRole extends EntityPathBase<EmployeeRole> {

    private static final long serialVersionUID = -1408390991L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEmployeeRole employeeRole = new QEmployeeRole("employeeRole");

    public final QEmployee employee;

    public final QRole role;

    public QEmployeeRole(String variable) {
        this(EmployeeRole.class, forVariable(variable), INITS);
    }

    public QEmployeeRole(Path<? extends EmployeeRole> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QEmployeeRole(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QEmployeeRole(PathMetadata<?> metadata, PathInits inits) {
        this(EmployeeRole.class, metadata, inits);
    }

    public QEmployeeRole(Class<? extends EmployeeRole> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.employee = inits.isInitialized("employee") ? new QEmployee(forProperty("employee")) : null;
        this.role = inits.isInitialized("role") ? new QRole(forProperty("role")) : null;
    }

}

