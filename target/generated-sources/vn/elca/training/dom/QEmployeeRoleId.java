package vn.elca.training.dom;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QEmployeeRoleId is a Querydsl query type for EmployeeRoleId
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QEmployeeRoleId extends BeanPath<EmployeeRoleId> {

    private static final long serialVersionUID = -549041748L;

    public static final QEmployeeRoleId employeeRoleId = new QEmployeeRoleId("employeeRoleId");

    public final NumberPath<Long> employeeId = createNumber("employeeId", Long.class);

    public final NumberPath<Long> roleId = createNumber("roleId", Long.class);

    public QEmployeeRoleId(String variable) {
        super(EmployeeRoleId.class, forVariable(variable));
    }

    public QEmployeeRoleId(Path<? extends EmployeeRoleId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEmployeeRoleId(PathMetadata<?> metadata) {
        super(EmployeeRoleId.class, metadata);
    }

}

