package vn.elca.training.dom;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QProject is a Querydsl query type for Project
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QProject extends EntityPathBase<Project> {

    private static final long serialVersionUID = -694442356L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProject project = new QProject("project");

    public final SetPath<EmployeeProject, QEmployeeProject> employees = this.<EmployeeProject, QEmployeeProject>createSet("employees", EmployeeProject.class, QEmployeeProject.class, PathInits.DIRECT2);

    public final DateTimePath<java.util.Date> finishingDate = createDateTime("finishingDate", java.util.Date.class);

    public final QGroup group;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final SetPath<Task, QTask> tasks = this.<Task, QTask>createSet("tasks", Task.class, QTask.class, PathInits.DIRECT2);

    public QProject(String variable) {
        this(Project.class, forVariable(variable), INITS);
    }

    public QProject(Path<? extends Project> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProject(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProject(PathMetadata<?> metadata, PathInits inits) {
        this(Project.class, metadata, inits);
    }

    public QProject(Class<? extends Project> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.group = inits.isInitialized("group") ? new QGroup(forProperty("group"), inits.get("group")) : null;
    }

}

