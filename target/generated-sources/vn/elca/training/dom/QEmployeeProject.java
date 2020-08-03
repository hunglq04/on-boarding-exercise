package vn.elca.training.dom;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QEmployeeProject is a Querydsl query type for EmployeeProject
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QEmployeeProject extends EntityPathBase<EmployeeProject> {

    private static final long serialVersionUID = -1526598402L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEmployeeProject employeeProject = new QEmployeeProject("employeeProject");

    public final QEmployee employee;

    public final QProject project;

    public QEmployeeProject(String variable) {
        this(EmployeeProject.class, forVariable(variable), INITS);
    }

    public QEmployeeProject(Path<? extends EmployeeProject> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QEmployeeProject(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QEmployeeProject(PathMetadata<?> metadata, PathInits inits) {
        this(EmployeeProject.class, metadata, inits);
    }

    public QEmployeeProject(Class<? extends EmployeeProject> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.employee = inits.isInitialized("employee") ? new QEmployee(forProperty("employee")) : null;
        this.project = inits.isInitialized("project") ? new QProject(forProperty("project"), inits.get("project")) : null;
    }

}

