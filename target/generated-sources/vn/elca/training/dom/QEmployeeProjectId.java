package vn.elca.training.dom;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QEmployeeProjectId is a Querydsl query type for EmployeeProjectId
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QEmployeeProjectId extends BeanPath<EmployeeProjectId> {

    private static final long serialVersionUID = 1817753273L;

    public static final QEmployeeProjectId employeeProjectId = new QEmployeeProjectId("employeeProjectId");

    public final NumberPath<Long> employeeId = createNumber("employeeId", Long.class);

    public final NumberPath<Long> projectId = createNumber("projectId", Long.class);

    public QEmployeeProjectId(String variable) {
        super(EmployeeProjectId.class, forVariable(variable));
    }

    public QEmployeeProjectId(Path<? extends EmployeeProjectId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEmployeeProjectId(PathMetadata<?> metadata) {
        super(EmployeeProjectId.class, metadata);
    }

}

